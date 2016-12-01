package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import auxiliares.MostraProduto;
import auxiliares.Session;
import dao.ClienteDAO;
import dao.PedidoDAO;
import dao.PedidoProdutoDAO;
import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Cliente;
import models.Pedido;
import models.PedidoProduto;
import models.Produto;

public class RegistroVendaController implements Initializable {

	@FXML
	private Button buttonConcluir, buttonVoltar, buttonAdicionar, buttonRemover, buttonSelecionarCliente;

	@FXML
	private TextField textFieldQuantidade, textFieldCPFCliente;

	@FXML
	private Label labelNomeProduto, labelCliente, labelTotalPreco;

	@FXML
	private TableView<Produto> tableViewProdutosDisponiveis;
	@FXML
	private TableView<MostraProduto> tableViewProdutosComprando;

	@FXML
	private TableColumn<?, ?> tableColumnQtdDisponivel, tableColumnNomeProdutoDisponivel;

	@FXML
	private TableColumn<?, ?> tableColumnQtdEscolhida, tableColumnNomeProdutoComprando, tableColumnPreco;

	private Cliente cliente;
	private List<Produto> prodDisponivel;
	private List<MostraProduto> prodComprando;
	private ObservableList<Produto> prodObsDisponivel;
	private ObservableList<MostraProduto> prodObsComprando;
	private PedidoDAO pedidodao;
	private ProdutoDAO produtodao;
	private Produto produtoSelecionado;
	private ClienteDAO clienteDAO;
	private double totalCompra;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pedidodao = new PedidoDAO();
		prodComprando = new ArrayList<MostraProduto>();
		produtodao = new ProdutoDAO();
		clienteDAO = new ClienteDAO();
		loadTableViewDisponivel();
		totalCompra = 0;
		this.labelTotalPreco.setText(String.valueOf(totalCompra));

		tableViewProdutosDisponiveis.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selectedItemTableViewProdutosDisponiveis(newValue));
	}

	public void loadTableViewDisponivel() {
		this.prodDisponivel = produtodao.all();

		tableColumnQtdDisponivel.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableColumnNomeProdutoDisponivel.setCellValueFactory(new PropertyValueFactory<>("nome"));

		this.prodObsDisponivel = FXCollections.observableList(this.prodDisponivel);
		this.tableViewProdutosDisponiveis.setItems(prodObsDisponivel);
	}

	public void selectedItemTableViewProdutosDisponiveis(Produto produtoDisp) {
		if (produtoDisp != null) {
			this.labelNomeProduto.setText(produtoDisp.getNome());
			produtoSelecionado = produtoDisp;
		}
	}

	public void loadTableViewProdutosComprando() {
		tableColumnQtdEscolhida.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		tableColumnNomeProdutoComprando.setCellValueFactory(new PropertyValueFactory<>("nome"));
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>(("preco")));

		this.prodObsComprando = FXCollections.observableList(this.prodComprando);
		this.tableViewProdutosComprando.setItems(prodObsComprando);
		this.labelTotalPreco.setText(String.valueOf(this.totalCompra));

	}

	@FXML
	public void handleBtnAdicionar() {
		try {
			int quantidade = Integer.parseInt(textFieldQuantidade.getText());
			if (quantidade <= 0) {
				MessageAlerts.valorInvalido();
				return;
			}
			if (produtoSelecionado.getQuantidade() >= quantidade) {
				MostraProduto mostraProduto = new MostraProduto(produtoSelecionado.getId(), quantidade,
						produtoSelecionado.getPreco(), produtoSelecionado.getNome());
				if (!prodComprando.isEmpty()) {
					for (MostraProduto m : prodComprando) {
						if (m.getId() == produtoSelecionado.getId()) {
							prodComprando.remove(m);
							break;
						}
					}
				}
				prodComprando.add(mostraProduto);
				this.totalCompra += mostraProduto.getPreco();

				loadTableViewProdutosComprando();

			} else {
				MessageAlerts.valorInsuficiente();
			}
		} catch (NumberFormatException e) {
			MessageAlerts.valorInsuficiente();
			return;
		}

	}

	@FXML
	public void handleBtnRemover() {
		for (MostraProduto m : prodComprando) {
			if (m.getId() == produtoSelecionado.getId()) {
				prodComprando.remove(m);
				this.totalCompra -= m.getPreco();
				break;
			}
		}
		loadTableViewProdutosComprando();
	}

	@FXML
	public void handleBtnConcluir() {
		if (!prodComprando.isEmpty() && !labelCliente.getText().isEmpty()) {
			Produto temp;
			Pedido pedido = new Pedido();
			PedidoProdutoDAO pedidoProdutoDAO = new PedidoProdutoDAO();

			pedido.setCliente(cliente);
			pedido.setVendedor(Session.funcOnline);
			pedidodao.insert(pedido);
			for (MostraProduto m : prodComprando) {
				PedidoProduto pedidoProduto = new PedidoProduto();
				temp = produtodao.selectById(m.getId());
				temp.removeQuantidade(m.getQuantidade());
				produtodao.update(temp);
				pedidoProduto.setProduto(temp);
				pedidoProduto.setQuantidade(m.getQuantidade());
				pedidoProduto.setPedido(pedido);
				pedidoProdutoDAO.insert(pedidoProduto);

				MessageAlerts.vendaRealizada();

				Stage actual = (Stage) this.buttonVoltar.getScene().getWindow();
				actual.close();
			}
		} else {
			MessageAlerts.campoObrigatorioEmBranco();
		}

	}

	@FXML
	public void handleBtnVoltar() {
		this.voltar();
	}

	private void voltar() {
		Stage actual = (Stage) this.buttonVoltar.getScene().getWindow();
		actual.close();
	}

	@FXML
	public void handleBtnSelecionarCliente() {
		try {
			long cpf = Long.parseLong(textFieldCPFCliente.getText());
			cliente = clienteDAO.selectFromCPF(cpf);
			labelCliente.setText(cliente.getNome());
		} catch (Exception e) {
			MessageAlerts.usuarioNaoEncontrado();
			this.textFieldCPFCliente.setText("");
		}
	}

}
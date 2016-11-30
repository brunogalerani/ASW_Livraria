package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import auxiliares.MostraProduto;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import models.Cliente;
import models.Produto;

public class RegistroVendaController implements Initializable {

	private Stage dialogStage;

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

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pedidodao = new PedidoDAO();
		prodComprando = new ArrayList<MostraProduto>();
		produtodao = new ProdutoDAO();
		loadTableViewDisponivel();

		tableViewProdutosDisponiveis.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selectedItemTableViewProdutosDisponiveis(newValue));

		/*
		 * if (cliente != null){ labelCliente.setText("Nome: " +
		 * cliente.getNome() + "     CPF: " + cliente.getCpf()); }
		 */
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
	}

	@FXML
	public void handleBtnAdicionar() {
		try {
			int quantidade = Integer.parseInt(textFieldQuantidade.getText());
			if (quantidade <= 0) {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Erro de quantidade!");
				alert.setContentText("Insira um valor válido para a quantidade!");
				alert.showAndWait();
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
				loadTableViewProdutosComprando();

			} else {
				Alert alert = new Alert(AlertType.WARNING);
				alert.setTitle("Erro de quantidade!");
				alert.setHeaderText("Quantidade insuficiente do produto selecionado!");
				alert.setContentText("Verifique o estoque e tente novamente!");
				alert.showAndWait();
			}
		} catch (NumberFormatException e) {
			Alert alert = new Alert(AlertType.WARNING);
			alert.setTitle("Erro de quantidade!");
			alert.setContentText("Insira um valor válido para a quantidade!");
			alert.showAndWait();
			return;
		}

	}

	@FXML
	public void handleBtnConcluir() {

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
	public void handleBtnRemover() {
		for (MostraProduto m : prodComprando) {
			if (m.getId() == produtoSelecionado.getId()) {
				prodComprando.remove(m);
				break;
			}
		}
		loadTableViewProdutosComprando();
	}

	@FXML
	public void handleBtnSelecionarCliente() {
		
	}

}
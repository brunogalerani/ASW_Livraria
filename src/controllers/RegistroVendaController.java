package controllers;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import dao.PedidoDAO;
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
import models.Produto;

public class RegistroVendaController implements Initializable {

	private Stage dialogStage;

	@FXML
	private Button buttonConcluir, buttonVoltar, buttonAdicionar, buttonRemover, buttonSelecionarCliente;

	@FXML
	private TextField textFieldQuantidade, textFieldCPF;

	@FXML
	private Label labelNomeProduto, labelCliente, labelTotalPreco;

	@FXML
	private TableView<Produto> tableViewProdutosDisponiveis, tableViewProdutosComprando;

	@FXML
	private TableColumn<?, ?> tableColumnQtdDisponivel, tableColumnNomeProdutoDisponivel;

	@FXML
	private TableColumn<?, ?> tableColumnQtdEscolhida, tableColumnNomeProdutoComprando, tableColumnPreco;

	private Cliente cliente;
	private List<Produto> prodDisponivel, prodComprando;
	private ObservableList<Produto> prodObsDisponivel, prodObsComprando;
	private PedidoDAO pedidodao;
	private ProdutoDAO produtodao;
	private Produto produtoSelecionado;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pedidodao = new PedidoDAO();
		prodComprando = new ArrayList<Produto>();
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
		Double precop = produtoSelecionado.getPreco() * Integer.parseInt(textFieldQuantidade.getText());
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>(("preco")));
		List<Produto> temp = new ArrayList<Produto>();
		for(Produto p : prodComprando){
			for(Produto p2 : temp){
				if(p2.getId() == p.getId()){
					continue;
				}
				temp.add(p);
			}
		}
		this.prodObsComprando = FXCollections.observableList(this.prodComprando);
		this.tableViewProdutosComprando.setItems(prodObsComprando);
	}

	@FXML
	public void handleBtnAdicionar() {
		int quantidade = Integer.parseInt(textFieldQuantidade.getText());
		for(int i = 0; i < quantidade; i++){
			prodComprando.add(produtoSelecionado);
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

	}

	@FXML
	public void handleBtnSelecionarCliente() {

	}

}
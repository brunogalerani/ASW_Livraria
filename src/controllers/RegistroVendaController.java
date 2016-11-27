package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.CelularDAO;
import dao.EBookDAO;
import dao.LivroFisicoDAO;
import dao.PedidoDAO;
import dao.ProdutoDAO;
import dao.TabletDAO;
import dao.VideoGameDAO;
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
	private TableColumn tableColumnQtdEscolhida, tableColumnNomeProdutoComprando, tableColumnPreco;

	private Cliente cliente;
	private List<Produto> prodDisponivel, prodComprando;
	private ObservableList<Produto> prodObsDisponivel, prodObsComprando;
	private PedidoDAO pedidodao;
	private ProdutoDAO produtodao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		pedidodao = new PedidoDAO();

		//loadTableViewDisponivel();

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
		}
	}
	
	@FXML
	public void handleBtnAdicionar() {
		tableColumnQtdEscolhida.setCellValueFactory(new PropertyValueFactory<>(textFieldQuantidade.getText()));
		tableColumnNomeProdutoComprando
				.setCellValueFactory(new PropertyValueFactory<>(tableColumnNomeProdutoDisponivel.getText()));
		tableColumnPreco.setCellValueFactory(new PropertyValueFactory<>(""));
	}

	@FXML
	public void handleBtnConcluir() {

	}

	@FXML
	public void handleBtnVoltar() {

	}

	@FXML
	public void handleBtnRemover() {

	}

	@FXML
	public void handleBtnSelecionarCliente() {

	}

}
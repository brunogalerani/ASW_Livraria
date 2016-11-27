package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import models.Produto;

public class RegistroVendaController implements Initializable{

	@FXML
	private Button buttonConcluir, buttonVoltar, buttonAdicionar, buttonRemover, buttonSelecionarCliente;
	
	@FXML
	private TextField textFieldQuantidade, textFieldCPF;
	
	@FXML
	private Label labelNomeProduto, labelCliente;
	
	@FXML
	private TableView tableViewProdutosDisponiveis, tableViewProdutosComprando;
	
	@FXML
	private TableColumn tableColumnNomeProdutoComprando, tableColumnQtdEscolhida, tableColumnQtdDisponivel,
	tableColumnNomeProdutoDisponivel;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void selectTableViewProdutosDisponiveis(Produto produto){
		if(produto != null){
			produto.getClass();
			this.labelNomeProduto.setText(produto.getNome());
		}
	}
	
	@FXML
	public void handleBtnConcluir(){
		
	}
	
	@FXML
	public void handleBtnVoltar(){
		
	}
	
	@FXML
	public void handleBtnAdicionar(){
		
	}
	
	@FXML
	public void handleBtnRemover(){
		
	}
	
	@FXML
	public void handleBtnSelecionarCliente(){
		
	}

}
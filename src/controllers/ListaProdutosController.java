package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class ListaProdutosController implements Initializable{
	
	@FXML
	private Button buttonCadastrar, buttonEditar, buttonApagar, buttonDetalhes, buttonVoltar;
	@FXML
	private Label labelNome, labelCodigoDeBarras, labelMarca, labelPreco;
	
	@FXML
	private TableView tableViewProduto;
	
	@FXML
	private TableColumn tableColumnQtdDisponivel, tableColumnNome, tableColumnTipo;
	
	
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	

	@FXML
	public void handleBtnCadastrar(){
		
	}
	
	@FXML
	public void handleBtnEditar(){
		
	}
	
	@FXML
	public void handleBtnDetalhes(){
		
	}
	
	@FXML
	public void handleBtnApagar(){
		
	}
	
	@FXML
	public void handleBtnVoltar(){
		
	}
	
	
}

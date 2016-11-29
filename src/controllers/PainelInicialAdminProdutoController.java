package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PainelInicialAdminProdutoController  implements Initializable{

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario, 
	buttonRegistrarVenda, buttonGerenciarProdutos, buttonListarProdutos;
	@FXML
	private AnchorPane ap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnNavBarFuncionario() throws IOException {
		AnchorPane next = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/PainelInicialFuncionarioProduto.fxml"));
		this.ap.getChildren().setAll(next);
	}
	@FXML
	private void handleBtnCliente() throws IOException {
		AnchorPane next = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/PainelInicialAdminCliente.fxml"));
		this.ap.getChildren().setAll(next);
	}
	@FXML
	private void hanbleBtnFuncionario() throws IOException {
		AnchorPane next = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/PainelInicialAdminFuncionario.fxml"));
		this.ap.getChildren().setAll(next);
	}

}

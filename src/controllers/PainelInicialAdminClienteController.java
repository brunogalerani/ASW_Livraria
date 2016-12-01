package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PainelInicialAdminClienteController  implements Initializable{

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario, 
	buttonHistoricoCompras, buttonGerenciarClientes, buttonListarClientes;
	@FXML
	private AnchorPane ap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		Stage actual = (Stage) buttonBarAdmin.getScene().getWindow();
		actual.setResizable(false);
		
	}
	@FXML
	private void handleButtonFuncionario() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialFuncionarioCliente.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}
	
	@FXML 
	private void handleBtnNavbarFuncionario() throws IOException{
		AnchorPane next = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/PainelInicialAdminFuncionario.fxml"));
		this.ap.getChildren().setAll(next);
	}
	@FXML
	private void handleBtnProduto() throws IOException {
		AnchorPane next = (AnchorPane) FXMLLoader.load(getClass()
				.getResource("/views/PainelInicialAdminProduto.fxml"));
		this.ap.getChildren().setAll(next);
	}

}

package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PainelInicialAdminClienteController  implements Initializable{

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario, 
	buttonHistoricoCompras, buttonGerenciarClientes, buttonListarClientes;
	@FXML
	AnchorPane ap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private void handleButtonFuncionario() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialFuncionarioCliente.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}

}

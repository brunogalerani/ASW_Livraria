package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.Session;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Gerente;

public class PainelInicialAdminClienteController  implements Initializable{

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario, 
	buttonHistoricoCompras, buttonGerenciarClientes, buttonListarClientes;
	
	@FXML
	private AnchorPane ap;
	
	@FXML
	private MenuItem menuItemLogout;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		if (Session.funcOnline.getClass() != Gerente.class) {
			this.buttonBarAdmin.setDisable(true);
		}
		
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
	
	@FXML
	public void handleButtonCadastrarClientes() throws IOException {

		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroClienteController.class.getResource("/views/CadastroCliente.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage nextStage = new Stage();
		nextStage.setTitle("Sistema Livraria ASW");
		nextStage.setResizable(false);
		Scene scene = new Scene(page);
		nextStage.setScene(scene);

		nextStage.showAndWait();
	}

	@FXML
	public void handleButtonListarClientes() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ListaClientesController.class.getResource("/views/ListaClientes.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage nextStage = new Stage();
		nextStage.setTitle("Sistema Livraria ASW");
		nextStage.setResizable(false);
		Scene scene = new Scene(page);
		nextStage.setScene(scene);

		nextStage.showAndWait();
	}
	
	@FXML
	public void handleButtonLogout() throws IOException{
		Stage actual = (Stage) buttonBarAdmin.getScene().getWindow();
		actual.close();
		
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ListaClientesController.class.getResource("/views/Login.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage nextStage = new Stage();
		nextStage.setTitle("Sistema Livraria ASW");
		nextStage.setResizable(false);
		Scene scene = new Scene(page);
		nextStage.setScene(scene);

		nextStage.show();
	}

}

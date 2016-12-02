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

public class PainelInicialAdminFuncionarioController implements Initializable {

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario,
			buttonCadastrarFuncionarios, buttonListarFuncionarios;
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
	public void handleBtnCadastrarFuncionarios() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroFuncionarioController.class.getResource("/views/CadastroFuncionario.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage next = new Stage();
		next.setTitle("Sistema Livraria ASW");
		next.setResizable(false);

		Scene scene = new Scene(page);
		next.setScene(scene);

		next.showAndWait();
	}

	@FXML
	private void handleBtnCliente() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialAdminCliente.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}

	@FXML
	private void handleBtnProduto() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialAdminProduto.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}

	@FXML
	public void handleButtonListarFuncionarios() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(ListaFuncionariosController.class.getResource("/views/ListaFuncionarios.fxml"));
		AnchorPane page = (AnchorPane) loader.load();

		Stage next = new Stage();
		next.setTitle("Sistema Livraria ASW");
		next.setResizable(false);

		Scene scene = new Scene(page);
		next.setScene(scene);

		next.showAndWait();
	}

	@FXML
	private void handleBtnNavbarFuncionario() throws IOException {
		AnchorPane next = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialFuncionarioCliente.fxml"));
		this.ap.getChildren().setAll(next);
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

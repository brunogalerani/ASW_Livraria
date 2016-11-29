package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class PainelInicialAdminFuncionarioController  implements Initializable{

	@FXML
	private Button buttonBarAdmin, buttonBarFuncionario, buttonProduto, buttonCliente, buttonFuncionario, 
	buttonGerenciarFuncionarios, buttonListarFuncionarios;
	@FXML
	private AnchorPane ap;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	public void handleBtnGerenciarFuncionarios() throws IOException{
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

}

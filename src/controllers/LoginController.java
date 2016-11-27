package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dao.GerenteDAO;
import dao.VendedorDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import models.Gerente;

public class LoginController implements Initializable {
	@FXML
	private TextField textFieldUsuario;
	@FXML
	private PasswordField passwordFieldSenha;
	@FXML
	private Button buttonLogin;
	@FXML
	private Button buttonFechar;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		
	}

	@FXML
	public void handleButtonFechar() {

	}

	@FXML
	public void handleButtonLogin() {
		GerenteDAO gerenteDAO = new GerenteDAO();
		VendedorDAO vendedorDAO = new VendedorDAO();
		String login = textFieldUsuario.getText();
		String password = passwordFieldSenha.getText();
		
		Alert alert = new Alert(Alert.AlertType.ERROR);
		if(login.isEmpty()){
			alert.setTitle("Campo vazio!");
			alert.setHeaderText("O campo \"Usuário\" está em branco!");
			alert.setContentText("Por favor, preencha todos os campos antes de prosseguir!");
			alert.showAndWait();
		}else if(password.isEmpty()){
			alert.setTitle("Campo vazio!");
			alert.setHeaderText("O campo \"Senha\" está em branco!");
			alert.setContentText("Por favor, preencha todos os campos antes de prosseguir!");
			alert.showAndWait();
		}else if(gerenteDAO.selectFromLogin(login) == null){
			alert.setTitle("Login inválido!");
			alert.setHeaderText("Credenciais inválidas ou usuário inexistente!");
			alert.setContentText("Por favor, verifique seus dados e tente novamente!");
			alert.showAndWait();
		}else{
			System.out.println("Foi!");
		}
	}

}

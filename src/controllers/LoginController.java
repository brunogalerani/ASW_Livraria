package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.Session;
import dao.FuncionarioDAO;
import dao.GerenteDAO;
import encryption.EncryptPassword;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Funcionario;
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
		buttonLogin.setDefaultButton(true);
		Platform.runLater(new Runnable() {
	        @Override
	        public void run() {
	            textFieldUsuario.requestFocus();
	        }
	    });
		
//		 Gerente gerente = new Gerente();
//		 gerente.setCpf(123456);
//		 gerente.setLogin("Bruno");
//		 gerente.setSenha(EncryptPassword.encryptSHA256("teste"));
//		 GerenteDAO t = new GerenteDAO();
//		 t.insert(gerente);
		
		// Vendedor vendedor = new Vendedor();
		// vendedor.setLogin("Alo");
		// vendedor.setSenha(EncryptPassword.encryptSHA256("opa"));
		// VendedorDAO dao = new VendedorDAO();
		// dao.insert(vendedor);
	}

	@FXML
	public void handleButtonFechar() {
		Stage actual = (Stage) buttonLogin.getScene().getWindow();
		actual.close();
	}

	@FXML
	public void handleButtonLogin() throws IOException {

		FuncionarioDAO funcionarioDAO = new FuncionarioDAO();
		String login = textFieldUsuario.getText();
		String password = EncryptPassword.encryptSHA256(passwordFieldSenha.getText());

		Alert alert = new Alert(Alert.AlertType.ERROR);

		if (login.isEmpty()) {
			alert.setTitle("Campo vazio!");
			alert.setHeaderText("O campo \"Usuário\" está em branco!");
			alert.setContentText("Por favor, preencha todos os campos antes de prosseguir!");
			alert.showAndWait();
		} else if (password.isEmpty()) {
			alert.setTitle("Campo vazio!");
			alert.setHeaderText("O campo \"Senha\" está em branco!");
			alert.setContentText("Por favor, preencha todos os campos antes de prosseguir!");
			alert.showAndWait();
		} else {
			Funcionario funcionario = funcionarioDAO.selectFromLogin(login, password);
			if (funcionario == null) {
				alert.setTitle("Login inválido!");
				alert.setHeaderText("Credenciais inválidas ou usuário inexistente!");
				alert.setContentText("Por favor, verifique seus dados e tente novamente!");
				alert.showAndWait();
			} else {
				Session.funcOnline = funcionario;
				
				Stage actual = (Stage) buttonLogin.getScene().getWindow();
			
				actual.close();
				
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(PainelInicialFuncionarioClienteController.class
						.getResource("/views/PainelInicialFuncionarioCliente.fxml"));
				AnchorPane page = (AnchorPane) loader.load();

				Stage nextStage = new Stage();
				nextStage.setTitle("Sistema Livraria ASW");
				nextStage.setResizable(false);
				Scene scene = new Scene(page);
				nextStage.setScene(scene);

				PainelInicialFuncionarioClienteController controller = loader.getController();

				controller.setDialogStage(funcionario);

				nextStage.show();
			}
		}
	}

}

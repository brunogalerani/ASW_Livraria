package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import auxiliares.Session;
import dao.FuncionarioDAO;
import encryption.EncryptPassword;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Funcionario;

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
		Stage actual = (Stage) buttonLogin.getScene().getWindow();
		actual.setResizable(false);
		Platform.runLater(new Runnable() {
			@Override
			public void run() {
				textFieldUsuario.requestFocus();
			}
		});
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

		/*
		 * Verifica se os campos foram preenchidos
		 */
		if (login.isEmpty() || password.isEmpty()) {
			MessageAlerts.campoObrigatorioEmBranco();
		} else {
			Funcionario funcionario = funcionarioDAO.selectFromLogin(login, password);
			/*
			 * Verifica se encontrou um usuário com as credenciais fornecidas
			 */
			if (funcionario == null) {
				MessageAlerts.usuarioNaoEncontrado();
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

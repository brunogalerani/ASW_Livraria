package app;

import dao.FuncionarioDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Gerente;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Sistema Livraria ASW");
		stage.setResizable(false);
		
		stage.show();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		if(dao.all().isEmpty()){
			Gerente gerente = new Gerente();
			gerente.setLogin("temp");
			gerente.setSenha(encryption.EncryptPassword.encryptSHA256("temp"));
			dao.insert(gerente);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
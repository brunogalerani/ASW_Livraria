package app;

import dao.GerenteDAO;
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

		stage.show();
	}

	public static void main(String[] args) {
		launch(args);
	}

}
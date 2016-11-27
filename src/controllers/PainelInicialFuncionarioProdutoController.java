package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;

public class PainelInicialFuncionarioProdutoController implements Initializable {

	@FXML
	private Button buttonBarFuncionario, buttonBarAdmin, buttonProduto, buttonCliente, buttonRegistrarVenda,
			buttonAdicionarProdutos, buttonListarProdutos;
	@FXML
	private AnchorPane ap;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub

	}

	@FXML
	public void handleButtonCliente() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialFuncionarioCliente.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}

}

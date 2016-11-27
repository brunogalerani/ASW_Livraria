package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroProdutoVideoGameController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
	textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, textFieldGarantia, 
	textFieldAlimentacao, textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, 
	textFieldBateria, textFieldMidia, textFieldPlataformaSuportada;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnCadastrar() {
		
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}

}

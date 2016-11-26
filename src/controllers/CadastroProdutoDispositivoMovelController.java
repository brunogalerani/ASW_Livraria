package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;

public class CadastroProdutoDispositivoMovelController  implements Initializable{

	@FXML
	private ChoiceBox choiceBoxTipoDispositivoMovel;
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
	textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, textFieldGarantia, 
	textFieldAlimentacao, textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, 
	textFieldBateria, textFieldTouchScreen, textFieldTamanhoTela, textFieldTipoChip, textFieldQuantidadeChip,
	textFieldResolucao, textFieldTecnologiaSuportada;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private void btnCadastrar() {
		
	}
	@FXML
	private void btnVoltar() {
		
	}

}

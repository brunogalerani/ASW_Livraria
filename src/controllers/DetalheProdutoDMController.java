package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class DetalheProdutoDMController implements Initializable{

	@FXML
	private Label labelTipoDispositivoMovel, labelCor, labelPreco, labelLargura, labelPotencia, 
	labelAltura, labelConsumo, labelProfundidade, labelGarantia, labelPeso, labelModelo, labelAlimentacao,
	labelMarca, labelArmazenamento, labelFabricante, labelTouchScreen, labelTecnologiaSuportada, 
	labelQuantidadeChips, labelTamanhoTela, labelResolucao, labelTipoChip, labelBateria;
	
	@FXML
	private Button buttonVoltar;
	
	@FXML
	private ImageView imgView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}
	
}
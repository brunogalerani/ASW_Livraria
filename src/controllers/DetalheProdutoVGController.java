package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DetalheProdutoVGController implements Initializable{

	@FXML
	private Label labelModelo, labelCodigoBarras, labelPreco, labelCor, labelLargura, labelProfundidade,
	labelConsumo, labelPotencia, labelPeso, labelGarantia, labelAlimentacao, labelMarca, labelAltura,
	labelArmazenamento, labelBateria, labelMidia, labelPlataformaSuportada, labelFabricante;
	
	@FXML
	private Button buttonVoltar;
	
	@FXML
	private Text textResumo;
	
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
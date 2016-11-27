package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class DetalheFuncionarioController implements Initializable{

	@FXML
	private Label labelNome, labelDataDeNascimento, labelCPF, labelRG, labelTelefone, labelEmail,
	labelCEP, labelEndereco, labelRua, labelBairro, labelComplemento, labelEstado, labelNumero, 
	labelCidade;
	
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

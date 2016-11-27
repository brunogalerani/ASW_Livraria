package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.stage.Stage;

public class SelecaoTipoProdutoController implements Initializable{

	@FXML
	private Button buttonVoltar, buttonConfirmar;
	@FXML
	private RadioButton radioButtonDM, radioButtonEB, radioButtonVG, radioButtonLF;
	
	private Stage dialogStage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnVoltar(){
		
	}
	
	@FXML
	private void handleBtnConfirmar(){
		
	}

	public void setDialogStage(Stage diaogStage) {
		this.dialogStage = diaogStage;
	}

}
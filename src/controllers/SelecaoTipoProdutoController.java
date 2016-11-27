package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.EventType;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class SelecaoTipoProdutoController implements Initializable{

	@FXML
	private Button buttonVoltar, buttonConfirmar;
	@FXML
	private RadioButton radioButtonDM, radioButtonEB, radioButtonVG, radioButtonLF;
	private boolean checked;
	
	private Stage dialogStage;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.radioButtonDM.setSelected(true);
	}
	
	@FXML
	private void handleBtnVoltar(){
		
	}
	@FXML
	private void ifRadioButtonChecked() {
		if (this.radioButtonDM.isArmed()) {
			this.checked = !this.radioButtonDM.isArmed();
			this.radioButtonEB.setSelected(this.checked);
			this.radioButtonLF.setSelected(this.checked);
			this.radioButtonVG.setSelected(this.checked);
		}
		if (this.radioButtonEB.isArmed()) {
			this.checked = !this.radioButtonEB.isArmed();
			this.radioButtonDM.setSelected(this.checked);
			this.radioButtonLF.setSelected(this.checked);
			this.radioButtonVG.setSelected(this.checked);
		}
		if (this.radioButtonLF.isArmed()) {
			this.checked = !this.radioButtonLF.isArmed();
			this.radioButtonEB.setSelected(this.checked);
			this.radioButtonDM.setSelected(this.checked);
			this.radioButtonVG.setSelected(this.checked);
		}
		if (this.radioButtonVG.isArmed()) {
			this.checked = !this.radioButtonVG.isArmed();
			this.radioButtonEB.setSelected(this.checked);
			this.radioButtonLF.setSelected(this.checked);
			this.radioButtonDM.setSelected(this.checked);
		}
		
	}
	@FXML
	private void handleBtnConfirmar() throws IOException{
		if(this.radioButtonDM.isArmed()){
			FXMLLoader loader = new FXMLLoader();
			loader.setLocation(CadastroProdutoDispositivoMovelController.class.getResource("/views/CadastroProdutoDispositivoMovel.fxml"));
			AnchorPane page = (AnchorPane) loader.load();

			Stage nextStage = new Stage();
			nextStage.setTitle("Sistema Livraria ASW");
			nextStage.setResizable(false);
			Scene scene = new Scene(page);
			nextStage.setScene(scene);

			nextStage.showAndWait();
		}else {
			System.out.println(")))))))))))");
		}
	}

	public void setDialogStage(Stage diaogStage) {
		this.dialogStage = diaogStage;
	}

}
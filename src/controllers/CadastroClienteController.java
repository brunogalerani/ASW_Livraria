package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class CadastroClienteController  implements Initializable{

	@FXML
	private TextField textFieldNome, textFieldDataNascimento, textFieldCPF, textFieldRG, textFieldTelefone,
		textFieldEmail, textFieldCEP, textFieldEndereco, textFieldRua, textFieldNumero, textFieldBairro,
		textFieldComplemento, textFieldEstado, textFieldCidade;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void btnCadastrar() {
		
	}
	
	@FXML
	private void btnVoltar() {
		
	}

}

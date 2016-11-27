package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.ClienteDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Cliente;

public class CadastroClienteController  implements Initializable{

	@FXML
	private TextField textFieldNome, textFieldCPF, textFieldRG, textFieldTelefone,
		textFieldEmail, textFieldCEP, textFieldEndereco, textFieldRua, textFieldNumero, textFieldBairro,
		textFieldComplemento, textFieldEstado, textFieldCidade;
	@FXML
	private DatePicker datePickerDataNascimento;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private Cliente cliente;
	private ClienteDAO clienteDAO;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.clienteDAO = new ClienteDAO();
		
	}
	
	@FXML
	private void handleBtnCadastrar() {
		
	}
	private void cadastrar() {
		String nome = this.textFieldNome.getText();
		LocalDate dataNascimento = 
	}
	@FXML
	private void handleBtnVoltar() {
		
	}

}

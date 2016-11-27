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
import models.Endereco;

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
		LocalDate dataNascimento = this.datePickerDataNascimento.getValue();
		long cpf = Long.parseLong(this.textFieldCPF.getText());
		String rg = this.textFieldRG.getText();
		String telefone = this.textFieldTelefone.getText();
		String email = this.textFieldEmail.getText();
		
		String rua = this.textFieldEndereco.getText();
		String bairro = this.textFieldBairro.getText();
		long cep = Long.parseLong(this.textFieldCEP.getText());
		String numero = this.textFieldNumero.getText();
		String complemento = this.textFieldComplemento.getText();
		String cidade = this.textFieldCidade.getText();
		String estado = this.textFieldEstado.getText();
		
		Endereco endereco = new Endereco();
		endereco.setRua(rua);
		endereco.setBairro(bairro);
		endereco.setCep(cep);
		endereco.setNumero(numero);
		endereco.setComplemento(complemento);
		endereco.setCidade(cidade);
		endereco.setEstado(estado);
		
		cliente = new Cliente();
		cliente.setNome(nome);
		cliente.setDataNascimento(dataNascimento);
		cliente.setCpf(cpf);
		cliente.setRg(rg);
		cliente.setTelefone(telefone);
		cliente.setEmail(email);
		cliente.setEndereco(endereco);
		
		clienteDAO.insert(cliente);
	}
	@FXML
	private void handleBtnVoltar() {
		
	}

}

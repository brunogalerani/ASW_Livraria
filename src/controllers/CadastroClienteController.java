package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.ClienteDAO;
import dao.EnderecoDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.Cliente;
import models.Endereco;

public class CadastroClienteController implements Initializable {

	@FXML
	private TextField textFieldNome, textFieldCPF, textFieldRG, textFieldTelefone, textFieldEmail, textFieldCEP,
			textFieldRua, textFieldNumero, textFieldBairro, textFieldComplemento, textFieldEstado,
			textFieldCidade;
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
		this.cadastrar();
	}

	private void cadastrar() {
		try {
			String nome = this.textFieldNome.getText();
			LocalDate dataNascimento = this.datePickerDataNascimento.getValue();
			long cpf = Long.parseLong(this.textFieldCPF.getText());
			String rg = this.textFieldRG.getText();
			String telefone = this.textFieldTelefone.getText();
			String email = this.textFieldEmail.getText();

			String rua = this.textFieldRua.getText();
			String bairro = this.textFieldBairro.getText();
			long cep = Long.parseLong(this.textFieldCEP.getText());
			String numero = this.textFieldNumero.getText();
			String complemento = this.textFieldComplemento.getText();
			String cidade = this.textFieldCidade.getText();
			String estado = this.textFieldEstado.getText();

			EnderecoDAO endDAO = new EnderecoDAO();
			Endereco endereco = new Endereco();
			endereco.setRua(rua);
			endereco.setBairro(bairro);
			endereco.setCep(cep);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			endDAO.insert(endereco);

			cliente = new Cliente();
			cliente.setNome(nome);
			cliente.setDataNascimento(dataNascimento);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setTelefone(telefone);
			cliente.setEmail(email);
			cliente.setEndereco(endereco);
			
			clienteDAO.insert(cliente);
			
			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso!");
			alert.setHeaderText("Cliente cadastrador com sucesso!");
			alert.setContentText("Cliente cadastrado com sucesso!");
			alert.showAndWait();
			
			Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
			actual.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@FXML
	private void handleBtnVoltar() {
		Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
		actual.close();
	}

}

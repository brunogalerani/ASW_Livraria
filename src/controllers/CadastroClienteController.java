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
			textFieldRua, textFieldNumero, textFieldBairro, textFieldComplemento, textFieldEstado, textFieldCidade;
	@FXML
	private DatePicker datePickerDataNascimento;
	@FXML
	private Button buttonVoltar, buttonCadastrar;

	private Cliente cliente;
	private Endereco endereco;
	private ClienteDAO clienteDAO;
	private Stage dialogStage;
	private boolean buttonConfirmarClicked;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.clienteDAO = new ClienteDAO();
		this.cliente = new Cliente();
		this.endereco = new Endereco();
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
		this.endereco = cliente.getEndereco();
		this.textFieldBairro.setText(endereco.getBairro());
		this.textFieldCEP.setText(String.valueOf(endereco.getCep()));
		this.textFieldCidade.setText(endereco.getCidade());
		this.textFieldComplemento.setText(endereco.getComplemento());
		this.textFieldCPF.setText(String.valueOf(cliente.getCpf()));
		this.textFieldEmail.setText(cliente.getEmail());
		this.textFieldEstado.setText(endereco.getEstado());
		this.textFieldNome.setText(cliente.getNome());
		this.textFieldNumero.setText(String.valueOf(endereco.getNumero()));
		this.textFieldRG.setText(String.valueOf(cliente.getRg()));
		this.textFieldRua.setText(endereco.getRua());
		this.textFieldTelefone.setText(cliente.getTelefone());
		this.datePickerDataNascimento.setValue(cliente.getDataNascimento());
		this.buttonCadastrar.setText("Atualizar");
	}

	public Stage getDialogStage() {
		return dialogStage;
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public boolean isButtonConfirmarClicked() {
		return buttonConfirmarClicked;
	}

	public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
		this.buttonConfirmarClicked = buttonConfirmarClicked;
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

			endereco.setRua(rua);
			endereco.setBairro(bairro);
			endereco.setCep(cep);
			endereco.setNumero(numero);
			endereco.setComplemento(complemento);
			endereco.setCidade(cidade);
			endereco.setEstado(estado);
			if (endereco.getId() == null) {
				endDAO.insert(endereco);
			} else {
				endDAO.update(endereco);
			}

			cliente.setNome(nome);
			cliente.setDataNascimento(dataNascimento);
			cliente.setCpf(cpf);
			cliente.setRg(rg);
			cliente.setTelefone(telefone);
			cliente.setEmail(email);
			cliente.setEndereco(endereco);
			if (cliente.getId() == null) {
				clienteDAO.insert(cliente);
			} else {
				clienteDAO.update(cliente);
			}

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso!");
			if (this.buttonCadastrar.getText().equals("Atualizar")) {
				alert.setHeaderText("Cliente atualizado com sucesso!");
				alert.setContentText("Cliente atualizado com sucesso!");
			} else {
				alert.setHeaderText("Cliente cadastrado com sucesso!");
				alert.setContentText("Cliente cadastrado com sucesso!");
			}

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

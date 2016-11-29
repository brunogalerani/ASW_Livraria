package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.EnderecoDAO;
import dao.FuncionarioDAO;
import encryption.EncryptPassword;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import models.Endereco;
import models.Funcionario;
import models.Vendedor;

public class CadastroFuncionarioController implements Initializable{
	
	@FXML
	private TextField textFieldNome, textFieldCPF, textFieldRG, textFieldTelefone,
		textFieldEmail, textFieldCEP, textFieldRua, textFieldNumero, textFieldBairro,
		textFieldComplemento, textFieldEstado, textFieldCidade;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	@FXML
	private DatePicker datePickerDataNascimento;
	
	private Vendedor funcionario;
	private Endereco endereco;
	private FuncionarioDAO funcionariodao;
	private Stage dialogStage;
	private boolean buttonConfirmarClicked;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.funcionariodao = new FuncionarioDAO();
		this.funcionario = new Vendedor();
		this.endereco = new Endereco();
	}
	
	public Vendedor getFuncionario(){
		return funcionario;
	}
	
	public Funcionario setFuncionario(Funcionario funcionario){
		this.endereco = funcionario.getEndereco();
		this.textFieldBairro.setText(endereco.getBairro());
		this.textFieldCEP.setText(String.valueOf(endereco.getCep()));
		this.textFieldCidade.setText(endereco.getCidade());
		this.textFieldComplemento.setText(endereco.getComplemento());
		this.textFieldCPF.setText(String.valueOf(funcionario.getCpf()));
		this.textFieldEmail.setText(funcionario.getEmail());
		this.textFieldEstado.setText(endereco.getEstado());
		this.textFieldNome.setText(funcionario.getNome());
		this.textFieldNumero.setText(String.valueOf(endereco.getNumero()));
		this.textFieldRG.setText(String.valueOf(funcionario.getRg()));
		this.textFieldRua.setText(endereco.getRua());
		this.textFieldTelefone.setText(funcionario.getTelefone());
		this.datePickerDataNascimento.setValue(funcionario.getDataNascimento());
		this.buttonCadastrar.setText("Atualizar");
		
		return funcionario;
	}
	
	public void setDialogStage(Stage dialogStage){
		this.dialogStage = dialogStage;
	}
	
	public Stage getDialogStage(){
		return dialogStage;
	}
	
	public boolean isButtonConfirmarClicked() {
		return buttonConfirmarClicked;
	}

	public void setButtonConfirmarClicked(boolean buttonConfirmarClicked) {
		this.buttonConfirmarClicked = buttonConfirmarClicked;
	}

	@FXML
	private void handleBtnCadastrar() {
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

			funcionario.setNome(nome);
			funcionario.setDataNascimento(dataNascimento);
			funcionario.setCpf(cpf);
			funcionario.setRg(rg);
			funcionario.setTelefone(telefone);
			funcionario.setEmail(email);
			funcionario.setEndereco(endereco);
			
			String geraLogin[] = funcionario.getNome().split(" ", 2);
			String login = geraLogin[0];
			String login2 = String.valueOf(geraLogin[1].charAt(0));
			
			funcionario.setLogin((login+login2).toLowerCase());
			funcionario.setSenha(EncryptPassword.encryptSHA256(((login+"123").toLowerCase())));
			
			if (funcionario.getId() == null) {
				funcionariodao.insert(funcionario);
				buttonConfirmarClicked = true;
			} else {
				funcionariodao.update(funcionario);
				buttonConfirmarClicked = true;
			}

			Alert alert = new Alert(AlertType.INFORMATION);
			alert.setTitle("Sucesso!");
			if (this.buttonCadastrar.getText().equals("Atualizar")) {
				alert.setHeaderText("Funcionário atualizado com sucesso!");
				alert.setContentText("Funcionário atualizado com sucesso!");
			} else {
				alert.setHeaderText("Funcionário cadastrado com sucesso!");
				alert.setContentText("Funcionário cadastrado com sucesso!");
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

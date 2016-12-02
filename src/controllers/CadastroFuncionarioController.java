package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.EnderecoDAO;
import dao.GerenteDAO;
import dao.VendedorDAO;
import encryption.EncryptPassword;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Endereco;
import models.Funcionario;
import models.Gerente;
import models.Vendedor;

public class CadastroFuncionarioController implements Initializable {

	@FXML
	private TextField textFieldNome, textFieldCPF, textFieldRG, textFieldTelefone, textFieldEmail, textFieldCEP,
			textFieldRua, textFieldNumero, textFieldBairro, textFieldComplemento, textFieldEstado, textFieldCidade;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	@FXML
	private DatePicker datePickerDataNascimento;
	@FXML
	private RadioButton radioButtonGerente, radioButtonVendedor;

	private Vendedor vendedor;
	private Gerente gerente;
	private Endereco endereco;
	private VendedorDAO vendedorDao;
	private GerenteDAO gerenteDao;
	EnderecoDAO endDAO;
	private Stage dialogStage;
	private boolean buttonConfirmarClicked;
	private boolean checked;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.gerenteDao = new GerenteDAO();
		this.vendedorDao = new VendedorDAO();
		this.radioButtonVendedor.setSelected(true);
		this.gerente = new Gerente();
		this.vendedor = new Vendedor();
		this.endereco = new Endereco();
		endDAO = new EnderecoDAO();

	}

	@FXML
	private void isRadioButtonChecked() {
		/*
		 * Acionado cada vez que se seleciona um Radio Button Sua função é
		 * desarmar o que não estiver selecionado
		 */
		if (this.radioButtonGerente.isArmed()) {
			this.checked = !radioButtonGerente.isArmed();
			radioButtonVendedor.setSelected(checked);
			return;
		} else if (this.radioButtonVendedor.isArmed()) {
			this.checked = !radioButtonVendedor.isArmed();
			radioButtonGerente.setSelected(checked);
		}
	}

	public Vendedor getVendedor() {
		return vendedor;
	}

	public Gerente getGerente() {
		return gerente;
	}

	public void setFuncionario(Funcionario funcionario) {
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

		if (funcionario.getClass() == Vendedor.class) {
			this.radioButtonVendedor.setSelected(true);
			this.radioButtonGerente.setSelected(false);
			this.vendedor = (Vendedor) funcionario;
		} else if (funcionario.getClass() == Gerente.class) {
			this.radioButtonGerente.setSelected(true);
			this.radioButtonVendedor.setSelected(false);
			this.gerente = (Gerente) funcionario;
		}
		this.radioButtonGerente.setDisable(true);
		this.radioButtonVendedor.setDisable(true);
	}

	public void setDialogStage(Stage dialogStage) {
		this.dialogStage = dialogStage;
	}

	public Stage getDialogStage() {
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
			/*
			 * Verifica se o nome contém pelo menos UM sobrenome, pois o mesmo é
			 * obrigatório para gerar o login!
			 */
			if (!this.textFieldNome.getText().startsWith(" ") && this.textFieldNome.getText().contains(" ")) {

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

				endereco.setRua(rua);
				endereco.setBairro(bairro);
				endereco.setCep(cep);
				endereco.setNumero(numero);
				endereco.setComplemento(complemento);
				endereco.setCidade(cidade);
				endereco.setEstado(estado);

				if (radioButtonVendedor.isSelected()) {
					vendedor.setNome(nome);
					vendedor.setDataNascimento(dataNascimento);
					vendedor.setCpf(cpf);
					vendedor.setRg(rg);
					vendedor.setTelefone(telefone);
					vendedor.setEmail(email);
					vendedor.setEndereco(endereco);
					geraSenha(vendedor);

					if (vendedor.getId() == null) {
						endDAO.insert(endereco);
						vendedorDao.insert(vendedor);

						buttonConfirmarClicked = true;
					} else {
						endDAO.update(endereco);
						vendedorDao.update(vendedor);

						buttonConfirmarClicked = true;
					}
				} else if (radioButtonGerente.isSelected()) {
					gerente.setNome(nome);
					gerente.setDataNascimento(dataNascimento);
					gerente.setCpf(cpf);
					gerente.setRg(rg);
					gerente.setTelefone(telefone);
					gerente.setEmail(email);
					gerente.setEndereco(endereco);
					geraSenha(gerente);

					if (gerente.getId() == null) {
						endDAO.insert(endereco);
						gerenteDao.insert(gerente);
						buttonConfirmarClicked = true;
					} else {
						endDAO.update(endereco);
						gerenteDao.update(gerente);
						buttonConfirmarClicked = true;
					}
				}

				MessageAlerts.dadosRegistrados();

				Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
				actual.close();
			} else {
				MessageAlerts.nomeIncompleto();
			}

		} catch (NumberFormatException e) {
			MessageAlerts.campoObrigatorioEmBranco();

		} catch (Exception e) {
			this.gerenteDao.rollback();
			this.vendedorDao.rollback();
			MessageAlerts.campoDuplicado();
		}
	}

	@FXML
	private void handleBtnVoltar() {
		if (MessageAlerts.cancelarCadastro().get() == ButtonType.OK) {
			Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
			actual.close();
		}
	}
	
	private void geraSenha(Funcionario funcionario){
		if (funcionario.getLogin()==null) {
			String geraLogin[] = funcionario.getNome().split(" ", 2);
			String login = geraLogin[0] + geraLogin[1];						

			funcionario.setLogin((login).toLowerCase());
			funcionario.setSenha(EncryptPassword.encryptSHA256(((login + "123").toLowerCase())));
		}
	}

}

package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.CelularDAO;
import dao.TabletDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.stage.Stage;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import models.Celular;
import models.DispMovel;
import models.Tablet;

public class CadastroProdutoDispositivoMovelController implements Initializable {

	@FXML
	private RadioButton radioButtonCel, radioButtonTablet, radioButtonTsSim, radioButtonTsNao;
	@FXML
	private DatePicker datePickerGarantia;
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
			textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, textFieldAlimentacao,
			textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, textFieldTamanhoTela,
			textFieldTipoChip, textFieldQuantidadeChip, textFieldResolucao, textFieldTecnologiaSuportada;
	@FXML
	private Button buttonVoltar, buttonCadastrar;

	private Tablet tablet;
	private Celular celular;
	private TabletDAO tabletDAO;
	private CelularDAO celularDAO;
	private DispMovel dispMovel;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.celularDAO = new CelularDAO();
		this.tabletDAO = new TabletDAO();

	}
	
	public void setDispMóvel(DispMovel dispMovel) {
		this.dispMovel = dispMovel;
		if (this.dispMovel.getClass() == Celular.class) {
			celular = (Celular)dispMovel;
			System.out.println(celular.getFabricante());
		}
	}
	private void cadastrarDispositivo() {
		boolean touchScreen = radioButtonTsSim.isSelected();
		double tamanhoTela = Double.parseDouble(this.textFieldTamanhoTela.getText());
		String tipoChip = this.textFieldTipoChip.getText();
		int quantidadeChip = Integer.parseInt(this.textFieldQuantidadeChip.getText());
		String tecnologiaSuportada = this.textFieldTecnologiaSuportada.getText();
		String resolucao = this.textFieldResolucao.getText();
		String cor = this.textFieldCor.getText();
		double altura = Double.parseDouble(this.textFieldAltura.getText());
		double largura = Double.parseDouble(this.textFieldLargura.getText());
		double profundidade = Double.parseDouble(this.textFieldProfundidade.getText());
		double potencia = Double.parseDouble(this.textFieldPotencia.getText());
		int alimentacao = Integer.parseInt(this.textFieldAlimentacao.getText());
		double consumo = Double.parseDouble(this.textFieldConsumo.getText());
		LocalDate garantia = this.datePickerGarantia.getValue();
		String modelo = this.textFieldModelo.getText();
		String marca = this.textFieldMarca.getText();
		String fabricante = this.textFieldFabricante.getText();
		double armazenamento = Double.parseDouble(this.textFieldArmazenamento.getText());
		double peso = Double.parseDouble(this.textFieldPeso.getText());
		double preco = Double.parseDouble(this.textFieldPreco.getText());
		long codBarras = Long.parseLong(this.textFieldCodigoBarras.getText());

		if (radioButtonCel.isSelected()) {
			this.celular = new Celular();
			this.celular.setTouchScreen(touchScreen);
			this.celular.setTamanhoTela(tamanhoTela);
			this.celular.setTipoChip(tipoChip);
			this.celular.setQuantidadeChip(quantidadeChip);
			this.celular.setTecnologiaSuportada(tecnologiaSuportada);
			this.celular.setResolucao(resolucao);
			this.celular.setCor(cor);
			this.celular.setAltura(altura);
			this.celular.setLargura(largura);
			this.celular.setProfundidade(profundidade);
			this.celular.setPotencia(potencia);
			this.celular.setAlimentacao(alimentacao);
			this.celular.setConsumo(consumo);
			this.celular.setGarantia(garantia);
			this.celular.setModelo(modelo);
			this.celular.setMarca(marca);
			this.celular.setFabricante(fabricante);
			this.celular.setArmazenamento(armazenamento);
			this.celular.setPeso(peso);
			this.celular.setPreco(preco);
			this.celular.setCodBarras(codBarras);

			celularDAO.insert(celular);
		} else if (radioButtonTablet.isSelected()) {
			this.tablet = new Tablet();
			this.tablet.setTouchScreen(touchScreen);
			this.tablet.setTamanhoTela(tamanhoTela);
			this.tablet.setTipoChip(tipoChip);
			this.tablet.setQuantidadeChip(quantidadeChip);
			this.tablet.setTecnologiaSuportada(tecnologiaSuportada);
			this.tablet.setResolucao(resolucao);
			this.tablet.setCor(cor);
			this.tablet.setAltura(altura);
			this.tablet.setLargura(largura);
			this.tablet.setProfundidade(profundidade);
			this.tablet.setPotencia(potencia);
			this.tablet.setAlimentacao(alimentacao);
			this.tablet.setConsumo(consumo);
			this.tablet.setGarantia(garantia);
			this.tablet.setModelo(modelo);
			this.tablet.setMarca(marca);
			this.tablet.setFabricante(fabricante);
			this.tablet.setArmazenamento(armazenamento);
			this.tablet.setPeso(peso);
			this.tablet.setPreco(preco);
			this.tablet.setCodBarras(codBarras);

			tabletDAO.insert(tablet);
		}

	}

	@FXML
	private void handleBtnCadastrar() {
		this.cadastrarDispositivo();
		Alert confirmacaoCadastro = new Alert(Alert.AlertType.INFORMATION);
		confirmacaoCadastro.setHeaderText("Dispositivo cadastrado com sucesso!");
		confirmacaoCadastro.showAndWait();
		this.voltar();
	}
	private void voltar() {
		Stage actual = (Stage) buttonVoltar.getScene().getWindow();
		actual.close();
	}
	@FXML
	private void handleBtnVoltar() {
		this.voltar();
	}

}

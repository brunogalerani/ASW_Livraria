package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.CelularDAO;
import dao.TabletDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.Celular;
import models.DispMovel;
import models.Tablet;

public class CadastroProdutoDispositivoMovelController implements Initializable {

	@FXML
	private RadioButton radioButtonCel, radioButtonTablet, radioButtonTsSim, radioButtonTsNao;

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
			textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, textFieldAlimentacao,
			textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, textFieldTamanhoTela,
			textFieldTipoChip, textFieldQuantidadeChip, textFieldResolucao, textFieldTecnologiaSuportada,
			textFieldBateria, textFieldNome, textFieldQuantidade, textFieldGarantia;
	@FXML
	private Button buttonVoltar, buttonCadastrar;

	private Tablet tablet;
	private Celular celular;
	private TabletDAO tabletDAO;
	private CelularDAO celularDAO;
	private DispMovel dispMovel;
	private boolean alteracao = false;

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		this.celularDAO = new CelularDAO();
		this.tabletDAO = new TabletDAO();
	}

	public void setDispMóvel(DispMovel dispMovel) {
		this.dispMovel = dispMovel;
		this.alteracao = true;
		if (this.dispMovel.getClass() == Celular.class) {
			celular = (Celular) dispMovel;
			this.carregarCamposCelular();
		}
		if (this.dispMovel.getClass() == Tablet.class) {
			tablet = (Tablet) dispMovel;
			this.carregarCamposTablet();
		}
	}

	private void carregarCamposCelular() {
		this.radioButtonCel.setSelected(true);
		this.radioButtonCel.setDisable(true);
		this.radioButtonTablet.setVisible(false);

		this.textFieldAlimentacao.setText(String.valueOf(this.celular.getAlimentacao()));
		this.textFieldAltura.setText(String.valueOf(this.celular.getAltura()));
		this.textFieldArmazenamento.setText(String.valueOf(this.celular.getArmazenamento()));
		this.textFieldBateria.setText(this.celular.getBateria());
		this.textFieldCodigoBarras.setText(String.valueOf(this.celular.getCodBarras()));
		this.textFieldConsumo.setText(String.valueOf(this.celular.getConsumo()));
		this.textFieldCor.setText(this.celular.getCor());
		this.textFieldFabricante.setText(this.celular.getFabricante());
		this.textFieldLargura.setText(String.valueOf(this.celular.getLargura()));
		this.textFieldMarca.setText(this.celular.getMarca());
		this.textFieldModelo.setText(this.celular.getModelo());
		this.textFieldNome.setText(this.celular.getNome());
		this.textFieldPeso.setText(String.valueOf(this.celular.getPeso()));
		this.textFieldPotencia.setText(String.valueOf(this.celular.getPotencia()));
		this.textFieldPreco.setText(String.valueOf(this.celular.getPreco()));
		this.textFieldProfundidade.setText(String.valueOf(this.celular.getProfundidade()));
		this.textFieldQuantidadeChip.setText(String.valueOf(this.celular.getQuantidadeChip()));
		this.textFieldResolucao.setText(this.celular.getResolucao());
		this.textFieldTamanhoTela.setText(String.valueOf(this.celular.getTamanhoTela()));
		this.textFieldTecnologiaSuportada.setText(this.celular.getTecnologiaSuportada());
		this.textFieldTipoChip.setText(this.celular.getTipoChip());
		this.textFieldGarantia.setText(String.valueOf(this.celular.getGarantia()));
		this.textFieldQuantidade.setText(String.valueOf(this.celular.getQuantidade()));
		this.radioButtonTsSim.setSelected(this.celular.isTouchScreen());
		this.radioButtonTsNao.setSelected(!this.celular.isTouchScreen());

	}

	private void carregarCamposTablet() {
		this.radioButtonTablet.setSelected(true);
		this.radioButtonTablet.setDisable(true);
		this.radioButtonCel.setVisible(false);

		this.textFieldAlimentacao.setText(String.valueOf(this.tablet.getAlimentacao()));
		this.textFieldAltura.setText(String.valueOf(this.tablet.getAltura()));
		this.textFieldArmazenamento.setText(String.valueOf(this.tablet.getArmazenamento()));
		this.textFieldBateria.setText(this.tablet.getBateria());
		this.textFieldCodigoBarras.setText(String.valueOf(this.tablet.getCodBarras()));
		this.textFieldConsumo.setText(String.valueOf(this.tablet.getConsumo()));
		this.textFieldCor.setText(this.tablet.getCor());
		this.textFieldFabricante.setText(this.tablet.getFabricante());
		this.textFieldLargura.setText(String.valueOf(this.tablet.getLargura()));
		this.textFieldMarca.setText(this.tablet.getMarca());
		this.textFieldModelo.setText(this.tablet.getModelo());
		this.textFieldNome.setText(this.tablet.getNome());
		this.textFieldPeso.setText(String.valueOf(this.tablet.getPeso()));
		this.textFieldPotencia.setText(String.valueOf(this.tablet.getPotencia()));
		this.textFieldPreco.setText(String.valueOf(this.tablet.getPreco()));
		this.textFieldProfundidade.setText(String.valueOf(this.tablet.getProfundidade()));
		this.textFieldQuantidadeChip.setText(String.valueOf(this.tablet.getQuantidadeChip()));
		this.textFieldResolucao.setText(this.tablet.getResolucao());
		this.textFieldTamanhoTela.setText(String.valueOf(this.tablet.getTamanhoTela()));
		this.textFieldTecnologiaSuportada.setText(this.tablet.getTecnologiaSuportada());
		this.textFieldTipoChip.setText(this.tablet.getTipoChip());
		this.textFieldGarantia.setText(String.valueOf(this.tablet.getGarantia()));
		this.textFieldQuantidade.setText(String.valueOf(this.tablet.getQuantidade()));
		this.radioButtonTsSim.setSelected(this.tablet.isTouchScreen());
		this.radioButtonTsNao.setSelected(!this.tablet.isTouchScreen());

	}

	private void cadastrarDispositivo() {
		try {
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
			int garantia = Integer.parseInt(this.textFieldGarantia.getText());
			String modelo = this.textFieldModelo.getText();
			String marca = this.textFieldMarca.getText();
			String fabricante = this.textFieldFabricante.getText();
			double armazenamento = Double.parseDouble(this.textFieldArmazenamento.getText());
			double peso = Double.parseDouble(this.textFieldPeso.getText());
			double preco = Double.parseDouble(this.textFieldPreco.getText());
			long codBarras = Long.parseLong(this.textFieldCodigoBarras.getText());
			String bateria = this.textFieldBateria.getText();
			String nome = this.textFieldNome.getText();
			int quantidade = Integer.parseInt(this.textFieldQuantidade.getText());

			if (radioButtonCel.isSelected()) {
				if (!alteracao) {
					this.celular = new Celular();
				}

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
				this.celular.setBateria(bateria);
				this.celular.setNome(nome);
				this.celular.setQuantidade(quantidade);

				if (!alteracao) {
					celularDAO.insert(celular);
				} else {
					celularDAO.update(celular);
				}

			} else if (radioButtonTablet.isSelected()) {
				if (!alteracao) {
					this.tablet = new Tablet();
				}

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
				this.tablet.setBateria(bateria);
				this.tablet.setNome(nome);
				this.tablet.setQuantidade(quantidade);

				if (!alteracao) {
					tabletDAO.insert(tablet);
				} else {
					tabletDAO.update(tablet);
				}

			}
		} catch (Exception e) {
			MessageAlerts.campoObrigatorioEmBranco();
		}

	}

	@FXML
	private void handleBtnCadastrar() {
		if (textFieldNome.getText().isEmpty() || textFieldCodigoBarras.getText().isEmpty()
				|| textFieldMarca.getText().isEmpty() || textFieldPreco.getText().isEmpty()) {
			MessageAlerts.campoObrigatorioEmBranco();
		} else {
			this.cadastrarDispositivo();
			MessageAlerts.dadosRegistrados();
			this.voltar();
		}
	}

	private void voltar() {
		Stage actual = (Stage) buttonVoltar.getScene().getWindow();
		actual.close();
	}

	@FXML
	private void handleBtnVoltar() {
		if (MessageAlerts.cancelarCadastro().get() == ButtonType.OK) {
			this.voltar();
		}
	}

}

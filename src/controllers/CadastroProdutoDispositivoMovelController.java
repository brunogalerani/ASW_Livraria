package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TextField;
import models.Celular;
import models.Tablet;

public class CadastroProdutoDispositivoMovelController  implements Initializable{

	@FXML
	private ChoiceBox choiceBoxTipoDispositivoMovel;
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
	textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, textFieldGarantia, 
	textFieldAlimentacao, textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, 
	textFieldBateria, textFieldTouchScreen, textFieldTamanhoTela, textFieldTipoChip, textFieldQuantidadeChip,
	textFieldResolucao, textFieldTecnologiaSuportada;
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private Tablet tablet;
	private Celular celular;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		
	}
	@FXML
	private void btnCadastrar() {
		
	}
	private void cadastrarCelular() {
		this.celular = new Celular();
		boolean touchScreen;
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
		boolean bateria;
		LocalDate garantia;
		String modelo = this.textFieldModelo.getText();
		String marca = this.textFieldMarca.getText();
		String fabricante = this.textFieldFabricante.getText();
		double armazenamento = Double.parseDouble(this.textFieldArmazenamento.getText());
		double peso = Double.parseDouble(this.textFieldPeso.getText());
		double preco = Double.parseDouble(this.textFieldPreco.getText());
		long codBarras = Long.parseLong(this.textFieldCodigoBarras.getText());
	}
	@FXML
	private void btnVoltar() {
		
	}

}

package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.VideoGameDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import models.VideoGame;

public class CadastroProdutoVideoGameController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
	textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, 
	textFieldAlimentacao, textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, 
	textFieldBateria, textFieldMidia, textFieldPlataformaSuportada;
	@FXML
	private DatePicker datePickerGarantia;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private VideoGameDAO videoGameDAO;
	private VideoGame videoGame;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.videoGameDAO = new VideoGameDAO();
	}
	
	@FXML
	private void handleBtnCadastrar() {
		this.cadastro();
	}
	private void cadastro() {
		double preco = Double.parseDouble(this.textFieldPreco.getText());
		long codBarras = Long.parseLong(this.textFieldCodigoBarras.getText());
		String cor = this.textFieldCor.getText();
		double altura = Double.parseDouble(this.textFieldAltura.getText());
		double largura = Double.parseDouble(this.textFieldLargura.getText());
		double profundidade = Double.parseDouble(this.textFieldProfundidade.getText());
		double potencia = Double.parseDouble(this.textFieldPotencia.getText());
		int alimentacao = Integer.parseInt(this.textFieldAlimentacao.getText());
		double consumo = Double.parseDouble(this.textFieldConsumo.getText());
		boolean bateria;
		LocalDate garantia = datePickerGarantia.getValue();
		String modelo = this.textFieldModelo.getText();
		String marca = this.textFieldMarca.getText();
		String fabricante = this.textFieldFabricante.getText();
		double armazenamento = Double.parseDouble(this.textFieldArmazenamento.getText());
		double peso = Double.parseDouble(this.textFieldPeso.getText());
		String midia = this.textFieldMidia.getText();
		String plataformaSuportada = this.textFieldPlataformaSuportada.getText();
		
		this.videoGame = new VideoGame();
		this.videoGame.setPreco(preco);
		this.videoGame.setCodBarras(codBarras);
		this.videoGame.setCor(cor);
		this.videoGame.setAltura(altura);
		this.videoGame.setLargura(largura);
		this.videoGame.setProfundidade(profundidade);
		this.videoGame.setPotencia(potencia);
		this.videoGame.setAlimentacao(alimentacao);
		this.videoGame.setConsumo(consumo);
		this.videoGame.setBateria(bateria);
		this.videoGame.setGarantia(garantia);
		this.videoGame.setModelo(modelo);
		this.videoGame.setMarca(marca);
		this.videoGame.setFabricante(fabricante);
		this.videoGame.setArmazenamento(armazenamento);
		this.videoGame.setPeso(peso);
		this.videoGame.setMidia(midia);
		this.videoGame.setPlataformaSuportada(plataformaSuportada);
		
		this.videoGameDAO.insert(videoGame);
		
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}

}

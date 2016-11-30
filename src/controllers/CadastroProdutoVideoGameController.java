package controllers;

import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

import dao.VideoGameDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.VideoGame;

public class CadastroProdutoVideoGameController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldCor, textFieldPotencia, textFieldLargura,
	textFieldAltura, textFieldProfundidade, textFieldConsumo, textFieldPeso, 
	textFieldAlimentacao, textFieldModelo, textFieldMarca, textFieldFabricante, textFieldArmazenamento, 
	textFieldBateria, textFieldMidia, textFieldPlataformaSuportada, textFieldNome, textFieldQuantidade;
	@FXML
	private DatePicker datePickerGarantia;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private VideoGameDAO videoGameDAO;
	private VideoGame videoGame;
	private boolean alteracao = false;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.videoGameDAO = new VideoGameDAO();
	}
	public void setVideoGame(VideoGame videoGame) {
		this.videoGame = videoGame;
		this.alteracao = true;
		this.carregarCampos();
	}
	private void carregarCampos() {
		this.textFieldAlimentacao.setText(String.valueOf(this.videoGame.getAlimentacao()));
		this.textFieldAltura.setText(String.valueOf(this.videoGame.getAltura()));
		this.textFieldArmazenamento.setText(String.valueOf(this.videoGame.getArmazenamento()));
		this.textFieldBateria.setText(this.videoGame.getBateria());
		this.textFieldCodigoBarras.setText(String.valueOf(this.videoGame.getCodBarras()));
		this.textFieldConsumo.setText(String.valueOf(this.videoGame.getConsumo()));
		this.textFieldCor.setText(this.videoGame.getCor());
		this.textFieldFabricante.setText(this.videoGame.getFabricante());
		this.textFieldLargura.setText(String.valueOf(this.videoGame.getLargura()));
		this.textFieldMarca.setText(this.videoGame.getMarca());
		this.textFieldMidia.setText(this.videoGame.getMidia());
		this.textFieldModelo.setText(this.videoGame.getModelo());
		this.textFieldNome.setText(this.videoGame.getNome());
		this.textFieldPeso.setText(String.valueOf(this.videoGame.getPeso()));
		this.textFieldPlataformaSuportada.setText(this.videoGame.getPlataformaSuportada());
		this.textFieldPotencia.setText(String.valueOf(this.videoGame.getPotencia()));
		this.textFieldPreco.setText(String.valueOf(this.videoGame.getPreco()));
		this.textFieldProfundidade.setText(String.valueOf(this.videoGame.getProfundidade()));
		this.datePickerGarantia.setValue(this.videoGame.getGarantia());
	}
	@FXML
	private void handleBtnCadastrar() {
		this.cadastro();
		Alert confirmacaoCadastro = new Alert(Alert.AlertType.INFORMATION);
		confirmacaoCadastro.setHeaderText("Video Game cadastrado com sucesso!");
		confirmacaoCadastro.showAndWait();
		this.voltar();
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
		LocalDate garantia = datePickerGarantia.getValue();
		String modelo = this.textFieldModelo.getText();
		String marca = this.textFieldMarca.getText();
		String fabricante = this.textFieldFabricante.getText();
		double armazenamento = Double.parseDouble(this.textFieldArmazenamento.getText());
		double peso = Double.parseDouble(this.textFieldPeso.getText());
		String midia = this.textFieldMidia.getText();
		String plataformaSuportada = this.textFieldPlataformaSuportada.getText();
		String nome = this.textFieldNome.getText();
		String bateria = this.textFieldBateria.getText();
		
		if (!alteracao) {
			this.videoGame = new VideoGame();
		}
		
		this.videoGame.setPreco(preco);
		this.videoGame.setCodBarras(codBarras);
		this.videoGame.setCor(cor);
		this.videoGame.setAltura(altura);
		this.videoGame.setLargura(largura);
		this.videoGame.setProfundidade(profundidade);
		this.videoGame.setPotencia(potencia);
		this.videoGame.setAlimentacao(alimentacao);
		this.videoGame.setConsumo(consumo);
		this.videoGame.setGarantia(garantia);
		this.videoGame.setModelo(modelo);
		this.videoGame.setMarca(marca);
		this.videoGame.setFabricante(fabricante);
		this.videoGame.setArmazenamento(armazenamento);
		this.videoGame.setPeso(peso);
		this.videoGame.setMidia(midia);
		this.videoGame.setPlataformaSuportada(plataformaSuportada);
		this.videoGame.setNome(nome);
		this.videoGame.setBateria(bateria);
		
		if (alteracao) {
			this.videoGameDAO.update(videoGame);
		} else {
			this.videoGameDAO.insert(videoGame);
		}
		
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

package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.LivroFisicoDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.LivroFisico;

public class CadastroProdutoLivroFisicoController  implements Initializable{
	
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textFieldIdioma, textFieldAno, 
	textFieldTipo, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor,
	textFieldAltura, textFieldLargura, textFieldProfundidade, textFieldPeso, textFieldNome, textFieldQuantidade;
	
	@FXML
	private TextArea textAreaResumo;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private LivroFisicoDAO livroFisicoDAO;
	private LivroFisico livroFisico;
	private boolean alteracao = false;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.livroFisicoDAO = new LivroFisicoDAO();
		
	}
	
	public void setLivroFisico(LivroFisico livroFisico) {
		this.livroFisico = livroFisico;
		this.alteracao = true;
		this.carregarCampos();
	}
	
	private void carregarCampos() {
		this.textAreaResumo.setText(this.livroFisico.getResumo());
		this.textFieldAltura.setText(String.valueOf(this.livroFisico.getAltura()));
		this.textFieldAno.setText(String.valueOf(this.livroFisico.getAno()));
		this.textFieldAutor.setText(this.livroFisico.getAutor());
		this.textFieldCategoria.setText(this.livroFisico.getCategoria());
		this.textFieldCodigoBarras.setText(String.valueOf(this.livroFisico.getCodBarras()));
		this.textFieldEditora.setText(this.livroFisico.getEditora());
		this.textFieldIdioma.setText(this.livroFisico.getIdioma());
		this.textFieldISBN.setText(String.valueOf(this.livroFisico.getIsbn()));
		this.textFieldLargura.setText(String.valueOf(this.livroFisico.getLargura()));
		this.textFieldNome.setText(this.livroFisico.getNome());
		this.textFieldNumeroPaginas.setText(String.valueOf(this.livroFisico.getNumeroPaginas()));
		this.textFieldPeso.setText(String.valueOf(this.livroFisico.getPeso()));
		this.textFieldPreco.setText(String.valueOf(this.livroFisico.getPreco()));
		this.textFieldProfundidade.setText(String.valueOf(this.livroFisico.getProfundidade()));
		this.textFieldTipo.setText(this.livroFisico.getTipo());
		this.textFieldTitulo.setText(this.livroFisico.getTitulo());
		this.textFieldQuantidade.setText(String.valueOf(this.livroFisico.getQuantidade()));
	}
	@FXML
	private void handleBtnCadastrar() {
		this.cadastrar();
		MessageAlerts.dadosRegistrados();
		this.voltar();
	}
	private void cadastrar() {
		double preco = Double.parseDouble(this.textFieldPreco.getText());
		long codBarras = Long.parseLong(this.textFieldCodigoBarras.getText());
		String titulo = this.textFieldTitulo.getText();
		String idioma = this.textFieldIdioma.getText();
		int ano = Integer.parseInt(this.textFieldAno.getText());
		int isbn = Integer.parseInt(this.textFieldISBN.getText());
		int numeroPaginas = Integer.parseInt(this.textFieldNumeroPaginas.getText());
		String editora = this.textFieldEditora.getText();
		String autor = this.textFieldAutor.getText();
		String resumo = this.textAreaResumo.getText();
		String categoria = this.textFieldCategoria.getText();
		double altura = Double.parseDouble(this.textFieldAltura.getText());
		double largura = Double.parseDouble(this.textFieldLargura.getText());
		double profundidade = Double.parseDouble(this.textFieldProfundidade.getText());
		String tipo = this.textFieldTipo.getText();
		double peso = Double.parseDouble(this.textFieldPeso.getText());
		String nome = this.textFieldNome.getText();
		int quantidade = Integer.parseInt(this.textFieldQuantidade.getText());
		
		if (!alteracao) {
			this.livroFisico = new LivroFisico();
		}
		this.livroFisico.setPreco(preco);
		this.livroFisico.setCodBarras(codBarras);
		this.livroFisico.setTitulo(titulo);
		this.livroFisico.setIdioma(idioma);
		this.livroFisico.setAno(ano);
		this.livroFisico.setIsbn(isbn);
		this.livroFisico.setNumeroPaginas(numeroPaginas);
		this.livroFisico.setEditora(editora);
		this.livroFisico.setAutor(autor);
		this.livroFisico.setResumo(resumo);
		this.livroFisico.setCategoria(categoria);
		this.livroFisico.setAltura(altura);
		this.livroFisico.setLargura(largura);
		this.livroFisico.setProfundidade(profundidade);
		this.livroFisico.setTipo(tipo);
		this.livroFisico.setPeso(peso);
		this.livroFisico.setNome(nome);
		this.livroFisico.setQuantidade(quantidade);
		
		if (alteracao) {
			this.livroFisicoDAO.update(livroFisico);
		}else {
			this.livroFisicoDAO.insert(livroFisico);
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

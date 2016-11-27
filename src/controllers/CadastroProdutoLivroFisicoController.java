package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dao.LivroFisicoDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.LivroFisico;

public class CadastroProdutoLivroFisicoController  implements Initializable{
	
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textFieldIdioma, textFieldAno, 
	textFieldTipo, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor,
	textFieldAltura, textFieldLargura, textFieldProfundidade, textFieldPeso;
	
	@FXML
	private TextArea textAreaResumo;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private LivroFisicoDAO livroFisicoDAO;
	private LivroFisico livroFisico;
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.livroFisicoDAO = new LivroFisicoDAO();
		
	}
	
	@FXML
	private void handleBtnCadastrar() {
		this.cadastrar();
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
		
		this.livroFisico = new LivroFisico();
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
		
		this.livroFisicoDAO.insert(livroFisico);
		
	}
	@FXML
	private void handleBtnVoltar() {
		
	}

}

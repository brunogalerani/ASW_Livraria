package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.EBookDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.EBook;

public class CadastroProdutoEbookController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textAreaIdioma, textFieldAno, 
	textFieldFormato, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor, 
	textFieldTamanhoArquivo, textFieldNome, textFieldQuantidade;
	
	@FXML
	private TextArea textAreaResumo;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private EBookDAO eBookDAO;
	private EBook eBook;
	private boolean alteracao = false;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.eBookDAO = new EBookDAO();
		
	}
	public void setEbook(EBook eBook) {
		this.eBook = eBook;
		this.alteracao = true;
		this.carregarCampos();
	}
	private void carregarCampos() {
		this.textFieldNome.setText(this.eBook.getNome());
		this.textAreaIdioma.setText(this.eBook.getIdioma());
		this.textAreaResumo.setText(this.eBook.getResumo());
		this.textFieldAno.setText(String.valueOf(this.eBook.getAno()));
		this.textFieldAutor.setText(this.eBook.getAutor());
		this.textFieldCategoria.setText(this.eBook.getCategoria());
		this.textFieldCodigoBarras.setText(String.valueOf(this.eBook.getCodBarras()));
		this.textFieldEditora.setText(this.eBook.getEditora());
		this.textFieldFormato.setText(this.eBook.getFormato());
		this.textFieldISBN.setText(String.valueOf(this.eBook.getIsbn()));
		this.textFieldNumeroPaginas.setText(String.valueOf(this.eBook.getNumeroPaginas()));
		this.textFieldPreco.setText(String.valueOf(this.eBook.getPreco()));
		this.textFieldTamanhoArquivo.setText(String.valueOf(this.eBook.getTamanhoArquivo()));
		this.textFieldTitulo.setText(this.eBook.getTitulo());
		this.textFieldQuantidade.setText(String.valueOf(this.eBook.getQuantidade()));
		//////pareiii aquiiiii////////////////////
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
		String idioma = this.textAreaIdioma.getText();
		int ano = Integer.parseInt(this.textFieldAno.getText());
		int isbn = Integer.parseInt(this.textFieldISBN.getText());
		String editora = this.textFieldEditora.getText();
		String autor = this.textFieldAutor.getText();
		String resumo = this.textAreaResumo.getText();
		String categoria = this.textFieldCategoria.getText();
		double tamanhoArquivo = Double.parseDouble(this.textFieldTamanhoArquivo.getText());
		String formato = this.textFieldFormato.getText();
		String nome = this.textFieldNome.getText();
		int quantidade = Integer.parseInt(this.textFieldQuantidade.getText());
		
		if (!alteracao) {
			this.eBook = new EBook();
		}

		this.eBook.setPreco(preco);
		this.eBook.setCodBarras(codBarras);
		this.eBook.setTitulo(titulo);
		this.eBook.setIdioma(idioma);
		this.eBook.setAno(ano);
		this.eBook.setIsbn(isbn);
		this.eBook.setEditora(editora);
		this.eBook.setAutor(autor);
		this.eBook.setResumo(resumo);
		this.eBook.setCategoria(categoria);
		this.eBook.setTamanhoArquivo(tamanhoArquivo);
		this.eBook.setFormato(formato);
		this.eBook.setNome(nome);
		this.eBook.setQuantidade(quantidade);
		
		if (alteracao) {
			eBookDAO.update(eBook);
		} else {
			eBookDAO.insert(eBook);
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

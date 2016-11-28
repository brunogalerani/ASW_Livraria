package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dao.EBookDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import models.EBook;

public class CadastroProdutoEbookController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textAreaIdioma, textFieldAno, 
	textFieldFormato, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor, 
	textFieldTamanhoArquivo, textFieldNome;
	
	@FXML
	private TextArea textAreaResumo;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	private EBookDAO eBookDAO;
	private EBook eBook;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.eBookDAO = new EBookDAO();
		
	}
	
	@FXML
	private void handleBtnCadastrar() {
		this.cadastrar();
		Alert confirmacaoCadastro = new Alert(Alert.AlertType.INFORMATION);
		confirmacaoCadastro.setHeaderText("Ebook cadastrado com sucesso!");
		confirmacaoCadastro.showAndWait();
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
		
		this.eBook = new EBook();
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
		
		eBookDAO.insert(eBook);
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

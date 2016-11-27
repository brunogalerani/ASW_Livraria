package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import dao.EBookDAO;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import models.EBook;

public class CadastroProdutoEbookController  implements Initializable{

	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textAreaIdioma, textFieldAno, 
	textFieldFormato, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor, 
	textFieldTamanhoArquivo;
	
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
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}

}

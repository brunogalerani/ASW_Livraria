package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class CadastroProdutoLivroFisicoController  implements Initializable{
	
	@FXML
	private TextField textFieldCodigoBarras, textFieldPreco, textFieldTitulo, textAreaIdioma, textFieldAno, 
	textFieldTipo, textFieldISBN, textFieldCategoria, textFieldNumeroPaginas, textFieldEditora, textFieldAutor,
	textFieldAltura, textFieldLargura;
	
	@FXML
	private TextArea textAreaResumo;
	
	@FXML
	private Button buttonVoltar, buttonCadastrar;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnCadastrar() {
		
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}

}

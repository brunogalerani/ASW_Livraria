package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

public class DetalheProdutoLFController implements Initializable{

	@FXML
	private Label labelCodigoBarras, labelPreco, labelTitulo, labelIdioma, labelAno, labelAltura, 
	labelTipo, labelCategoria, labelEditora, labelAutor, labelNumeroPaginas, labelISBN, labelLargura;
	
	@FXML
	private Button buttonVoltar;
	
	@FXML
	private Text textResumo;
	
	@FXML
	private ImageView imgView;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	@FXML
	private void handleBtnVoltar() {
		
	}
	
}
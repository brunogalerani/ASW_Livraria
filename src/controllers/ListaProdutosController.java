package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Produto;

public class ListaProdutosController implements Initializable{
	
	@FXML
	private Button buttonCadastrar, buttonEditar, buttonApagar, buttonDetalhes, buttonVoltar;
	@FXML
	private Label labelNome, labelCodigoDeBarras, labelMarca, labelPreco;
	
	@FXML
	private TableView tableViewProduto;
	
	@FXML
	private TableColumn tableColumnQtdDisponivel, tableColumnNome, tableColumnTipo;
	@FXML
	private AnchorPane ap;
	
	private ProdutoDAO produtoDAO;
	private List<Produto> listaProdutos;
	private ObservableList<Produto> observableListProdutos;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.produtoDAO = new ProdutoDAO();
		this.carregar();
		this.listenerTableView();
		
	}
	private void carregar() {
		this.listaProdutos = this.produtoDAO.all();
		
		this.tableColumnQtdDisponivel.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		this.tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));
		

		this.observableListProdutos = FXCollections.observableArrayList(listaProdutos);
		this.tableViewProduto.setItems(this.observableListProdutos);
	}

	@FXML
	public void handleBtnCadastrar() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SelecaoTipoProdutoController.class.
				getResource("/views/SelecaoTipoProduto.fxml"));
		AnchorPane page = loader.load();
		Stage diaogStage = new Stage();
		diaogStage.setTitle("Selecionar o tipo de produto");
		Scene scene = new Scene(page);
		diaogStage.setScene(scene);
		SelecaoTipoProdutoController controller = loader.getController();
		controller.setDialogStage(diaogStage);
		diaogStage.showAndWait();
	}
	
	@FXML
	public void handleBtnEditar(){
		
	}
	private void listenerTableView() {
		this.tableViewProduto.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> teste((Produto) newValue));
	}
	private void teste(Produto newValue) {
		if (newValue != null) {
			this.labelNome.setText(newValue.getNome());
			this.labelCodigoDeBarras.setText(String.valueOf(newValue.getCodBarras()));
			this.labelPreco.setText("R$: " + newValue.getPreco());
			
		}
	}
	@FXML
	public void handleBtnDetalhes(){
		
	}
	
	@FXML
	public void handleBtnApagar(){
		
	}
	
	@FXML
	public void handleBtnVoltar() throws IOException{
		AnchorPane nextAp = (AnchorPane) FXMLLoader.load(getClass().getResource("/views/PainelInicialFuncionarioProduto.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}
	
	
}

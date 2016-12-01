package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.ProdutoDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Celular;
import models.EBook;
import models.LivroFisico;
import models.Produto;
import models.Tablet;
import models.VideoGame;

public class ListaProdutosController implements Initializable {

	@FXML
	private Button buttonCadastrar, buttonEditar, buttonVoltar;
	@FXML
	private Label labelNome, labelCodigoDeBarras, labelMarca, labelPreco;

	@FXML
	private TableView<Produto> tableViewProduto;

	@FXML
	private TableColumn<?, ?> tableColumnQtdDisponivel, tableColumnNome, tableColumnTipo;
	@FXML
	private AnchorPane ap;

	private ProdutoDAO produtoDAO;
	private List<Produto> listaProdutos;
	private ObservableList<Produto> observableListProdutos;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		this.produtoDAO = new ProdutoDAO();
		this.loadTableViewProduto();
		this.listenerTableView();

	}

	private void loadTableViewProduto() {
		this.listaProdutos = this.produtoDAO.all();

		this.tableColumnQtdDisponivel.setCellValueFactory(new PropertyValueFactory<>("quantidade"));
		this.tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		this.tableColumnTipo.setCellValueFactory(new PropertyValueFactory<>("tipoProduto"));

		this.observableListProdutos = FXCollections.observableArrayList(listaProdutos);
		this.tableViewProduto.setItems(this.observableListProdutos);
	}

	private void selectItemTableViewProduto(Produto produto) {
		if (produto != null) {
			loadLabelValues(produto);
		}
	}

	private void loadLabelValues(Produto produto) {
		this.labelNome.setText(produto.getNome());
		this.labelCodigoDeBarras.setText(String.valueOf(produto.getCodBarras()));
		this.labelPreco.setText("R$: " + produto.getPreco());
		this.labelMarca.setText(produto.getMarca());
	}

	@FXML
	public void handleBtnCadastrar() throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(SelecaoTipoProdutoController.class.getResource("/views/SelecaoTipoProduto.fxml"));
		AnchorPane page = loader.load();
		Stage diaogStage = new Stage();
		diaogStage.setTitle("Selecionar o tipo de produto");
		Scene scene = new Scene(page);
		diaogStage.setScene(scene);
		SelecaoTipoProdutoController controller = loader.getController();
		controller.setDialogStage(diaogStage);
		diaogStage.showAndWait();
		loadTableViewProduto();
	}

	@FXML
	public void handleBtnEditar() throws IOException {
		Produto produto = (Produto) this.tableViewProduto.getSelectionModel().getSelectedItem();
		if (produto == null) {
			MessageAlerts.objetoNaoSelecionado();
		} else {
			if (produto.getTipoProduto().equals(EBook.class.getName().substring(7))) {
				System.out.println("EBOOK");
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(
						CadastroProdutoEbookController.class.getResource("/views/CadastroProdutoEbook.fxml"));
				AnchorPane page = loader.load();
				Stage diaogStage = new Stage();
				diaogStage.setTitle("Sistema Livraria ASW");
				diaogStage.setResizable(false);
				Scene scene = new Scene(page);
				diaogStage.setScene(scene);
				CadastroProdutoEbookController controller = loader.getController();
				controller.setEbook((EBook) produto);
				diaogStage.showAndWait();
			} else if (produto.getTipoProduto().equals(Celular.class.getName().substring(7))) {

				System.out.println("Celular");
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(CadastroProdutoDispositivoMovelController.class
						.getResource("/views/CadastroProdutoDispositivoMovel.fxml"));
				AnchorPane page = loader.load();
				Stage diaogStage = new Stage();
				diaogStage.setTitle("Sistema Livraria ASW");
				diaogStage.setResizable(false);
				Scene scene = new Scene(page);
				diaogStage.setScene(scene);
				CadastroProdutoDispositivoMovelController controller = loader.getController();
				controller.setDispMóvel((Celular) produto);
				diaogStage.showAndWait();
			} else if (produto.getTipoProduto().equals(Tablet.class.getName().substring(7))) {
				System.out.println("Tablet");
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(CadastroProdutoDispositivoMovelController.class
						.getResource("/views/CadastroProdutoDispositivoMovel.fxml"));
				AnchorPane page = loader.load();
				Stage diaogStage = new Stage();
				diaogStage.setTitle("Sistema Livraria ASW");
				diaogStage.setResizable(false);
				Scene scene = new Scene(page);
				diaogStage.setScene(scene);
				CadastroProdutoDispositivoMovelController controller = loader.getController();
				controller.setDispMóvel((Tablet) produto);
				diaogStage.showAndWait();
			} else if (produto.getTipoProduto().equals(VideoGame.class.getName().substring(7))) {
				System.out.println("VideoGame");
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(
						CadastroProdutoVideoGameController.class.getResource("/views/CadastroProdutoVideoGame.fxml"));
				AnchorPane page = loader.load();
				Stage diaogStage = new Stage();
				diaogStage.setTitle("Sistema Livraria ASW");
				diaogStage.setResizable(false);
				Scene scene = new Scene(page);
				diaogStage.setScene(scene);
				CadastroProdutoVideoGameController controller = loader.getController();
				controller.setVideoGame((VideoGame) produto);
				diaogStage.showAndWait();
			} else if (produto.getTipoProduto().equals(LivroFisico.class.getName().substring(7))) {
				System.out.println("LivroFisico");
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(CadastroProdutoLivroFisicoController.class
						.getResource("/views/CadastroProdutoLivroFisico.fxml"));
				AnchorPane page = loader.load();
				Stage diaogStage = new Stage();
				diaogStage.setTitle("Sistema Livraria ASW");
				diaogStage.setResizable(false);
				Scene scene = new Scene(page);
				diaogStage.setScene(scene);
				CadastroProdutoLivroFisicoController controller = loader.getController();
				controller.setLivroFisico((LivroFisico) produto);
				diaogStage.showAndWait();
			}
			loadTableViewProduto();
			loadLabelValues(produto);
		}

	}

	private void listenerTableView() {
		this.tableViewProduto.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selectItemTableViewProduto((Produto) newValue));
	}

	@FXML
	public void handleBtnVoltar() throws IOException {
		AnchorPane nextAp = (AnchorPane) FXMLLoader
				.load(getClass().getResource("/views/PainelInicialFuncionarioProduto.fxml"));
		this.ap.getChildren().setAll(nextAp);
	}

}

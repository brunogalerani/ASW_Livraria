package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Cliente;

public class ListaClientesController implements Initializable {

	@FXML
	private Button buttonCadastrar, buttonEditar, buttonApagar, buttonDetalhes, buttonVoltar;
	@FXML
	private Label labelNome, labelDataDeNascimento, labelTelefone, labelEmail, labelCEP;
	@FXML
	private TableView<Cliente> tableViewCliente;

	@FXML
	private TableColumn<?, ?> tableColumnCPF, tableColumnNome;

	private List<Cliente> clientesList;
	private ObservableList<Cliente> clientsObsList;
	private ClienteDAO clientdao;

	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clientdao = new ClienteDAO();

		loadTableViewCliente();

		tableViewCliente.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selectItemTableViewCliente(newValue));

	}

	public void loadTableViewCliente() {
		this.clientesList = clientdao.all();
		tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		this.clientsObsList = FXCollections.observableList(this.clientesList);
		this.tableViewCliente.setItems(this.clientsObsList);

	}

	public void selectItemTableViewCliente(Cliente cliente) {
		if (cliente != null) {

		}
	}

	@FXML
	public void handleBtnCadastrar() {

	}

	@FXML
	public void handleBtnEditar() throws IOException {
		Cliente cliente = this.tableViewCliente.getSelectionModel().getSelectedItem();

		if (cliente == null) {
			Alert errorAlert = new Alert(Alert.AlertType.ERROR);
			errorAlert.setContentText("Por favor, escolha um estudante na Tabela!");
			errorAlert.show();
		} else {
			boolean buttonConfirmarClicked = showAnchorPaneCadastroCliente(cliente);

			if (buttonConfirmarClicked) {
				this.clientdao.update(cliente);
				loadTableViewCliente();
			}
		}
	}

	@FXML
	public void handleBtnDetalhes() {

	}

	@FXML
	public void handleBtnApagar() {

	}

	@FXML
	public void handleBtnVoltar() {
		Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
		actual.close();
	}
	
	public boolean showAnchorPaneCadastroCliente(Cliente cliente) throws IOException {
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroClienteController.class.getResource("/views/CadastroCliente.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Cadastro de Clientes");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		
		/*CadastroClienteController controller = loader.getController();
		controller.setDialogStage(dialogStage);
		controller.setCliente(cliente);
		
		dialogStage.showAndWait();
		
		return controller.isButtonConfirmarClicked();*/
		return true;
	}

}

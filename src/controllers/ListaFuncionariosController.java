package controllers;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.Optional;
import java.util.ResourceBundle;

import auxiliares.MessageAlerts;
import dao.FuncionarioDAO;
import dao.VendedorDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import models.Funcionario;
import models.Vendedor;

public class ListaFuncionariosController implements Initializable {
	
	@FXML
	private Button buttonCadastrar, buttonEditar, buttonVoltar;
	@FXML
	private Label labelNome, labelDataDeNascimento, labelTelefone, labelEmail, labelCEP;
	@FXML
	private TableView<Funcionario> tableViewFuncionarios;
	
	@FXML
	private TableColumn<?, ?> tableColumnCPF, tableColumnNome;
	
	private List<Funcionario> funcionarioList;
	private ObservableList<Funcionario> funcionarioObsList;
	private FuncionarioDAO funcionariodao;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		funcionariodao = new FuncionarioDAO();
		
		loadTableViewFuncionario();
		
		tableViewFuncionarios.getSelectionModel().selectedItemProperty()
				.addListener((observable, oldValue, newValue) -> selectItemTableViewFuncionario(newValue));
		
	}
	
	public void loadTableViewFuncionario() {
		this.funcionarioList = funcionariodao.all();
		tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));

		this.funcionarioObsList = FXCollections.observableList(this.funcionarioList);
		this.tableViewFuncionarios.setItems(this.funcionarioObsList);
		
	}

	public void selectItemTableViewFuncionario(Funcionario funcionario) {
		if (funcionario != null) {
			this.labelCEP.setText(String.valueOf(funcionario.getEndereco().getCep()));
			this.labelDataDeNascimento.setText(String.valueOf(funcionario.getDataNascimento()));
			this.labelEmail.setText(funcionario.getEmail());
			this.labelNome.setText(funcionario.getNome());
			this.labelTelefone.setText(funcionario.getTelefone());
		}
	}
	
	@FXML
	public void handleBtnCadastrar() throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroFuncionarioController.class.getResource("/views/CadastroFuncionario.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		
		Stage next = new Stage();
		next.setTitle("Sistema Livraria ASW");
		next.setResizable(false);
		
		Scene scene = new Scene(page);
		next.setScene(scene);
		
		next.showAndWait();		
		loadTableViewFuncionario();
	}
	
	@FXML
	public void handleBtnEditar() throws IOException{
		Funcionario funcionario= this.tableViewFuncionarios.getSelectionModel().getSelectedItem();

		if (funcionario == null) {
			MessageAlerts.objetoNaoSelecionado();
		} else {
			boolean buttonConfirmarClicked = showAnchorPaneCadastroFuncionario(funcionario);

			if (buttonConfirmarClicked) {
				this.funcionariodao.update(funcionario);
				loadTableViewFuncionario();
			}
		}
	}
	
	public boolean showAnchorPaneCadastroFuncionario(Funcionario funcionario) throws IOException{
		FXMLLoader loader = new FXMLLoader();
		loader.setLocation(CadastroFuncionarioController.class.getResource("/views/CadastroFuncionario.fxml"));
		AnchorPane page = (AnchorPane) loader.load();
		
		Stage dialogStage = new Stage();
		dialogStage.setTitle("Cadastro de Funcionários");
		Scene scene = new Scene(page);
		dialogStage.setScene(scene);
		
		CadastroFuncionarioController controller = loader.getController();
		controller.setDialogStage(dialogStage);
		controller.setFuncionario(funcionario);
		
		dialogStage.showAndWait();
		
		return controller.isButtonConfirmarClicked();
	}
	
	@FXML
	public void handleBtnVoltar(){
		Stage actual = (Stage) buttonCadastrar.getScene().getWindow();
		actual.close();
	}
	
}

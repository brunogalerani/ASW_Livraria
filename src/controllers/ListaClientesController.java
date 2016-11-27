package controllers;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import dao.ClienteDAO;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import models.Cliente;

public class ListaClientesController implements Initializable {

	@FXML
	private Button buttonCadastrar, buttonEditar, buttonApagar, buttonDetalhes, buttonVoltar;
	@FXML
	private Label labelNome, labelDataDeNascimento, labelTelefone, labelEmail, labelCEP;
	@FXML
	private TableView tableViewCliente;
	
	@FXML
	private TableColumn tableColumnCPF, tableColumnNome;
	
	private List<Cliente> clientesList;
	private ObservableList<Cliente> clientsObsList;
	private ClienteDAO clientdao;
	
	@SuppressWarnings("unchecked")
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		clientdao = new ClienteDAO();
		
		loadTableViewCliente();
		
		tableViewCliente.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> selectItemTableViewCliente((Cliente) newValue));
		
	}
	
	public void loadTableViewCliente(){
		this.clientesList = clientdao.all();
		tableColumnCPF.setCellValueFactory(new PropertyValueFactory<>("cpf"));
		tableColumnNome.setCellValueFactory(new PropertyValueFactory<>("nome"));
		
		this.clientsObsList = FXCollections.observableList(this.clientesList);
		this.tableViewCliente.setItems(this.clientsObsList);
		
	}
	
	public void selectItemTableViewCliente(Cliente cliente){
		if(cliente!=null){
			
		}
	}
	
	@FXML
	public void handleBtnCadastrar(){
		
	}
	
	@FXML
	public void handleBtnEditar(){
		
	}
	
	@FXML
	public void handleBtnDetalhes(){
		
	}
	
	@FXML
	public void handleBtnApagar(){
		
	}
	
	@FXML
	public void handleBtnVoltar(){
		
	}

}

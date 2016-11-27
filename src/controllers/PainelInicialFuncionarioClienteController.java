package controllers;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import models.Funcionario;
import models.Vendedor;

public class PainelInicialFuncionarioClienteController  implements Initializable{

	@FXML
	private Button buttonBarFuncionario, buttonBarAdmin, buttonProduto, buttonCliente, buttonHistoricoCompras, 
	buttonCadastrarClientes, buttonListarClientes;
	
	@Override
	public void initialize(URL location, ResourceBundle resources) {
		// TODO Auto-generated method stub
		
	}
	
	public void setDialogStage(Funcionario funcionario){
		if(funcionario.getClass() == Vendedor.class){
			buttonBarAdmin.setDisable(true);
		}
	}

}

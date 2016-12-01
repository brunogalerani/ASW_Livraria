package app;

import java.time.LocalDate;

import dao.EnderecoDAO;
import dao.FuncionarioDAO;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import models.Endereco;
import models.Gerente;

public class App extends Application {
	@Override
	public void start(Stage stage) throws Exception {
		Parent root = FXMLLoader.load(getClass().getResource("/views/Login.fxml"));

		Scene scene = new Scene(root);

		stage.setScene(scene);
		stage.setTitle("Sistema Livraria ASW");
		stage.setResizable(false);
		
		stage.show();
		
		FuncionarioDAO dao = new FuncionarioDAO();
		/*
		 *  Verifica se já existe um usuário cadastrado
		 *  Caso não exista, será adicionado um usuário temporário
		 *  O mesmo deverá ser modificado.
		 */
		if(dao.all().isEmpty()){
			
			Gerente gerente = new Gerente();
			Endereco endereco = new Endereco();
			EnderecoDAO endDao = new EnderecoDAO();
			
			endereco.setBairro("temp");
			endereco.setCep(00);
			endereco.setCidade("temp");
			endereco.setComplemento("temp");
			endereco.setEstado("temp");
			endereco.setNumero("temp");
			endereco.setRua("temp");
			endDao.insert(endereco);
			
			gerente.setLogin("temp");
			gerente.setSenha(encryption.EncryptPassword.encryptSHA256("temp"));
			gerente.setCpf(0);
			gerente.setDataNascimento(LocalDate.now());
			gerente.setEmail("temp");
			gerente.setNome("temp");
			gerente.setEndereco(endereco);
			gerente.setEmail("temp");
			gerente.setRg("temp");
			gerente.setTelefone("temp");
			dao.insert(gerente);
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

}
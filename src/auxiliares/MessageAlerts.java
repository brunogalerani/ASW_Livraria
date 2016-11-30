package auxiliares;

import java.util.Optional;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;

public class MessageAlerts {
	private static Alert alert;
	
	public static void campoObrigatorioEmBranco() {
		alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Campos em branco!");
		alert.setHeaderText("Existem campos obrigat�rios em branco!");
		alert.setContentText("Por favor, preencha todos os campos antes de prosseguir!");
		alert.showAndWait();
	}
	public static void usuarioNaoEncontrado() {
		alert = new Alert(Alert.AlertType.WARNING);
		alert.setTitle("Usuario inv�lido!");
		alert.setHeaderText("O usu�rio informado n�o foi encontrado!");
		alert.setContentText("Por favor, verifique as credenciais e tente novamente!");
		alert.showAndWait();
	}
	public static void dadosRegistrados() {
		alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle("Sucesso!");
		alert.setHeaderText("Os dados foram registrados com sucesso!");
		alert.showAndWait();
	}
	public static void falhaRegistro() {
		alert = new Alert(Alert.AlertType.ERROR);
		alert.setTitle("Erro!");
		alert.setHeaderText("Ocorreu um erro e n�o foi poss�vel armazenar os dados!");
		alert.setContentText("Por favor, repita a opera��o novamente!");
		alert.showAndWait();
	}
	public static Optional<ButtonType> cancelarVenda() {
		alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Cancelar a venda!");
		alert.setHeaderText("Voc� deseja voltar e cancelar a venda?");
		return alert.showAndWait();
	}
	public static Optional<ButtonType> cancelarCadastro() {
		alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Cancelar cadastro!");
		alert.setHeaderText("Voce deseja voltar e cancelar o cadastro?");
		return alert.showAndWait();
	}
	public static Optional<ButtonType> removerItem() {
		alert = new Alert(Alert.AlertType.CONFIRMATION);
		alert.setTitle("Exclus�o de item!");
		alert.setHeaderText("Voc� deseja excluir o item selecionado?");
		return alert.showAndWait();
	}
}

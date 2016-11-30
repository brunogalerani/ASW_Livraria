package auxiliares;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

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
	
}

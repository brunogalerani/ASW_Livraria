package session;

import models.Funcionario;

public class Session {
	
	private Funcionario usuarioLogado;

	public Funcionario getFuncionario() {
		return usuarioLogado;
	}

	public void setFuncionario(Funcionario funcionario) {
		this.usuarioLogado = funcionario;
	}
	
	
}

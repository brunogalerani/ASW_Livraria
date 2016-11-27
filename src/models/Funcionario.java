package models;

import java.util.List;

import javax.persistence.MappedSuperclass;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@MappedSuperclass
public abstract class Funcionario extends Pessoa {
	
	@Transient
	private AcaoUsuario acaoUsuario;
	private String matricula;
	@OneToMany
	private List<Pedido> pedidos;

	public Funcionario() {
		super();
	}

	public AcaoUsuario getAcaoUsuario() {
		return acaoUsuario;
	}

	public void setAcaoUsuario(AcaoUsuario acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}

	public String getMatricula() {
		return matricula;
	}

	public void setMatricula(String matricula) {
		this.matricula = matricula;
	}

}

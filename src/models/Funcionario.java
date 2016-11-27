package models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Transient;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Funcionario extends Pessoa {

	
	@Transient
	private AcaoUsuario acaoUsuario;
	@Column(unique = true)
	private String login;
	/*@OneToMany(mappedBy="funcionario")
	private List<Pedido> pedidos;*/

	public Funcionario() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

//	public List<Pedido> getPedidos() {
//		return pedidos;
//	}

	public AcaoUsuario getAcaoUsuario() {
		return acaoUsuario;
	}

	public void setAcaoUsuario(AcaoUsuario acaoUsuario) {
		this.acaoUsuario = acaoUsuario;
	}
}

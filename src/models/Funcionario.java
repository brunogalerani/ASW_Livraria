package models;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.OneToMany;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public abstract class Funcionario extends Pessoa {

	@Column(unique = true)
	private String login;
	@OneToMany(mappedBy="funcionario")
	private List<Pedido> pedidos;

	public Funcionario() {
		super();
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public List<Pedido> getPedidos() {
		return pedidos;
	}
}

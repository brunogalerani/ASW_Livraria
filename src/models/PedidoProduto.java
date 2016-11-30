package models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Entity
public class PedidoProduto {
	@Id
	private Long id;
	@ManyToOne
	private Pedido pedido;
	@ManyToOne
	private Produto produto;
	
}

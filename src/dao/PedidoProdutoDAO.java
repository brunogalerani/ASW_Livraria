package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.Celular;
import models.PedidoProduto;

public class PedidoProdutoDAO {
	private EntityManager manager;

	public PedidoProdutoDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(PedidoProduto pedido_produto) {
		this.manager.getTransaction().begin();
		this.manager.persist(pedido_produto);
		this.manager.getTransaction().commit();
	}

	public void update(PedidoProduto pedido_produto) {
		this.manager.getTransaction().begin();
		this.manager.merge(pedido_produto);
		this.manager.getTransaction().commit();
	}

	public void remove(PedidoProduto pedido_produto) {
		this.manager.getTransaction().begin();
		pedido_produto = this.manager.find(PedidoProduto.class, pedido_produto.getId());
		this.manager.remove(pedido_produto);
		this.manager.getTransaction().commit();
	}

	public List<PedidoProduto> all() {
		Query query = this.manager.createQuery("select p from PedidoProduto p");
		List<PedidoProduto> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

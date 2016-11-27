package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.EBook;
import models.Pedido;

public class PedidoDAO {
	private EntityManager manager;

	public PedidoDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Pedido pedido) {
		this.manager.getTransaction().begin();
		this.manager.persist(pedido);
		this.manager.getTransaction().commit();
	}

	public void update(Pedido pedido) {
		this.manager.getTransaction().begin();
		this.manager.merge(pedido);
		this.manager.getTransaction().commit();
	}

	public void remove(Pedido pedido) {
		this.manager.getTransaction().begin();
		pedido = this.manager.find(Pedido.class, pedido.hashCode());
		this.manager.remove(pedido);
		this.manager.getTransaction().commit();
	}

	public List<Pedido> all() {
		Query query = this.manager.createQuery("select e from EBook e");
		List<Pedido> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.Produto;

public class ProdutoDAO {
	private EntityManager manager;

	public ProdutoDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Produto produto) {
		this.manager.getTransaction().begin();
		this.manager.persist(produto);
		this.manager.getTransaction().commit();
	}

	public void update(Produto produto) {
		this.manager.getTransaction().begin();
		this.manager.merge(produto);
		this.manager.getTransaction().commit();
	}

	public void remove(Produto produto) {
		this.manager.getTransaction().begin();
		produto = this.manager.find(Produto.class, produto.hashCode());
		this.manager.remove(produto);
		this.manager.getTransaction().commit();
	}

	public List<Produto> all() {
		Query query = this.manager.createQuery("select p from Produto p");
		List<Produto> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}
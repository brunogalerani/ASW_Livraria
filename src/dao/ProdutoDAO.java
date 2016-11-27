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
	public List<Produto> all() {
		Query query = manager.createQuery("select p from Produto p");
		List<Produto> list = query.getResultList();
		return list;
	}
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import database.JPAUtil;
import models.Vendedor;

public class VendedorDAO {
	private EntityManager manager;

	public VendedorDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Vendedor vendedor) {
		this.manager.getTransaction().begin();
		this.manager.persist(vendedor);
		this.manager.getTransaction().commit();
	}

	public void update(Vendedor vendedor) {
		this.manager.getTransaction().begin();
		this.manager.merge(vendedor);
		this.manager.getTransaction().commit();
	}

	public void remove(Vendedor vendedor) {
		this.manager.getTransaction().begin();
		vendedor = this.manager.find(Vendedor.class, vendedor.getCpf());
		this.manager.remove(vendedor);
		this.manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Vendedor> all() {
		Query query = this.manager.createQuery("select g from Gerente g");
		List<Vendedor> list = query.getResultList();
		return list;
	}

	public Vendedor selectFromLogin(String login) {
		try {
			TypedQuery<Vendedor> query = this.manager.createQuery("select v from Vendedor v where v.login=:login",
					Vendedor.class);
			query.setParameter("login", login);
			Vendedor vendedor = query.getSingleResult();

			return vendedor;
		} catch (NoResultException e) {
			return null;
		}
	}
}

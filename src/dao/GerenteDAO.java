package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import database.JPAUtil;
import models.Gerente;

public class GerenteDAO {

	private EntityManager manager;

	public GerenteDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Gerente gerente) {
		this.manager.getTransaction().begin();
		this.manager.persist(gerente);
		this.manager.getTransaction().commit();
	}

	public void update(Gerente gerente) {
		this.manager.getTransaction().begin();
		this.manager.merge(gerente);
		this.manager.getTransaction().commit();
	}

	public void remove(Gerente gerente) {
		this.manager.getTransaction().begin();
		gerente = this.manager.find(Gerente.class, gerente.getCpf());
		this.manager.remove(gerente);
		this.manager.getTransaction().commit();
	}

	public List<Gerente> all() {
		Query query = this.manager.createQuery("select g from Gerente g");
		List<Gerente> list = query.getResultList();
		return list;
	}

	public Gerente selectFromLogin(String login) {
		try {
			TypedQuery<Gerente> query = this.manager.createQuery("select g from Gerente g where g.login=:login",
					Gerente.class);
			query.setParameter("login", login);			
			Gerente gerente = query.getSingleResult();

			return gerente;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}

}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.Celular;
import models.DispMovel;
import models.Produto;

public class CelularDAO {
	private EntityManager manager;

	public CelularDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Celular dispMovel) {
		this.manager.getTransaction().begin();
		this.manager.persist(dispMovel);
		this.manager.getTransaction().commit();
	}

	public void update(Celular dispMovel) {
		this.manager.getTransaction().begin();
		this.manager.merge(dispMovel);
		this.manager.getTransaction().commit();
	}

	public void remove(Celular dispMovel) {
		this.manager.getTransaction().begin();
		dispMovel = this.manager.find(Celular.class, dispMovel.getCodBarras());
		this.manager.remove(dispMovel);
		this.manager.getTransaction().commit();
	}

	public List<Celular> all() {
		Query query = this.manager.createQuery("select d from DispMovel d");
		List<Celular> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

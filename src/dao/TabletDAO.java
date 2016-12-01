package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.Tablet;

public class TabletDAO {
	private EntityManager manager;

	public TabletDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Tablet tablet) {
		this.manager.getTransaction().begin();
		this.manager.persist(tablet);
		this.manager.getTransaction().commit();
	}

	public void update(Tablet tablet) {
		this.manager.getTransaction().begin();
		this.manager.merge(tablet);
		this.manager.getTransaction().commit();
	}

	public void remove(Tablet tablet) {
		this.manager.getTransaction().begin();
		tablet = this.manager.find(Tablet.class, tablet.getCodBarras());
		this.manager.remove(tablet);
		this.manager.getTransaction().commit();
	}

	@SuppressWarnings("unchecked")
	public List<Tablet> all() {
		Query query = this.manager.createQuery("select t from Tablet t");
		List<Tablet> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

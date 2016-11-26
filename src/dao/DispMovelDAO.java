package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.DispMovel;

public class DispMovelDAO {
	private EntityManager manager;
	
	public DispMovelDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	public void insert(DispMovel dispMovel) {
		this.manager.getTransaction().begin();
		this.manager.persist(dispMovel);
		this.manager.getTransaction().commit();
	}
	public void update(DispMovel dispMovel) {
		this.manager.getTransaction().begin();
		this.manager.merge(dispMovel);
		this.manager.getTransaction().commit();
	}
	public void remove(DispMovel dispMovel) {
		this.manager.getTransaction().begin();
		dispMovel = this.manager.find(DispMovel.class, dispMovel.getCodBarras());
		this.manager.remove(dispMovel);
		this.manager.getTransaction().commit();
	}
	public List<DispMovel> all() {
		Query query = this.manager.createQuery("select d from DispMovel d");
		List<DispMovel> list = query.getResultList();
		return list;
	}
	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

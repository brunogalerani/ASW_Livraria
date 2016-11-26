package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.EBook;

public class EBookDAO {
	private EntityManager manager;
	
	public EBookDAO() {
		this.manager = JPAUtil.getEntityManager();
	}
	
	public void insert(EBook eBook) {
		this.manager.getTransaction().begin();
		this.manager.persist(eBook);
		this.manager.getTransaction().commit();
	}
	public void update(EBook eBook) {
		this.manager.getTransaction().begin();
		this.manager.merge(eBook);
		this.manager.getTransaction().commit();
	}
	public void remove(EBook eBook) {
		this.manager.getTransaction().begin();
		eBook = this.manager.find(EBook.class, eBook.getIsbn());
		this.manager.remove(eBook);
		this.manager.getTransaction().commit();
	}
	public List<EBook> all() {
		Query query = this.manager.createQuery("select e from EBook e");
		List<EBook> list = query.getResultList();
		return list;
	}
	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

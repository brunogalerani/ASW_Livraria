package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.LivroFisico;

public class LivroFisicoDAO {
	private EntityManager manager;

	public LivroFisicoDAO() {
		manager = JPAUtil.getEntityManager();
	}

	public void insert(LivroFisico livroFisico) {
		this.manager.getTransaction().begin();
		this.manager.persist(livroFisico);
		this.manager.getTransaction().commit();
	}

	public void update(LivroFisico livroFisico) {
		this.manager.getTransaction().begin();
		this.manager.merge(livroFisico);
		this.manager.getTransaction().commit();
	}

	public void remove(LivroFisico livroFisico) {
		this.manager.getTransaction().begin();
		livroFisico = this.manager.find(LivroFisico.class, livroFisico.getIsbn());
		this.manager.remove(livroFisico);
		this.manager.getTransaction().commit();
	}

	public List<LivroFisico> all() {
		Query query = this.manager.createQuery("select l from LivroFisico l");
		List<LivroFisico> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

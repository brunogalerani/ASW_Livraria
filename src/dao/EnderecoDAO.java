package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.*;

public class EnderecoDAO {
	private EntityManager manager;

	public EnderecoDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Endereco endereco) {
		this.manager.getTransaction().begin();
		this.manager.persist(endereco);
		this.manager.getTransaction().commit();
	}

	public void update(Endereco endereco) {
		this.manager.getTransaction().begin();
		this.manager.merge(endereco);
		this.manager.getTransaction().commit();
	}

	public void remove(Endereco endereco) {
		this.manager.getTransaction().begin();
		endereco = this.manager.find(Endereco.class, endereco.getNumero());
		this.manager.remove(endereco);
		this.manager.getTransaction().commit();
	}

	public List<Endereco> all() {
		Query query = this.manager.createQuery("select e from Endereco e");
		List<Endereco> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

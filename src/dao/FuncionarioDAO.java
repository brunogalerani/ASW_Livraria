package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.*;

public class FuncionarioDAO {
	private EntityManager manager;

	public FuncionarioDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	public void insert(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		this.manager.persist(funcionario);
		this.manager.getTransaction().commit();
	}

	public void update(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		this.manager.merge(funcionario);
		this.manager.getTransaction().commit();
	}

	public void remove(Funcionario funcionario) {
		this.manager.getTransaction().begin();
		funcionario = this.manager.find(Funcionario.class, funcionario.getCpf());
		this.manager.remove(funcionario);
		this.manager.getTransaction().commit();
	}

	public List<Funcionario> all() {
		Query query = this.manager.createQuery("select f from Funcionario f");
		List<Funcionario> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

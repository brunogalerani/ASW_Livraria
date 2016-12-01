package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import database.JPAUtil;
import models.Funcionario;

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

	@SuppressWarnings("unchecked")
	public List<Funcionario> all() {
		Query query = this.manager.createQuery("select f from Funcionario f");
		List<Funcionario> list = query.getResultList();
		return list;
	}

	public Funcionario selectFromLogin(String login, String password) {
		try {
			TypedQuery<Funcionario> query = this.manager.createQuery(
					"select f from Funcionario f where f.login=:login and f.senha=:senha", Funcionario.class);
			query.setParameter("login", login);
			query.setParameter("senha", password);
			Funcionario funcionario = query.getSingleResult();

			return funcionario;
		} catch (NoResultException e) {
			return null;
		}
	}

	@Override
	protected void finalize() {
		this.manager.close();
	}
}

package dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import database.JPAUtil;
import models.VideoGame;

public class VideoGameDAO {
	private EntityManager manager;

	public VideoGameDAO() {
		this.manager = JPAUtil.getEntityManager();
	}

	private void insert(VideoGame videoGame) {
		this.manager.getTransaction().begin();
		this.manager.persist(videoGame);
		this.manager.getTransaction().commit();
	}

	private void update(VideoGame videoGame) {
		this.manager.getTransaction().begin();
		this.manager.merge(videoGame);
		this.manager.getTransaction().commit();
	}

	private void remove(VideoGame videoGame) {
		this.manager.getTransaction().begin();
		videoGame = this.manager.find(VideoGame.class, videoGame.getModelo());
		this.manager.remove(videoGame);
		this.manager.getTransaction().commit();
	}

	private List<VideoGame> all() {
		Query query = this.manager.createQuery("select v from VideoGame v");
		List<VideoGame> list = query.getResultList();
		return list;
	}

	@Override
	protected void finalize() throws Throwable {
		this.manager.close();
	}
}

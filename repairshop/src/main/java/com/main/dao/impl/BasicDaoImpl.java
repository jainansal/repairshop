package com.main.dao.impl;

import javax.persistence.EntityManager;

import com.main.dao.BasicDao;
import com.main.dao.exceptions.ResourceNotFoundException;
import com.main.provider.EntityManagerFactoryProvider;

public class BasicDaoImpl<T> implements BasicDao<T> {

	private static EntityManager em = EntityManagerFactoryProvider.getEntityManager();
	private Class<T> clazz;

	public BasicDaoImpl(Class<T> clazz) {
		this.clazz = clazz;
	}

	@Override
	public T add(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public T findById(int id) throws ResourceNotFoundException {
		T t = em.find(clazz, id);
		if (t == null) {
			throw new ResourceNotFoundException();
		}
		return t;
	}

	@Override
	public T update(T t) {
		em.persist(t);
		return t;
	}

	@Override
	public boolean deleteById(int id) throws ResourceNotFoundException {
		T t = findById(id);
		em.remove(t);
		return true;
	}

}

package com.main.dao;

import com.main.dao.exceptions.ResourceNotFoundException;

public interface BasicDao<T> {
	T add(T t);

	T findById(int id) throws ResourceNotFoundException;

	T update(T t);

	boolean deleteById(int id) throws ResourceNotFoundException;
}

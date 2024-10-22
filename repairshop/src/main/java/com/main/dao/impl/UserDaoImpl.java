package com.main.dao.impl;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.main.dao.UserDao;
import com.main.model.Customer;
import com.main.model.User;
import com.main.provider.EntityManagerFactoryProvider;

public class UserDaoImpl extends BasicDaoImpl<User> implements UserDao {
	private static EntityManager em = EntityManagerFactoryProvider.getEntityManager();

	public UserDaoImpl() {
		super(User.class);
	}

	private User findUniqueByField(String clazz, String field, String value) {
		String queryStr = "SELECT c FROM " + clazz + " c WHERE c." + field + " = :value";
		Query query = em.createQuery(queryStr);
		query.setParameter("value", value);
		Object customer = query.getSingleResult();
		return (Customer) customer;
	}

	private List<User> findMultipleByField(String clazz, String field, String value) {
		String queryStr = "SELECT c FROM " + clazz + " c WHERE c." + field + " = :value";
		Query query = em.createQuery(queryStr);
		query.setParameter("value", value);
		List customers = query.getResultList();
		return customers;
	}

	@Override
	public User findByEmail(String email, String type) {
		User user = null;
		if (type == "CLERK") {
			user = findUniqueByField("Clerk", "email", email);
		} else if (type == "CUSTOMER") {
			user = findUniqueByField("Customer", "email", email);
		} else if (type == "REPAIR") {
			user = findUniqueByField("RepairPerson", "email", email);
		}
		return user;
	}

	@Override
	public List<User> findByName(String name, String type) {
		List<User> users = new ArrayList<User>();
		if (type == "CLERK") {
			users = findMultipleByField("Clerk", "name", name);
		} else if (type == "CUSTOMER") {
			users = findMultipleByField("Customer", "name", name);
		} else if (type == "REPAIR") {
			users = findMultipleByField("RepairPerson", "name", name);
		}
		return users;
	}

}

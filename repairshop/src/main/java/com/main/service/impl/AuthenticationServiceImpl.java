package com.main.service.impl;

import javax.persistence.EntityManager;

import com.main.dao.UserDao;
import com.main.dao.impl.UserDaoImpl;
import com.main.model.Clerk;
import com.main.model.Customer;
import com.main.model.RepairPerson;
import com.main.model.User;
import com.main.provider.EntityManagerFactoryProvider;
import com.main.service.AuthenticationService;

public class AuthenticationServiceImpl implements AuthenticationService {

	@Override
	public User login(String email, String password, String type) {
		UserDao userDao = new UserDaoImpl();
		User user = userDao.findByEmail(email, type);
		if (user == null) {
			System.out.println("User not found");
			return null;
		}
		// TODO To hash password
		if (password.equals(user.getHashedPassword()) == false) {
			System.out.println("Invalid credentials");
			return null;
		}
		return user;
	}

	@Override
	public User register(String name, String email, String phone, String password, User createdBy, String type) {
		EntityManager em = EntityManagerFactoryProvider.getEntityManager();
		em.getTransaction().begin();
		UserDao userDao = new UserDaoImpl();
		User user = null;
		if (userDao.findByEmail(email, type) != null) {
			System.out.println("User already exists");
			return null;
		}
		if (type == "CLERK") {
			user = userDao.add(new Clerk(0, name, email, phone, password, createdBy));
		} else if (type == "CUSTOMER") {
			user = userDao.add(new Customer(0, name, email, phone, password, createdBy));
		} else if (type == "REPAIR") {
			user = userDao.add(new RepairPerson(0, name, email, phone, password, createdBy));
		}
		em.getTransaction().commit();
		return user;
	}

}

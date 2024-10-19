package com.main.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.Query;

import com.main.dao.CustomerDao;
import com.main.model.Customer;
import com.main.provider.EntityManagerFactoryProvider;

public class CustomerDaoImpl extends BasicDaoImpl<Customer> implements CustomerDao {

	private static EntityManager em = EntityManagerFactoryProvider.getEntityManager();

	public CustomerDaoImpl() {
		super(Customer.class);
	}

	private Customer findUniqueByField(String field, String value) {
		String queryStr = "SELECT c FROM Customer c WHERE c." + field + " = :value";
		Query query = em.createQuery(queryStr);
		query.setParameter("value", value);
		Object customer = query.getSingleResult();
		return (Customer) customer;
	}

	private List<Customer> findMultipleByField(String field, String value) {
		String queryStr = "SELECT c FROM Customer c WHERE c." + field + " = :value";
		Query query = em.createQuery(queryStr);
		query.setParameter("value", value);
		List customers = query.getResultList();
		return customers;
	}

	@Override
	public List<Customer> findByName(String name) {
		return findMultipleByField("name", name);
	}

	@Override
	public Customer findByPhone(String phone) {
		return findUniqueByField("phone", phone);
	}
}

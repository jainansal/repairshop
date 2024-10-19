package com.main;

import com.main.dao.CustomerDao;
import com.main.dao.impl.CustomerDaoImpl;
import com.main.model.Customer;

public class MainTest {
	public static void main(String[] args) {
		CustomerDao customerDao = new CustomerDaoImpl();
		Customer customer = customerDao.findByPhone("8527479978");
		System.out.println(customer);
	}
}

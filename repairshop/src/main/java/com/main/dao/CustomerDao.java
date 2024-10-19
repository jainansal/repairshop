package com.main.dao;

import java.util.List;

import com.main.model.Customer;

public interface CustomerDao extends BasicDao<Customer> {
	List<Customer> findByName(String name);
	Customer findByPhone(String phone);
}

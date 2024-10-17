package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("customer")
public class Customer extends User {

	public Customer() {
		super();
	}

	public Customer(int id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}
	
}

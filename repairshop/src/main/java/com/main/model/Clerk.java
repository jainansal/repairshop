package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("clerk")
public class Clerk extends User {

	public Clerk() {
		super();
	}

	public Clerk(int id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}
}

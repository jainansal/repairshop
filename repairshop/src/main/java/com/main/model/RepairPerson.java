package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("repair")
public class RepairPerson extends User {

	public RepairPerson() {
		super();
	}

	public RepairPerson(int id, String name, String email, String phone, String password) {
		super(id, name, email, phone, password);
	}

}
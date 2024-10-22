package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("REPAIR")
public class RepairPerson extends User {

	public RepairPerson() {
		super();
	}

	public RepairPerson(int id, String name, String email, String phone, String hashedPassword, User createdBy) {
		super(id, name, email, phone, hashedPassword, createdBy);
	}

}

package com.main.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
public abstract class RequestForApproval {
	@Id
	@GeneratedValue
	private int id;

	private String description;
	private Double serviceCharge;
	private String label; // High priority, additional benefits, etc

	@ManyToOne
	private Service service;

	public RequestForApproval(int id, String description, Double serviceCharge, String label, Service service) {
		super();
		this.id = id;
		this.description = description;
		this.serviceCharge = serviceCharge;
		this.label = label;
		this.service = service;
	}

	public RequestForApproval() {
		super();
	}

}

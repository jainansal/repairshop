package com.main.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

@Entity
public class RepairJob {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	@Column(columnDefinition = "boolean default false")
	private Boolean isClosed;

	@ManyToOne
	private Service service;
	@OneToOne
	private RepairPerson assignedTo;
	@ManyToOne
	private Clerk createdBy;

	public RepairJob() {
		super();
	}

	public RepairJob(int id, Service service, RepairPerson assignedTo, Clerk createdBy) {
		super();
		this.id = id;
		this.service = service;
		this.assignedTo = assignedTo;
		this.createdBy = createdBy;
	}

}

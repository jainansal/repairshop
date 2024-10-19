package com.main.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;

@Entity
public class ServiceStatus {
	@Id
	@GeneratedValue
	private int id;

	@ManyToOne
	private Service service;

	private String description; // Approved for repair, pending request

	@CreationTimestamp
	private LocalDateTime createdAt;

	public ServiceStatus() {
		super();
	}

	public ServiceStatus(int id, Service service, String description) {
		super();
		this.id = id;
		this.service = service;
		this.description = description;
	}

}

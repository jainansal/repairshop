package com.main.model;

import java.time.LocalDateTime;

import javax.persistence.Column;
import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class RequestForApproval {
	@Id
	@GeneratedValue
	private int id;

	private String description;
	private Double serviceCharge;
	private String label; // High priority, additional benefits, etc
	@Column(columnDefinition = "varchar(255) default 'waiting for approval'")
	private String approvalStatus;
	private LocalDateTime statusUpdatedAt;

	@ManyToOne
	private Service service;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

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

package com.main.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Invoice {
	@Id
	@GeneratedValue
	private int id;
	@OneToOne // Can be modified to ManyToOne later
	private Service service;
	@OneToMany // Can be modified to ManyToMany later
	private List<RequestForApproval> approvedRequests;
	private Double totalAmount;
	private int otp; // 4 digits
	@Column(columnDefinition = "boolean default false")
	private Boolean isDelivered;
	private LocalDateTime deliveredAt;
	@ManyToOne
	private Clerk deliveredBy;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Invoice(int id, Service service, List<RequestForApproval> approvedRequests, Double totalAmount, int otp) {
		super();
		this.id = id;
		this.service = service;
		this.approvedRequests = approvedRequests;
		this.totalAmount = totalAmount;
		this.otp = otp;
	}

	public Invoice() {
	}

}

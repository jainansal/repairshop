package com.main.model;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
public class Service {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String code;
	private double baseCharge;

	@OneToOne
	private DefectiveItem defectiveItem;
	@ManyToOne
	private Customer customer;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;

	public Service() {
		super();
	}

	public Service(int id, String code, double baseCharge, DefectiveItem defectiveItem, Customer customer) {
		super();
		this.id = id;
		this.code = code;
		this.baseCharge = baseCharge;
		this.defectiveItem = defectiveItem;
		this.customer = customer;
	}

}

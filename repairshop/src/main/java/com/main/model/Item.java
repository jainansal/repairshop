package com.main.model;

import java.time.LocalDateTime;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToOne;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

@Entity
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="type", discriminatorType = DiscriminatorType.STRING)
public abstract class Item {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	private String productCode;
	private String title;
	private String description;
	private String category;

	@CreationTimestamp
	private LocalDateTime createdAt;
	@UpdateTimestamp
	private LocalDateTime updatedAt;
	@ManyToOne
	private User createdBy;

	public Item() {
		super();
	}

	public Item(int id, String productCode, String title, String description, String category, User createdBy) {
		super();
		this.id = id;
		this.productCode = productCode;
		this.title = title;
		this.description = description;
		this.category = category;
		this.createdBy = createdBy;
	}

}

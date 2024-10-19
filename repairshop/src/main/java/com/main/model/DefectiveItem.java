package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("defective")
public class DefectiveItem extends Item {

	@ManyToOne
	private Customer customer;

	public DefectiveItem() {
		super();
	}

	public DefectiveItem(int id, String productCode, String title, String description, String category, User createdBy,
			Customer customer) {
		super(id, productCode, title, description, category, createdBy);
		this.customer = customer;
	}

}

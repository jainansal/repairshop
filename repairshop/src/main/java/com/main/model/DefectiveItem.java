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

	public DefectiveItem(int id, String productCode, String title, String description, String category) {
		super(id, productCode, title, description, category);
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

}

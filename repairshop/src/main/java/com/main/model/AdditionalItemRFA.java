package com.main.model;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class AdditionalItemRFA extends RequestForApproval {

	@ManyToOne
	private NewItem newItem;

	public AdditionalItemRFA(int id, String description, Double serviceCharge, String label, Service service,
			NewItem newItem) {
		super(id, description, serviceCharge, label, service);
		this.newItem = newItem;
	}

	public AdditionalItemRFA() {
		super();
	}

}

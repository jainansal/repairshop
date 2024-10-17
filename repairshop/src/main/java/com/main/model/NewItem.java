package com.main.model;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("new")
public class NewItem extends Item {

	public NewItem() {
		super();
	}

	public NewItem(int id, String productCode, String title, String description, String category) {
		super(id, productCode, title, description, category);
	}
}

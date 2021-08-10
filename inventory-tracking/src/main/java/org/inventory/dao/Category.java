package org.inventory.dao;

import javax.persistence.*;

@Entity
@Table(name = "category")
public class Category {
	private long categoryId;
	private String name;
	
	public Category() {
		
	}

	@Id
	@Column(name = "category_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(long categoryId) {
		this.categoryId = categoryId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

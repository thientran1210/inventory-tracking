package org.inventory.entities;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "catalog")
public class Catalog {
	private long itemId;
	private String itemCode;
	private String description;
	private float price;
	
	private Set<CatalogDetail> catalogDetail = new HashSet<CatalogDetail>();

	public Catalog() {
		
	}
	
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "item_id")
	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	@Column(name = "item_code")
	public String getItemCode() {
		return itemCode;
	}

	public void setItemCode(String itemCode) {
		this.itemCode = itemCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

    @OneToMany(mappedBy = "primaryKey.item",
            cascade = CascadeType.ALL)
	public Set<CatalogDetail> getCatalogDetail() {
		return catalogDetail;
	}

	public void setCatalogDetail(Set<CatalogDetail> catalogDetail) {
		this.catalogDetail = catalogDetail;
	}
	
    public void addCatalogDetail(CatalogDetail catalogDetail) {
        this.catalogDetail.add(catalogDetail);
    }
}

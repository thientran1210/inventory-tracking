package org.inventory.entities;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Embeddable;
import javax.persistence.ManyToOne;

@Embeddable
public class CatalogWarehouseId implements Serializable {
	private Warehouse warehouse;
	private Catalog item;
	
	public CatalogWarehouseId() {
		
	}
	
    @ManyToOne(cascade = CascadeType.ALL)
    public Catalog getItem() {
        return item;
    }
 
    public void setItem(Catalog item) {
        this.item = item;
    }
 
    @ManyToOne(cascade = CascadeType.ALL)
    public Warehouse getWarehouse() {
        return warehouse;
    }
 
    public void setWarehouse(Warehouse warehouse) {
        this.warehouse = warehouse;
    }
}

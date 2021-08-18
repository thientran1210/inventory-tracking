package org.inventory.entities;

import javax.persistence.AssociationOverride;
import javax.persistence.AssociationOverrides;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

@Entity
@Table(name = "catalog_detail")
@AssociationOverrides({
    @AssociationOverride(name = "primaryKey.item",
        joinColumns = @JoinColumn(name = "item_id")),
    @AssociationOverride(name = "primaryKey.warehouse",
        joinColumns = @JoinColumn(name = "warehouse_id")) })
public class CatalogDetail {
    // composite-id key
    private CatalogWarehouseId primaryKey = new CatalogWarehouseId();
     
    private long qty;
 
    @EmbeddedId
    public CatalogWarehouseId getPrimaryKey() {
        return primaryKey;
    }
 
    public void setPrimaryKey(CatalogWarehouseId primaryKey) {
        this.primaryKey = primaryKey;
    }
 
    @Transient
    public Catalog getItem() {
        return getPrimaryKey().getItem();
    }
 
    public void setItem(Catalog item) {
        getPrimaryKey().setItem(item);
    }
 
    @Transient
    public Warehouse getWarehouse() {
        return getPrimaryKey().getWarehouse();
    }
 
    public void setWarehouse(Warehouse warehouse) {
        getPrimaryKey().setWarehouse(warehouse);
    }
 
    public long getQty() {
        return qty;
    }
 
    public void setQty(long qty) {
        this.qty = qty;
    }
}

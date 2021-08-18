package org.inventory.entities;

import java.util.Set;
import java.util.HashSet;

import javax.persistence.*;

@Entity
@Table(name = "warehouse")
public class Warehouse {
	private long warehouseId;
	private String warehouseCode;
	private String address_1;
	private String address_2;
	private String state;
	private long postcode;

	private Set<CatalogDetail> catalogDetail = new HashSet<CatalogDetail>();
	
	public Warehouse() {
		
	}

	@Id
	@Column(name = "warehouse_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long locationId) {
		this.warehouseId = locationId;
	}

	@Column(name = "warehouse_code")
	public String getWarehouseCode() {
		return warehouseCode;
	}

	
	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getAddress_1() {
		return address_1;
	}

	public void setAddress_1(String address_1) {
		this.address_1 = address_1;
	}

	public String getAddress_2() {
		return address_2;
	}

	public void setAddress_2(String address_2) {
		this.address_2 = address_2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public long getPostcode() {
		return postcode;
	}

	public void setPostcode(long postcode) {
		this.postcode = postcode;
	}
	
    @OneToMany(mappedBy = "primaryKey.warehouse",
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

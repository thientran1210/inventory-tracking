package org.inventory.dao;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Warehouse {
	private long warehouseId;
	private String address_1;
	private String address_2;
	private String state;
	private long postcode;

	public Warehouse() {
		
	}

	@Id
	@Column(name = "warehouse_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getLocationId() {
		return warehouseId;
	}

	public void setLocationId(long locationId) {
		this.warehouseId = locationId;
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
}

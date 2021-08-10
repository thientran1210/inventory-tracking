package org.inventory.dao;

import javax.persistence.*;

@Entity
@Table(name = "location")
public class Location {
	private long locationId;
	private String location;

	public Location() {
		
	}

	@Id
	@Column(name = "location_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	public long getLocationId() {
		return locationId;
	}

	public void setLocationId(long locationId) {
		this.locationId = locationId;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}
	
	
}

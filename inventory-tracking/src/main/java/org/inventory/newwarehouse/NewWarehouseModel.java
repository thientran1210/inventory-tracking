package org.inventory.newwarehouse;

import java.util.List;

import org.hibernate.Session;
import org.inventory.entities.Warehouse;
import org.inventory.util.*;

public class NewWarehouseModel extends AbstractModel{
 
	private String warehouseCode;
	private String address1;
	private String address2;
	private String state;
	private int postcode;
	
    public void createNewWarehouse(String warehouseCode, String address1, String address2, String state, int postcode) {
        // code to save a warehouse
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(warehouseCode);
        warehouse.setAddress_1(address1);
        warehouse.setAddress_2(address2);
        warehouse.setState(state);
        warehouse.setPostcode(postcode);
     
        Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
     
        session.save(warehouse);
     
        session.getTransaction().commit();
        session.close();
    }
 
    public List<Warehouse> getAllWarehouses() {
        // get warehouse list
    	Session session = HibernateUtil.getSessionFactory().openSession();
        session.beginTransaction();
        List<Warehouse> warehouses = HibernateUtil.loadAllData(Warehouse.class, session);
        session.getTransaction().commit();
        session.close();
        return warehouses;
    }

	public String getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public String getAddress1() {
		return address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public int getPostcode() {
		return postcode;
	}

	public void setPostcode(int postcode) {
		this.postcode = postcode;
	}
}

package org.inventory.view.warehouse;

import java.util.List;

import org.hibernate.HibernateException;
import org.inventory.entities.Catalog;
import org.inventory.entities.Warehouse;
import org.inventory.util.*;
import org.inventory.dao.WarehouseDAO;
import org.inventory.dao.WarehouseDAOImpl;
import org.inventory.dao.CatalogDAO;
import org.inventory.dao.CatalogDAOImpl;

public class WarehouseModel extends AbstractModel{
	
	private CatalogDAO catalogDAO;
	private WarehouseDAO warehouseDAO;
	
	public WarehouseModel() {
		this.catalogDAO = new CatalogDAOImpl();
		this.warehouseDAO = new WarehouseDAOImpl();
	}
	
    public void createNewWarehouse(String warehouseCode, String address1, String address2, String state, int postcode) {
    	// create a new warehouse and persist to the database
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseCode(warehouseCode);
        warehouse.setAddress_1(address1);
        warehouse.setAddress_2(address2);
        warehouse.setState(state);
        warehouse.setPostcode(postcode);
        
        try {
        	this.warehouseDAO.createWarehouse(warehouse);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
    }
 
    public List<Warehouse> getAllWarehouses() {
    	List<Warehouse> warehouses = null;
        try {
        	warehouses = this.warehouseDAO.getAllWarehouse();
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
        
        return warehouses;
    }
    
    public Warehouse getWarehouse(long warehouseId) {
    	Warehouse warehouse = null;
        try {
        	warehouse = this.warehouseDAO.getWarehouse(warehouseId);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
        
        return warehouse;
    }
    
    public Warehouse getWarehouseByCode(String warehouseCode) {
    	Warehouse warehouse = null;
        try {
        	warehouse = this.warehouseDAO.getWarehouseByCode(warehouseCode);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
        
        return warehouse;
    }
    
    public void updateWarehouse(Warehouse warehouse) {
        try {
        	this.warehouseDAO.updateWarehouse(warehouse);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
    }
    
    public void deleteWarehouse(long warehouseId) {
        try {
        	this.warehouseDAO.deleteWarehouse(warehouseId);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
    }
}

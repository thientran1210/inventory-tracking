package org.inventory.view.warehouse;

import java.util.List;

import org.inventory.entities.CatalogDetail;
import org.inventory.entities.Warehouse;
import org.inventory.util.*;

public class WarehouseModel extends AbstractModel{
	
	public WarehouseModel() {
		super();
		getAllWarehouses();
	}
	
	//method to save/update warehouse
    public void saveWarehouse(long warehouseId, 
    		String warehouseCode, String address1, String address2, String state, int postcode) {
    	
    	// create a new warehouse instance and persist to the database
        Warehouse warehouse = new Warehouse();
        warehouse.setWarehouseId(warehouseId);
        warehouse.setWarehouseCode(warehouseCode);
        warehouse.setAddress_1(address1);
        warehouse.setAddress_2(address2);
        warehouse.setState(state);
        warehouse.setPostcode(postcode);
    	if (warehouseId == 0) {
    		this.getWarehouseDAO().createWarehouse(warehouse);
    	} else {
    		this.getWarehouseDAO().updateWarehouse(warehouse);
    	}
    	
    	//after saving, refresh the list of warehouses
    	getAllWarehouses();
    }
    
    //method to search warehouse by using warehouse id
    public Warehouse getWarehouse(long warehouseId) {
    	Warehouse warehouse = null;
        warehouse = this.getWarehouseDAO().getWarehouse(warehouseId);
        
        return warehouse;
    }
    
    //method to search warehouse by using warehouse code
    public Warehouse getWarehouseByCode(String warehouseCode) {
    	Warehouse warehouse = null;
        warehouse = this.getWarehouseDAO().getWarehouseByCode(warehouseCode);
        return warehouse;
    }
    
    //method to delete warehouse by warehouse id
    public void deleteWarehouse(long warehouseId) throws ModelException {
    	Warehouse warehouse = getWarehouse(warehouseId);
    	//check if the warehouse exists
    	if (warehouse != null) {
    		//check if warehouse still has stock
    		List<CatalogDetail> catalogDetails = this.getCatalogDetailDAO().getCatalogDetailByWarehouseId(warehouse.getWarehouseId());
    		if (catalogDetails.size() > 0) {
    			throw new ModelException("Error cannot delete. Warehouse still have stock available.");
    		}
    		this.getWarehouseDAO().deleteWarehouse(warehouse);
    		this.getAllWarehouses();
    	} else {
    		throw new ModelException("Error cannot delete");
    	}
    }
   
  
}

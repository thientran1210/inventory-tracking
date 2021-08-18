package org.inventory.dao;

import java.util.List;

import org.inventory.entities.Catalog;
import org.inventory.entities.Warehouse;

public interface WarehouseDAO {
	public Warehouse getWarehouse(long warehouseId);
	public List<Warehouse> getAllWarehouse();
	public void createWarehouse(Warehouse warehouse);
	public void updateWarehouse(Warehouse warehouse);
	public void deleteWarehouse(long warehouseId);
	public void getCatalogDetail(Warehouse warehouse, Catalog item);
	public Warehouse getWarehouseByCode(String warehouse);
}

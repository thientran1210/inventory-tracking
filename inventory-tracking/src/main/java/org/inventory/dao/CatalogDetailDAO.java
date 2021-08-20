package org.inventory.dao;

import java.util.List;

import org.inventory.entities.CatalogDetail;
import org.inventory.entities.CatalogWarehouseId;

public interface CatalogDetailDAO {
	public List<CatalogDetail> getAllCatalogDetail();
	public CatalogDetail getCatalogDetail(CatalogWarehouseId catalogWarehouseId);
	public void createCatalogDetail(CatalogDetail catalogDetail);
	public void updateCatalogDetail(CatalogDetail catalogDetail);
	public List<CatalogDetail> getAllCatalogDetail(long warehouseCode, long itemCode);
	void deleteCatalogDetail(CatalogDetail catalogDetail);
	public List<CatalogDetail> getCatalogDetailByItemId(long itemId);
	public List<CatalogDetail> getCatalogDetailByWarehouseId(long warehouseId);
}

package org.inventory.view.stock_by_warehouse;

import java.util.List;

import org.inventory.entities.Catalog;
import org.inventory.entities.CatalogDetail;
import org.inventory.entities.Warehouse;
import org.inventory.util.AbstractModel;

public class StockByWarehouseModel extends AbstractModel{

	
	public StockByWarehouseModel() {
		super();
		getAllCatalogDetails();
	}
	
	//method to search for stock detail using warehouse code and item code
	public void search(String warehouseCode, String itemCode){
		Catalog item = this.getCatalogDAO().getCatalogByCode(itemCode);
		Warehouse warehouse = this.getWarehouseDAO().getWarehouseByCode(warehouseCode);
		List<CatalogDetail> catalogDetails = this.getCatalogDetailDAO().getAllCatalogDetail(
				warehouse.getWarehouseId(), item.getItemId());
		this.setCatalogDetails(catalogDetails);
	}
}

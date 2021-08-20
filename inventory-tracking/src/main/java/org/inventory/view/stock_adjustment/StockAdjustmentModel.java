package org.inventory.view.stock_adjustment;

import org.inventory.entities.Catalog;
import org.inventory.entities.CatalogDetail;
import org.inventory.entities.Warehouse;
import org.inventory.util.AbstractModel;
import org.inventory.util.ModelException;

public class StockAdjustmentModel extends AbstractModel{
	
	public StockAdjustmentModel() {
		super();
		getAllWarehouses();
		getAllCatalogs();
	}
	
	CatalogDetail createCatalogDetail(long warehouseId, long itemId, int qty) {
		Warehouse warehouse = this.getWarehouseDAO().getWarehouse(warehouseId);
		Catalog item = this.getCatalogDAO().getCatalog(itemId);
		CatalogDetail catalogDetail = new CatalogDetail();
		catalogDetail.setItem(item);
		catalogDetail.setWarehouse(warehouse);
		catalogDetail.setQty(qty);
		return catalogDetail;
	}
	
	CatalogDetail createCatalogDetail(long warehouseId, long itemId) {
		return createCatalogDetail(warehouseId, itemId, 0);
	}
	
	public void saveCatalogDetail(long warehouseId, long itemId, int qty) throws ModelException{
		//create new catalog detail to check whether to create new or update
		CatalogDetail catalogDetail = null;
		catalogDetail = getCatalogDetail(warehouseId, itemId);
		if (catalogDetail == null) {
			catalogDetail = createCatalogDetail(warehouseId, itemId, qty);
			this.getCatalogDetailDAO().createCatalogDetail(catalogDetail);
		} else {
			catalogDetail.setQty(qty);
			this.getCatalogDetailDAO().updateCatalogDetail(catalogDetail);
		}
	}
	
	public void deleteCatalogDetail(long warehouseId, long itemId) throws ModelException{
		//method to delete catalogDetail
		CatalogDetail catalogDetail = null;
		catalogDetail = getCatalogDetail(warehouseId, itemId);
		if (catalogDetail != null) {
			this.getCatalogDetailDAO().deleteCatalogDetail(catalogDetail);
		}
	}
	
	public CatalogDetail getCatalogDetail(long warehouseId, long itemId) throws ModelException{
		CatalogDetail catalogDetail = createCatalogDetail(warehouseId, itemId);
		//data validation
		checkModel(catalogDetail);
		return this.getCatalogDetailDAO().getCatalogDetail(catalogDetail.getPrimaryKey());
	}

	void checkModel(CatalogDetail catalogDetail) throws ModelException {
		//if qty is less than zero then throw error
		if (catalogDetail.getQty() < 0) {
			throw new ModelException("Quantity cannot be less than zero");
		}
		//if either item or warehouse is null then throw error
		if (catalogDetail.getWarehouse()== null) {
			throw new ModelException("Warehouse does not exist");
		}
		if (catalogDetail.getItem() == null) {
			throw new ModelException("Item does not exist");
		}
	}
}

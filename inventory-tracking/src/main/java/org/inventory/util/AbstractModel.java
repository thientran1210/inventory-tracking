package org.inventory.util;

import java.util.List;

import org.inventory.dao.CatalogDAO;
import org.inventory.dao.CatalogDAOImpl;
import org.inventory.dao.CatalogDetailDAO;
import org.inventory.dao.CatalogDetailDAOImpl;
import org.inventory.dao.WarehouseDAO;
import org.inventory.dao.WarehouseDAOImpl;
import org.inventory.entities.Catalog;
import org.inventory.entities.CatalogDetail;
import org.inventory.entities.Warehouse;

public abstract class AbstractModel {

	private WarehouseDAO warehouseDAO;
	private CatalogDAO catalogDAO;
	private CatalogDetailDAO catalogDetailDAO;
	private List<CatalogDetail> catalogDetails;
	private List<Catalog> catalogs;
	private List<Warehouse> warehouses;
		
	public AbstractModel() {
		this.catalogDetailDAO = new CatalogDetailDAOImpl();
		this.catalogDAO = new CatalogDAOImpl();
		this.warehouseDAO = new WarehouseDAOImpl();
	}

	public WarehouseDAO getWarehouseDAO() {
		return warehouseDAO;
	}

	public CatalogDAO getCatalogDAO() {
		return catalogDAO;
	}

	public CatalogDetailDAO getCatalogDetailDAO() {
		return catalogDetailDAO;
	}
	
	public List<CatalogDetail> getCatalogDetails() {
		return catalogDetails;
	}

	public void setCatalogDetails(List<CatalogDetail> catalogDetails) {
		this.catalogDetails = catalogDetails;
	}

	public List<Catalog> getCatalogs() {
		return catalogs;
	}

	public void setCatalogs(List<Catalog> catalogs) {
		this.catalogs = catalogs;
	}

	public List<Warehouse> getWarehouses() {
		return warehouses;
	}

	public void setWarehouses(List<Warehouse> warehouses) {
		this.warehouses = warehouses;
	}

	public void getAllCatalogDetails() {
		this.catalogDetails = this.catalogDetailDAO.getAllCatalogDetail();
	}
	
	public void getAllWarehouses() {
		this.warehouses = this.warehouseDAO.getAllWarehouse();
	}
	
	public void getAllCatalogs() {
		this.catalogs = this.catalogDAO.getAllCatalogs();
	}
}

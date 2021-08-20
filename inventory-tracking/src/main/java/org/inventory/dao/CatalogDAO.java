package org.inventory.dao;

import java.util.List;

import org.inventory.entities.Catalog;

public interface CatalogDAO {
	public Catalog getCatalog(long itemId);
	public List<Catalog> getAllCatalogs();
	public Catalog getCatalogByCode(String itemCode);
	public void createCatalog(Catalog item);
	public void updateCatalog(Catalog item);
	public void deleteCatalog(Catalog item);
}

package org.inventory.dao;

import java.util.List;

import org.inventory.entities.Catalog;

public interface CatalogDAO {
	public Catalog getCatalog(long itemId);
	public List<Catalog> getAllCatalog();
	public void createCatalog(Catalog item);
	public void updateCatalog(Catalog item);
	public void deleteCatalog(long itemId);
}

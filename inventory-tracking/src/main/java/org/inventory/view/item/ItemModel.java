package org.inventory.view.item;

import java.util.List;

import org.hibernate.HibernateException;
import org.inventory.entities.Catalog;
import org.inventory.entities.CatalogDetail;
import org.inventory.util.AbstractModel;
import org.inventory.util.ModelException;

public class ItemModel extends AbstractModel{
	
	public ItemModel() {
		super();
		getAllCatalogs();
	}
	
	//method to insert/update catalog
    public void saveCatalog(long itemId, String itemCode, String description, float price) throws ModelException {
    	// create a new warehouse and persist to the database
        Catalog item = new Catalog();
        item.setItemId(itemId);
        item.setItemCode(itemCode);
        item.setDescription(description);
        item.setPrice(price);
        
        //data validation
		checkModel(item);
        
		//if itemId is zero then it is new, insert it
    	if (itemId == 0) {
    		this.getCatalogDAO().createCatalog(item);
    	} else {
    		//else update it
    		this.getCatalogDAO().updateCatalog(item);
    	}
    	
    	//refresh all catalogs after saving
    	getAllCatalogs();
    }

    //method to get catalog by using item id
    public Catalog getCatalog(long itemId) {
    	Catalog item = null;
        try {
        	item = this.getCatalogDAO().getCatalog(itemId);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
        
        return item;
    }
    
    //method to get catalog by using item code
    public Catalog getCatalogByCode(String itemCode) {
    	Catalog item = null;
        try {
        	item = this.getCatalogDAO().getCatalogByCode(itemCode);
        } catch (HibernateException ex) {
        	ex.printStackTrace();
        }
        
        return item;
    }
    
    //method to delete catalog by using item id
    public void deleteCatalog(long itemId) throws ModelException{
    	Catalog item = getCatalog(itemId);
    	//check if catalog exist
    	if (item != null) {
    		//check if catalog still have stock
    		List<CatalogDetail> catalogDetails = this.getCatalogDetailDAO().getCatalogDetailByItemId(item.getItemId());
    		if (catalogDetails.size() > 0) {
    			throw new ModelException("Error cannot delete. Item still have stock available.");
    		}
    		this.getCatalogDAO().deleteCatalog(item);
    		this.getAllCatalogs();
    	} else {
    		throw new ModelException("Error cannot delete");
    	}
    }
	
	void checkModel(Catalog item) throws ModelException{
		if (item.getPrice() < 0) {
			throw new ModelException("Price cannot smaller than 0");
		}
	}
}

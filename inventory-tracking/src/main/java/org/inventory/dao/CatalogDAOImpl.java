package org.inventory.dao;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.inventory.entities.Catalog;
import org.inventory.entities.Warehouse;
import org.inventory.util.HibernateUtil;

public class CatalogDAOImpl implements CatalogDAO {

	@Override
	public Catalog getCatalog(long itemId) {
        // get the catalog by id
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        Catalog item = session.get(Catalog.class, itemId);
	        session.getTransaction().commit();
	        session.close();
	        return item;
		} catch (HibernateException ex) {
			ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
		}
		return null;
	}

	@Override
	public List<Catalog> getAllCatalog() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void createCatalog(Catalog item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void updateCatalog(Catalog item) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteCatalog(long itemId) {
		// TODO Auto-generated method stub

	}

}

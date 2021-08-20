package org.inventory.dao;

import java.util.List;

import javax.persistence.Query;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.inventory.entities.Catalog;
import org.inventory.util.HibernateUtil;

public class CatalogDAOImpl implements CatalogDAO {

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

	public List<Catalog> getAllCatalogs() {
        // get list of catalogs
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        List<Catalog> warehouses = HibernateUtil.loadAllData(Catalog.class, session);
	        session.getTransaction().commit();
	        session.close();
	        return warehouses;
		} catch (HibernateException ex) {
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
		}
	}

	public void createCatalog(Catalog item) {
		//insert new item into catalog
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.save(item);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	public void updateCatalog(Catalog item) {
		//update new item into catalog
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.update(item);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	public void deleteCatalog(Catalog item) {
		//delete item
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.delete(item);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}
	
	public Catalog getCatalogByCode(String itemCode) {
		Catalog item = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Catalog WHERE itemCode = :item_code";
	        session.beginTransaction();
	     
	        Query query = session.createQuery(hql);
	        query.setParameter("item_code",itemCode);
	        item = (Catalog) query.getSingleResult();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return item;
	}

}

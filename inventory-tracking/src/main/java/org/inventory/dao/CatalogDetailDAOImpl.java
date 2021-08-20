package org.inventory.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.inventory.entities.CatalogDetail;
import org.inventory.entities.CatalogWarehouseId;
import org.inventory.util.HibernateUtil;

public class CatalogDetailDAOImpl implements CatalogDetailDAO {

	
	public List<CatalogDetail> getAllCatalogDetail() {
        // get all stock detail
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        List<CatalogDetail> catalogDetails = HibernateUtil.loadAllData(CatalogDetail.class, session);
	        session.getTransaction().commit();
	        session.close();
	        return catalogDetails;
		} catch (HibernateException ex) {
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
		}
	}
	
	
	public List<CatalogDetail> getAllCatalogDetail(long warehouseId, long itemId) {
		List<CatalogDetail> catalogDetails = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM CatalogDetail WHERE primaryKey.warehouse.warehouseId = :warehouse_id AND primaryKey.item.itemId = :item_id";
	        session.beginTransaction();
	     
	        TypedQuery<CatalogDetail> query = session.createQuery(hql, CatalogDetail.class);
	        query.setParameter("warehouse_id",warehouseId);
	        query.setParameter("item_id",itemId);
	        catalogDetails = query.getResultList();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return catalogDetails;
	}

	
	public void createCatalogDetail(CatalogDetail catalogDetail) {
		//insert new stock detail
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.save(catalogDetail);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public void updateCatalogDetail(CatalogDetail catalogDetail) {
		//insert new item into catalog
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.update(catalogDetail);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public void deleteCatalogDetail(CatalogDetail catalogDetail) {
		//insert new item into catalog
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.delete(catalogDetail);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public CatalogDetail getCatalogDetail(CatalogWarehouseId catalogWarehouseId) {
		//insert new item into catalog
		CatalogDetail catalogDetail = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        catalogDetail = session.get(CatalogDetail.class, catalogWarehouseId);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return catalogDetail;
	}
	
	
	public List<CatalogDetail> getCatalogDetailByItemId(long itemId) {
		List<CatalogDetail> catalogDetails = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM CatalogDetail WHERE primaryKey.item.itemId = :item_id";
	        session.beginTransaction();
	     
	        TypedQuery<CatalogDetail> query = session.createQuery(hql, CatalogDetail.class);
	        query.setParameter("item_id",itemId);
	        catalogDetails = query.getResultList();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return catalogDetails;
	}
	
	public List<CatalogDetail> getCatalogDetailByWarehouseId(long warehouseId) {
		List<CatalogDetail> catalogDetails = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM CatalogDetail WHERE primaryKey.warehouse.warehouseId = :warehouse_id";
	        session.beginTransaction();
	     
	        TypedQuery<CatalogDetail> query = session.createQuery(hql, CatalogDetail.class);
	        query.setParameter("warehouse_id",warehouseId);
	        catalogDetails = query.getResultList();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return catalogDetails;
		
	}
}

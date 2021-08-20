package org.inventory.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.inventory.entities.Warehouse;
import org.inventory.util.HibernateUtil;

public class WarehouseDAOImpl implements WarehouseDAO {

	
	public Warehouse getWarehouse(long warehouseId) {
        // get the warehouse by id
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        Warehouse warehouse = session.get(Warehouse.class, warehouseId);
	        session.getTransaction().commit();
	        session.close();
	        return warehouse;
		} catch (HibernateException ex) {
			ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
		}
		return null;
	}

	
	public List<Warehouse> getAllWarehouse() {
        // get list of warehouses
    	Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	        List<Warehouse> warehouses = HibernateUtil.loadAllData(Warehouse.class, session);
	        session.getTransaction().commit();
	        session.close();
	        return warehouses;
		} catch (HibernateException ex) {
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
		}
	}

	
	public void createWarehouse(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.save(warehouse);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public void updateWarehouse(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.update(warehouse);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public void deleteWarehouse(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.delete(warehouse);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
	}

	
	public Warehouse getWarehouseByCode(String warehouseCode) {
		Warehouse warehouse = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Warehouse WHERE warehouseCode = :warehouse_code";
	        session.beginTransaction();
	     
	        TypedQuery<Warehouse> query = session.createQuery(hql, Warehouse.class);
	        query.setParameter("warehouse_code",warehouseCode);
	        warehouse = (Warehouse) query.getSingleResult();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	session.getTransaction().rollback();
	    	session.close();
	    	throw ex;
	    }
		return warehouse;
	}

}

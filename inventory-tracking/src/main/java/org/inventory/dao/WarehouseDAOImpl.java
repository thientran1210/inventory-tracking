package org.inventory.dao;

import java.util.List;

import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.inventory.entities.Catalog;
import org.inventory.entities.CatalogDetail;
import org.inventory.entities.CatalogWarehouseId;
import org.inventory.entities.Warehouse;
import org.inventory.util.HibernateUtil;

public class WarehouseDAOImpl implements WarehouseDAO {

	@Override
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

	@Override
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
			ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
		}
		return null;
	}

	@Override
	public void createWarehouse(Warehouse warehouse) {
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        session.save(warehouse);
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
	    }
	}

	@Override
	public void updateWarehouse(Warehouse warehouse) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteWarehouse(long id) {
		// TODO Auto-generated method stub

	}
	
	@Override
	public void getCatalogDetail(Warehouse warehouse, Catalog item) {
		CatalogWarehouseId compositeKey = new CatalogWarehouseId();
		compositeKey.setItem(item);
		compositeKey.setWarehouse(warehouse);
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
	        session.beginTransaction();
	     
	        System.out.println(session.get(CatalogDetail.class, compositeKey)
	        		.getPrimaryKey().getWarehouse());
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
	    }
	}

	@Override
	public Warehouse getWarehouseByCode(String warehouseCode) {
		Warehouse warehouse = null;
        Session session = HibernateUtil.getSessionFactory().openSession();
		try {
			String hql = "FROM Warehouse WHERE warehouseCode = :warehouse_code";
	        session.beginTransaction();
	     
	        Query query = session.createQuery(hql);
	        query.setParameter("warehouse_code",warehouseCode);
	        warehouse = (Warehouse) query.getSingleResult();
	     
	        session.getTransaction().commit();
	        session.close();
		} catch (HibernateException ex){
	    	ex.printStackTrace();
	    	session.getTransaction().rollback();
	    	session.close();
	    }
		return warehouse;
	}

}

package org.inventory.main;

import org.inventory.view.*;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class InventoryTracking {
	protected SessionFactory sessionFactory;
	 
    protected void setup() {
        //load Hibernate Session factory
    	final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
    	        .configure() // configures settings from hibernate.cfg.xml
    	        .build();
    	try {
    	    sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
    	} catch (Exception ex) {
    	    StandardServiceRegistryBuilder.destroy(registry);
    	}
    }
 
    protected void exit() {
        //close Hibernate Session factory
    	sessionFactory.close();
    }
 
    protected void create() {
        // code to save a book
    }
 
    protected void read() {
        // code to get a book
    }
 
    protected void update() {
        // code to modify a book
    }
 
    protected void delete() {
        // code to remove a book
    }
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//InventoryTracking tracker = new InventoryTracking();
		
		//tracker.setup();
		
		//tracker.exit();
		
		MainView mainView = new MainView();

	}
}

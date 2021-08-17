package org.inventory.app;

import org.inventory.menu.*;

import java.awt.EventQueue;

public class InventoryTracking {  
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		EventQueue.invokeLater(new Runnable() {

            @Override
            public void run() {
        		MainModel mainModel = new MainModel();
        		MainView mainView = new MainView();
        		MainController mainController = new MainController(mainModel, mainView);
        		mainView.setMainController(mainController);
            }
        });

	}
}

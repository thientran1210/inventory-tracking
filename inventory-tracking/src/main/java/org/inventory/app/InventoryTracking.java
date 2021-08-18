package org.inventory.app;

import java.awt.EventQueue;

import org.inventory.view.menu.*;

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

package org.inventory.app;

import java.awt.EventQueue;

import org.inventory.view.menu.*;

public class Main {  
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {

            public void run() {
        		MainView mainView = new MainView();
        		MainController mainController = new MainController(mainView);
        		mainView.setMainController(mainController);
            }
        });

	}
}

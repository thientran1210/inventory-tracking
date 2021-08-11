package org.inventory.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.*;

public class MainView extends JPanel{
    
	private ArrayList<JButton> btnList;
	private MainController mainController;
	
	public MainView(MainController mainController) {
		//instantiate button list to hold all of the button in the main view.
		btnList = new ArrayList<JButton>();
		this.mainController = mainController;
		initializeView();
	}
	
	public void initializeView() {
		JFrame mainFrame = new JFrame("Inventory Tracking");
		JPanel mainPanel = new JPanel();
		JButton addNewItemBtn = new JButton("Add New Item");//creating instance of JButton  
		JButton addNewCategoryBtn = new JButton("Add New Category");//creating instance of JButton  
		JButton addNewWarehouseBtn = new JButton("Add New Warehouse");//creating instance of JButton  
		JButton stockByWarehouseBtn = new JButton("Stock By Warehouse");//creating instance of JButton  
		JButton stockAdjustmentBtn = new JButton("Stock Adjustment");//creating instance of JButton  
		JButton stockMovementBtn = new JButton("Stock Movement Log");//creating instance of JButton  
		btnList.add(addNewItemBtn);
		addNewItemBtn.addActionListener(this.mainController);
		btnList.add(addNewCategoryBtn);
		btnList.add(addNewWarehouseBtn);
		btnList.add(stockByWarehouseBtn);
		btnList.add(stockAdjustmentBtn);
		btnList.add(stockMovementBtn);
		
		for (int i = 0; i < btnList.size(); i++) {
			btnList.get(i).setMaximumSize(new Dimension(200,20));
			mainPanel.add(btnList.get(i));
		}		         
		           
		//add box layout for main panel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setVisible(true);
		mainFrame.add(mainPanel, BorderLayout.CENTER);
		mainFrame.pack();
		mainFrame.setVisible(true);
	}
}

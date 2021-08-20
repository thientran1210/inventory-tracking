package org.inventory.view.menu;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import org.inventory.util.HibernateUtil;

public class MainView{
    
	private ArrayList<JButton> btnList;
	private MainController mainController;
	private JPanel displayPanel;
	private JPanel mainPanel;
	private JFrame mainFrame;
	
	public MainView() {
		//instantiate button list to hold all of the button in the main view.
		btnList = new ArrayList<JButton>();
		initializeView();
	}
	
	public void initializeView() {
		mainFrame = new JFrame("Inventory Tracking");
		mainPanel = new JPanel();
		displayPanel = new JPanel();
		JButton addNewItemBtn = new JButton("Item Master");//creating instance of JButton 
		JButton addNewWarehouseBtn = new JButton("Warehouse Master");//creating instance of JButton  
		JButton stockByWarehouseBtn = new JButton("Stock By Warehouse");//creating instance of JButton  
		JButton stockAdjustmentBtn = new JButton("Stock Adjustment");//creating instance of JButton    
		btnList.add(addNewItemBtn);
		btnList.add(addNewWarehouseBtn);
		btnList.add(stockByWarehouseBtn);
		btnList.add(stockAdjustmentBtn);
		
		//add box layout for main panel
		mainPanel.setLayout(new BoxLayout(mainPanel, BoxLayout.Y_AXIS));
		mainPanel.setVisible(true);
		displayPanel.setPreferredSize(new Dimension(1000,500));
		displayPanel.setVisible(true);
		mainFrame.add(mainPanel, BorderLayout.WEST);
		mainFrame.add(displayPanel, BorderLayout.EAST);
		mainFrame.addWindowListener(new java.awt.event.WindowAdapter() {
			@Override
			public void windowClosing(java.awt.event.WindowEvent e) {
				HibernateUtil.closeSessionFactory();
				System.exit(0);
			}
		});
		mainFrame.pack();
		mainFrame.setVisible(true);
	}

	public MainController getMainController() {
		return mainController;
	}

	public void setMainController(MainController mainController) {
		this.mainController = mainController;
		
		//add action listener to each button
		for (int i = 0; i < btnList.size(); i++) {
			btnList.get(i).setMaximumSize(new Dimension(200,20));
			btnList.get(i).addActionListener(mainController);
			mainPanel.add(btnList.get(i));
		}		   
	}

	public JPanel getDisplayPanel() {
		return displayPanel;
	}

	public void setDisplayPanel(JPanel displayPanel) {
		mainFrame.remove(this.displayPanel);
		this.displayPanel = displayPanel;
		mainFrame.add(this.displayPanel);
		mainFrame.revalidate();
		mainFrame.repaint();
	}
}

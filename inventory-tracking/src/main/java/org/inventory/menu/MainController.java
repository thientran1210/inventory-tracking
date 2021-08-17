package org.inventory.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import org.inventory.newwarehouse.*;

public class MainController extends AbstractAction{
	
	private MainModel mainModel;
	private MainView mainView;
	
	public MainController(MainModel model, MainView view) {
		this.mainModel = model;
		this.mainView = view;
	}

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getText()) {
			case "Add New Warehouse":
				System.out.println("new warehouse clicked");
				NewWarehouseView newWarehouseView = new NewWarehouseView();
				NewWarehouseModel newWarehouseModel = new NewWarehouseModel();
				NewWarehouseController newWarehouseController = new NewWarehouseController(newWarehouseModel, newWarehouseView);
				newWarehouseView.setNewWarehouseController(newWarehouseController);
				mainView.setDisplayPanel(newWarehouseView);
				break;
			default:
				break;
		}
	}

	public MainModel getMainModel() {
		return mainModel;
	}

	public void setMainModel(MainModel mainModel) {
		this.mainModel = mainModel;
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
}

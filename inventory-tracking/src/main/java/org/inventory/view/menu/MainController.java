package org.inventory.view.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import org.inventory.view.item.ItemController;
import org.inventory.view.item.ItemModel;
import org.inventory.view.item.ItemView;
import org.inventory.view.warehouse.WarehouseController;
import org.inventory.view.warehouse.WarehouseModel;
import org.inventory.view.warehouse.WarehouseView;

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
			case "Warehouse Master":
				WarehouseView warehouseView = new WarehouseView();
				WarehouseModel warehouseModel = new WarehouseModel();
				WarehouseController warehouseController = new WarehouseController(warehouseModel, warehouseView);
				warehouseView.setNewWarehouseController(warehouseController);
				warehouseController.getAllWarehouses();
				mainView.setDisplayPanel(warehouseView);
				break;
			case "Item Master":
				ItemView itemView = new ItemView();
				ItemModel itemModel = new ItemModel();
				ItemController itemController = new ItemController(itemModel, itemView);
				itemView.setItemController(itemController);
				//itemController.getAllWarehouses();
				mainView.setDisplayPanel(itemView);
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

package org.inventory.view.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import org.inventory.view.item.ItemController;
import org.inventory.view.item.ItemModel;
import org.inventory.view.item.ItemView;
import org.inventory.view.stock_adjustment.StockAdjustmentController;
import org.inventory.view.stock_adjustment.StockAdjustmentModel;
import org.inventory.view.stock_adjustment.StockAdjustmentView;
import org.inventory.view.stock_by_warehouse.StockByWarehouseController;
import org.inventory.view.stock_by_warehouse.StockByWarehouseModel;
import org.inventory.view.stock_by_warehouse.StockByWarehouseView;
import org.inventory.view.warehouse.WarehouseController;
import org.inventory.view.warehouse.WarehouseModel;
import org.inventory.view.warehouse.WarehouseView;

public class MainController extends AbstractAction{
	
	private MainView mainView;
	
	public MainController(MainView view) {
		this.mainView = view;
	}

	//list of action when user click a button
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getText()) {
			case "Warehouse Master":
				WarehouseView warehouseView = new WarehouseView();
				WarehouseModel warehouseModel = new WarehouseModel();
				WarehouseController warehouseController = new WarehouseController(warehouseModel, warehouseView);
				warehouseView.setNewWarehouseController(warehouseController);
				warehouseController.populateWarehouseTable();
				this.getMainView().setDisplayPanel(warehouseView);
				break;
			case "Item Master":
				ItemView itemView = new ItemView();
				ItemModel itemModel = new ItemModel();
				ItemController itemController = new ItemController(itemModel, itemView);
				itemView.setItemController(itemController);
				itemController.populateItemTable();
				this.getMainView().setDisplayPanel(itemView);
				break;
			case "Stock Adjustment":
				StockAdjustmentView stockAdjustmentView = new StockAdjustmentView();
				StockAdjustmentModel stockAdjustmentModel = new StockAdjustmentModel();
				StockAdjustmentController stockAdjustmentController = new StockAdjustmentController(stockAdjustmentModel, stockAdjustmentView);
				stockAdjustmentView.setStockAdjustmentController(stockAdjustmentController);
				stockAdjustmentController.populateCatalogTable();
				stockAdjustmentController.populateWarehouseTable();
				this.getMainView().setDisplayPanel(stockAdjustmentView);
				break;
			case "Stock By Warehouse":
				StockByWarehouseView stockByWarehouseView = new StockByWarehouseView();
				StockByWarehouseModel stockByWarehouseModel = new StockByWarehouseModel();
				StockByWarehouseController stockByWarehouseController = new StockByWarehouseController(stockByWarehouseModel, stockByWarehouseView);
				stockByWarehouseView.setStockAdjustmentController(stockByWarehouseController);
				stockByWarehouseController.populateCatalogDetailTable();
				this.getMainView().setDisplayPanel(stockByWarehouseView);
				break;
			default:
				break;
		}
	}

	public MainView getMainView() {
		return mainView;
	}

	public void setMainView(MainView mainView) {
		this.mainView = mainView;
	}
}

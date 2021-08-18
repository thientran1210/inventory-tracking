package org.inventory.view.warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

import org.hibernate.HibernateException;

public class WarehouseController implements ActionListener{

	private WarehouseModel warehouseModel;
	private WarehouseView warehouseView;
	public WarehouseController(WarehouseModel model, WarehouseView view) {
		this.warehouseModel = model;
		this.warehouseView = view;
	}
	
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Save":
			saveButtonClick();
			break;
		case "Delete":
			deleteButtonClick();
			break;
		default:
			break;
		}
	}
	
	public void getAllWarehouses() {
		
	}
	
	public void saveButtonClick() {
		//check if the warehouse exist, if not then create new
		//otherwise update existing one
		try {
			warehouseModel.createNewWarehouse(
				this.warehouseView.getWarehouseCode().getText(),
				this.warehouseView.getAddress1().getText(),
				this.warehouseView.getAddress2().getText(),
				this.warehouseView.getState().getText(),
				Integer.parseInt(this.warehouseView.getPostcode().getText()));
			//display dialog after saving successfully
			this.warehouseView.showDialog("Save successfully");
		} catch (HibernateException ex) {
			ex.printStackTrace();
		} catch (NumberFormatException ex) {
			this.warehouseView.showDialog("Postcode needs to be a number.");
		} catch (Exception ex) {
			this.warehouseView.showDialog("There is an error while saving new warehouse.");
		}
	}
	
	public void deleteButtonClick() {
		//check if warehouse still have stock in it
		//if yes then don't delete
		//otherwise delete it
		if (this.warehouseModel.stillHaveStock(this.warehouseView.getWarehouseId())) {
			this.warehouseView.showDialog("Cannot delete. Warehouse " + this.warehouseView.getWarehouseCode() + " still has stock in it.");
		} else {
			this.warehouseModel.deleteWarehouse(this.warehouseView.getWarehouseId());
		}
	}
}

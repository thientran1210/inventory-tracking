package org.inventory.newwarehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class NewWarehouseController implements ActionListener{

	private NewWarehouseModel newWarehouseModel;
	private NewWarehouseView newWarehouseView;
	public NewWarehouseController(NewWarehouseModel model, NewWarehouseView view) {
		this.newWarehouseModel = model;
		this.newWarehouseView = view;
	}
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		newWarehouseModel.createNewWarehouse(
			this.newWarehouseView.getWarehouseCode().getText(),
			this.newWarehouseView.getAddress1().getText(),
			this.newWarehouseView.getAddress2().getText(),
			this.newWarehouseView.getState().getText(),
			Integer.parseInt(this.newWarehouseView.getPostcode().getText()));
	}

}

package org.inventory.menu;

import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.JButton;

import org.inventory.newwarehouse.NewWarehouseController;
import org.inventory.newwarehouse.NewWarehouseView;

public class MainController extends AbstractAction{

	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		switch (((JButton) e.getSource()).getText()) {
			case "Add New Warehouse":
				NewWarehouseController newWarehouseController = new NewWarehouseController();
				NewWarehouseView newWarehouseView = new NewWarehouseView(newWarehouseController);
				break;
			default:
				break;
		}
	}

}

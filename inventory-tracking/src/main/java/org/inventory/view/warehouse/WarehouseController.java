package org.inventory.view.warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.HibernateException;
import org.inventory.util.ModelException;

public class WarehouseController implements ActionListener, ListSelectionListener{

	private WarehouseModel warehouseModel;
	private WarehouseView warehouseView;
	public WarehouseController(WarehouseModel model, WarehouseView view) {
		this.warehouseModel = model;
		this.warehouseView = view;
	}
	
	//list of action to perform
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Save":
			saveButtonClick();
			break;
		case "Delete":
			deleteButtonClick();
			break;
		case "Edit":
			editButtonClick();
			break;
		case "Clear":
			clearButtonClick();
			break;
		default:
			break;
		}
	}
	
	//method to populate data to the table
	public void populateWarehouseTable() {
		this.warehouseView.getTableModel().setRowCount(0);
		this.warehouseView.getTableModel().setColumnIdentifiers(
				new String[]{"ID", "Warehouse Code","Address 1","Address 2","State","Postcode"});
		for (int i = 0; i < this.warehouseModel.getWarehouses().size(); i++) {
			long warehouseId = this.warehouseModel.getWarehouses().get(i).getWarehouseId();
			String warehouseCode = this.warehouseModel.getWarehouses().get(i).getWarehouseCode();
			String address1 = this.warehouseModel.getWarehouses().get(i).getAddress_1();
			String address2 = this.warehouseModel.getWarehouses().get(i).getAddress_2();
			String state = this.warehouseModel.getWarehouses().get(i).getState();
			long postcode = this.warehouseModel.getWarehouses().get(i).getPostcode();
			this.warehouseView.getTableModel().addRow(new Object[]{warehouseId, warehouseCode, address1, address2, state, postcode});
		}
		this.warehouseView.removeColumn(0);
		this.warehouseView.repaint();
	}
	
	//action when user click save button
	public void saveButtonClick() {
		try {
			warehouseModel.saveWarehouse(
				this.warehouseView.getWarehouseId(),
				this.warehouseView.getWarehouseCode(),
				this.warehouseView.getAddress1(),
				this.warehouseView.getAddress2(),
				this.warehouseView.getState(),
				Integer.parseInt(this.warehouseView.getPostcode()));
			//display dialog after saving successfully
			this.warehouseView.showDialog("Save successfully");
			refreshScreen();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			this.warehouseView.showDialog("There is an error while saving warehouse.");
		} catch (NumberFormatException ex) {
			this.warehouseView.showDialog("Postcode needs to be a number.");
		}
	}
	
	//action when user click delete button
	public void deleteButtonClick() {
		try {
			this.warehouseModel.deleteWarehouse(this.warehouseView.getWarehouseId());
			//display dialog after saving successfully
			this.warehouseView.showDialog("Delete successfully");
			refreshScreen();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			this.warehouseView.showDialog("There is an error while saving warehouse.");
		} catch (ModelException e) {
			this.warehouseView.showDialog(e.getMessage());
		}
	}
	
	public void refreshScreen() {
		this.warehouseView.clearField();
		this.warehouseView.getWarehouseTable().clearSelection();
		populateWarehouseTable();
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		int i = this.warehouseView.getWarehouseTable().getSelectedRow();
		if (i != -1) {
			this.warehouseView.setWarehouseId((long)this.warehouseView.getTableModel().getValueAt(i, 0));
			this.warehouseView.setWarehouseCode((String)this.warehouseView.getTableModel().getValueAt(i, 1));
			this.warehouseView.setAddress1((String)this.warehouseView.getTableModel().getValueAt(i, 2));
			this.warehouseView.setAddress2((String)this.warehouseView.getTableModel().getValueAt(i, 3));
			this.warehouseView.setState((String)this.warehouseView.getTableModel().getValueAt(i, 4));
			this.warehouseView.setPostcode(this.warehouseView.getTableModel().getValueAt(i, 5).toString());
			this.warehouseView.setFieldEditable(false);
		}
		this.warehouseView.repaint();
	}
	
	public void editButtonClick() {
		this.warehouseView.setFieldEditable(true);
	}
	
	public void clearButtonClick() {
		this.warehouseView.setFieldEditable(true);
		this.warehouseView.getWarehouseTable().clearSelection();
		this.warehouseView.clearField();
	}
}

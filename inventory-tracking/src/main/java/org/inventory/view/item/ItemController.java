package org.inventory.view.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.hibernate.HibernateException;
import org.inventory.util.ModelException;

public class ItemController implements ActionListener, ListSelectionListener{

	private ItemModel itemModel;
	private ItemView itemView;
	public ItemController(ItemModel itemModel, ItemView itemView) {
		this.itemModel = itemModel;
		this.itemView = itemView;
	}

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
	
	public void getAllCatalogs() {
		this.itemModel.getAllCatalogs();
	}
	
	public void populateItemTable() {
		this.itemView.getTableModel().setRowCount(0);
		this.itemView.getTableModel().setColumnIdentifiers(
				new String[]{"ID", "Item Code","Description","Price"});
		for (int i = 0; i < this.itemModel.getCatalogs().size(); i++) {
			long itemId = this.itemModel.getCatalogs().get(i).getItemId();
			String itemCode = this.itemModel.getCatalogs().get(i).getItemCode();
			String description = this.itemModel.getCatalogs().get(i).getDescription();
			float price = this.itemModel.getCatalogs().get(i).getPrice();
			this.itemView.getTableModel().addRow(new Object[]{itemId, itemCode, description, price});
		}
		this.itemView.removeColumn(0);
		this.itemView.repaint();
	}

	private void clearButtonClick() {
		this.itemView.setFieldEditable(true);
		this.itemView.getItemTable().clearSelection();
		this.itemView.clearField();
	}

	private void editButtonClick() {
		this.itemView.setFieldEditable(true);
	}

	private void deleteButtonClick() {
		try {
			this.itemModel.deleteCatalog(this.itemView.getItemId());
			//display dialog after deleting successfully
			this.itemView.showDialog("Delete successfully");
			this.refreshScreen();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			this.itemView.showDialog("There is an error while deleting item.");
		} catch (ModelException ex) {
			this.itemView.showDialog(ex.getMessage());
		}
	}

	public void valueChanged(ListSelectionEvent arg0) {
		int i = this.itemView.getItemTable().getSelectedRow();
		if (i != -1) {
			this.itemView.setItemId(Long.parseLong((String) this.itemView.getTableModel().getValueAt(i, 0)));
			this.itemView.setItemCode((String)this.itemView.getTableModel().getValueAt(i, 1));
			this.itemView.setDescription((String)this.itemView.getTableModel().getValueAt(i, 2));
			this.itemView.setPrice(this.itemView.getTableModel().getValueAt(i, 3).toString());
			this.itemView.setFieldEditable(false);
		}
		this.itemView.repaint();
	}
	
	public void saveButtonClick() {
		//check if the item exist, if not then create new
		//otherwise update existing one
		try {
			itemModel.saveCatalog(
				this.itemView.getItemId(),
				this.itemView.getItemCode(),
				this.itemView.getDescription(),
				Float.parseFloat(this.itemView.getPrice()));
			//display dialog after saving successfully
			this.itemView.showDialog("Save successfully");
			this.refreshScreen();
		} catch (HibernateException ex) {
			ex.printStackTrace();
			this.itemView.showDialog("There is an error while saving item.");
		} catch (NumberFormatException ex) {
			this.itemView.showDialog("Price needs to be a number.");
		} catch (ModelException ex) {
			this.itemView.showDialog(ex.getMessage());
		}
	}
	
	public void refreshScreen() {
		this.itemView.clearField();
		this.itemView.getItemTable().clearSelection();
		populateItemTable();
	}

}

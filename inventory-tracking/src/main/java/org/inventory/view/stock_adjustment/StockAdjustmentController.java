package org.inventory.view.stock_adjustment;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import org.inventory.util.ModelException;

public class StockAdjustmentController implements ActionListener, ListSelectionListener{

		private StockAdjustmentModel stockAdjustmentModel;
		private StockAdjustmentView stockAdjustmentView;

		public StockAdjustmentController(StockAdjustmentModel model, StockAdjustmentView view) {
			this.stockAdjustmentModel = model;
			this.stockAdjustmentView = view;
		}

		public void valueChanged(ListSelectionEvent e) {
			long warehouseId = 0, itemId = 0;
			this.stockAdjustmentView.clearField();
			int i = this.stockAdjustmentView.getWarehouseTable().getSelectedRow();
			if (i != -1) {
				warehouseId = Long.parseLong((String) this.stockAdjustmentView.getWarehouseTableModel().getValueAt(i, 0));
				this.stockAdjustmentView.setWarehouseId(warehouseId);
				this.stockAdjustmentView.setWarehouseCode((String)this.stockAdjustmentView.getWarehouseTableModel().getValueAt(i, 1));
			}
			int j = this.stockAdjustmentView.getCatalogTable().getSelectedRow();
			if (j != -1) {
				itemId = Long.parseLong((String) this.stockAdjustmentView.getCatalogTableModel().getValueAt(j, 0));
				this.stockAdjustmentView.setItemId(itemId);
				this.stockAdjustmentView.setItemCode((String)this.stockAdjustmentView.getCatalogTableModel().getValueAt(j, 1));
			}
			if (i != -1 && j != -1) {
				try {
					if (this.stockAdjustmentModel.getCatalogDetail(warehouseId, itemId) != null) {
						this.stockAdjustmentView.setQty(Long.toString(this.stockAdjustmentModel.getCatalogDetail(warehouseId, itemId).getQty()));
					}
				} catch (ModelException ex) {
					this.stockAdjustmentView.showDialog(ex.getMessage());
				}
			}
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
		
		public void populateWarehouseTable() {
			this.stockAdjustmentView.getWarehouseTableModel().setRowCount(0);
			this.stockAdjustmentView.getWarehouseTableModel().setColumnIdentifiers(
					new String[]{"ID", "Warehouse Code"});
			for (int i = 0; i < this.stockAdjustmentModel.getWarehouses().size(); i++) {
				long warehouseId = this.stockAdjustmentModel.getWarehouses().get(i).getWarehouseId();
				String warehouseCode = this.stockAdjustmentModel.getWarehouses().get(i).getWarehouseCode();
				this.stockAdjustmentView.getWarehouseTableModel().addRow(new Object[]{warehouseId, warehouseCode});
			}
			this.stockAdjustmentView.removeColumn(this.stockAdjustmentView.getWarehouseTable().getColumnModel(),0);
			this.stockAdjustmentView.repaint();
		}
		
		public void populateCatalogTable() {
			this.stockAdjustmentView.getCatalogTableModel().setRowCount(0);
			this.stockAdjustmentView.getCatalogTableModel().setColumnIdentifiers(
					new String[]{"ID", "Item Code"});
			for (int i = 0; i < this.stockAdjustmentModel.getCatalogs().size(); i++) {
				long itemId = this.stockAdjustmentModel.getCatalogs().get(i).getItemId();
				String itemCode = this.stockAdjustmentModel.getCatalogs().get(i).getItemCode();
				this.stockAdjustmentView.getCatalogTableModel().addRow(new Object[]{itemId, itemCode});
			}
			this.stockAdjustmentView.removeColumn(this.stockAdjustmentView.getCatalogTable().getColumnModel(),0);
			this.stockAdjustmentView.repaint();
		}
		
		public void saveButtonClick() {
			try {
				this.stockAdjustmentModel.saveCatalogDetail(
					this.stockAdjustmentView.getWarehouseId(),
					this.stockAdjustmentView.getItemId(),
					Integer.parseInt(this.stockAdjustmentView.getQty()));
				this.stockAdjustmentView.showDialog("Save Successfully");
				this.stockAdjustmentView.clearScreen();
			} catch (NumberFormatException ex) {
				this.stockAdjustmentView.showDialog("Quantity must be a number");
			} catch (ModelException e) {
				this.stockAdjustmentView.showDialog(e.getMessage());
			}
		}
		
		public void deleteButtonClick() {
			try {
				this.stockAdjustmentModel.deleteCatalogDetail(
						this.stockAdjustmentView.getWarehouseId(),
						this.stockAdjustmentView.getItemId());
				this.stockAdjustmentView.showDialog("Delete Successfully");
				this.stockAdjustmentView.clearScreen();
			} catch (ModelException e) {
				this.stockAdjustmentView.showDialog(e.getMessage());
			}
		}
}

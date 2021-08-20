package org.inventory.view.stock_by_warehouse;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class StockByWarehouseController implements ActionListener{

	private StockByWarehouseModel stockByWarehouseModel;
	private StockByWarehouseView stockByWarehouseView;
	
	public StockByWarehouseController(StockByWarehouseModel model, StockByWarehouseView view) {
		this.stockByWarehouseModel = model;
		this.stockByWarehouseView = view;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		switch (((JButton) e.getSource()).getText()) {
		case "Search":
			searchButtonClick();
			break;
		default:
			break;
		}
	}

	public void searchButtonClick() {
		try {
			String warehouseCode = this.stockByWarehouseView.getWarehouseCode();
			String itemCode = this.stockByWarehouseView.getItemCode();
			if (dataValidation(warehouseCode, itemCode)) {
				this.stockByWarehouseModel.search(warehouseCode, itemCode);
			} else {
				this.stockByWarehouseModel.getAllCatalogDetails();
			}
			populateCatalogDetailTable();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public boolean dataValidation(){
		String warehouseCode = this.stockByWarehouseView.getWarehouseCode();
		String itemCode = this.stockByWarehouseView.getItemCode();
		return dataValidation(warehouseCode, itemCode);	
	}
	
	public boolean dataValidation(String warehouseCode, String itemCode){

		if (warehouseCode.isEmpty() || itemCode.isEmpty()) {
			return false;
		}
		return true;
	}
	
	public void populateCatalogDetailTable() {
		this.stockByWarehouseView.getCatalogDetailTableModel().setRowCount(0);
		this.stockByWarehouseView.getCatalogDetailTableModel().setColumnIdentifiers(
				new String[]{"Warehouse ID", "Warehouse Code", "Item ID", "Item Code", "Quantity"});
		for (int i = 0; i < this.stockByWarehouseModel.getCatalogDetails().size(); i++) {
			long warehouseId = this.stockByWarehouseModel.getCatalogDetails().get(i).getWarehouse().getWarehouseId();
			String warehouseCode = this.stockByWarehouseModel.getCatalogDetails().get(i).getWarehouse().getWarehouseCode();
			long itemId = this.stockByWarehouseModel.getCatalogDetails().get(i).getItem().getItemId();
			String itemCode = this.stockByWarehouseModel.getCatalogDetails().get(i).getItem().getItemCode();
			long qty = this.stockByWarehouseModel.getCatalogDetails().get(i).getQty();
			this.stockByWarehouseView.getCatalogDetailTableModel().addRow(new Object[]{warehouseId, warehouseCode, itemId, itemCode, qty});
		}
		this.stockByWarehouseView.removeColumn(this.stockByWarehouseView.getCatalogDetailTable().getColumnModel(),0);
		this.stockByWarehouseView.removeColumn(this.stockByWarehouseView.getCatalogDetailTable().getColumnModel(),1);
		this.stockByWarehouseView.repaint();
	}
}

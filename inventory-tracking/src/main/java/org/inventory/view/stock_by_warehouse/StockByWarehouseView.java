package org.inventory.view.stock_by_warehouse;

import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumnModel;

import org.inventory.util.MyTextField;
import org.inventory.view.stock_by_warehouse.StockByWarehouseController;

public class StockByWarehouseView extends JPanel{

	private JTextField warehouseCode;
	private JTextField itemCode;
	private JButton searchBtn;
	private JTable catalogDetailTable;
	private DefaultTableModel catalogDetailTableModel;
	
	public StockByWarehouseView() {
		this.initializeView();
	}
	
	public void initializeView() {
		//frame header
		JLabel header = new JLabel("Stock By Warehouse");
		header.setFont(new Font("", Font.PLAIN, 20));
		

		
		//warehouse code field and label
		JLabel warehouseCodeLabel = new JLabel("Warehouse Code:");
		this.warehouseCode = new MyTextField(16);

		//item code field and label
		JLabel itemCodeLabel = new JLabel("Item Code:");
		this.itemCode = new MyTextField(16);
		
		//save button
		this.searchBtn = new JButton("Search");
		
		//table to display all warehouses
		this.catalogDetailTable = new JTable();
		this.catalogDetailTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		catalogDetailTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.catalogDetailTable.setModel(catalogDetailTableModel);

		JScrollPane catalogDetailScrollPane = new JScrollPane(this.catalogDetailTable);
		catalogDetailScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		catalogDetailScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		//use grouplayout to manage the layout of this view
		GroupLayout layout = new GroupLayout(this);
		this.setLayout(layout);
		layout.setAutoCreateContainerGaps(true);;
		layout.setAutoCreateGaps(true);
		layout.setHorizontalGroup(
				layout.createParallelGroup(GroupLayout.Alignment.LEADING)
					.addComponent(header)
					.addGroup(layout.createSequentialGroup()
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.TRAILING)	
							.addComponent(warehouseCodeLabel)
							.addComponent(itemCodeLabel))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.warehouseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.itemCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(layout.createSequentialGroup()
						.addComponent(searchBtn))
					.addComponent(catalogDetailScrollPane)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(header)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(warehouseCodeLabel)
							.addComponent(this.warehouseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(itemCodeLabel)
							.addComponent(this.itemCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(searchBtn))
					.addComponent(catalogDetailScrollPane)
		);
		this.setVisible(true);
	}

	public JTable getCatalogDetailTable() {
		return catalogDetailTable;
	}

	public DefaultTableModel getCatalogDetailTableModel() {
		return catalogDetailTableModel;
	}
	
	public String getWarehouseCode() {
		return warehouseCode.getText();
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode.setText(warehouseCode);
	}

	public String getItemCode() {
		return itemCode.getText();
	}

	public void setItemCode(String itemCode) {
		this.itemCode.setText(itemCode);
	}

	public void removeColumn(TableColumnModel tcm, int i) {
		tcm.removeColumn(tcm.getColumn(i));
	}
	
	public void setStockAdjustmentController(StockByWarehouseController stockByWarehouseController) {
		this.searchBtn.addActionListener(stockByWarehouseController);
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void clearField() {
		this.setWarehouseCode("");
		this.setItemCode("");
	}

}

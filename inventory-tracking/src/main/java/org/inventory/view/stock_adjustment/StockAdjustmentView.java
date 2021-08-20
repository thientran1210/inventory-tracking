package org.inventory.view.stock_adjustment;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
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
import org.inventory.view.warehouse.WarehouseController;

public class StockAdjustmentView extends JPanel{
	private JTextField warehouseCode;
	private JTextField itemCode;
	private JTextField qty;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JTable warehouseTable;
	private JTable catalogTable;
	private DefaultTableModel warehouseTableModel;
	private DefaultTableModel catalogTableModel;
	private StockAdjustmentController stockAdjustmentController;
	private long warehouseId;
	private long itemId;
	
	public StockAdjustmentView() {
		this.initializeView();
	}
	
	public void initializeView() {
		//frame header
		JLabel header = new JLabel("Stock Adjustment");
		header.setFont(new Font("", Font.PLAIN, 20));
		
		//warehouse code field and label
		JLabel warehouseCodeLabel = new JLabel("Warehouse Code:");
		this.warehouseCode = new MyTextField(16);
		this.warehouseCode.setEditable(false);

		//item code field and label
		JLabel itemCodeLabel = new JLabel("Item Code:");
		this.itemCode = new MyTextField(16);
		this.itemCode.setEditable(false);
		
		//qty field and label
		JLabel qtyLabel = new JLabel("Quantity:");
		this.qty = new MyTextField(16);
		
		//save button
		this.saveBtn = new JButton("Save");
		
		//delete button
		this.deleteBtn = new JButton("Delete");
		
		//table to display all warehouses
		this.warehouseTable = new JTable();
		this.warehouseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		warehouseTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.warehouseTable.setModel(warehouseTableModel);
		
		this.catalogTable = new JTable();
		this.catalogTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		catalogTableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.catalogTable.setModel(catalogTableModel);

		
		JScrollPane warehouseScrollPane = new JScrollPane(this.warehouseTable);
		warehouseScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		warehouseScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
		
		JScrollPane itemScrollPane = new JScrollPane(this.catalogTable);
		itemScrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
		itemScrollPane.setVerticalScrollBarPolicy(
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        
		JPanel tablePanel = new JPanel();
		tablePanel.setLayout(new GridLayout());
		tablePanel.add(warehouseScrollPane);
		tablePanel.add(itemScrollPane);
		
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
							.addComponent(itemCodeLabel)
							.addComponent(qtyLabel))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.warehouseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.itemCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.qty, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(layout.createSequentialGroup()
						.addComponent(saveBtn)
						.addComponent(deleteBtn))
					.addComponent(tablePanel)
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
							.addComponent(qtyLabel)
							.addComponent(this.qty, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(deleteBtn))
					.addComponent(tablePanel)
		);
		this.setVisible(true);
	}

	public JTable getWarehouseTable() {
		return warehouseTable;
	}

	public JTable getCatalogTable() {
		return catalogTable;
	}

	public DefaultTableModel getWarehouseTableModel() {
		return warehouseTableModel;
	}

	public DefaultTableModel getCatalogTableModel() {
		return catalogTableModel;
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

	public String getQty() {
		return qty.getText();
	}

	public void setQty(String qty) {
		this.qty.setText(qty);
	}

	public long getWarehouseId() {
		return warehouseId;
	}

	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}

	public long getItemId() {
		return itemId;
	}

	public void setItemId(long itemId) {
		this.itemId = itemId;
	}

	public void removeColumn(TableColumnModel tcm, int i) {
		tcm.removeColumn(tcm.getColumn(0));
	}
	
	public void setStockAdjustmentController(StockAdjustmentController stockAdjustmentController) {
		this.stockAdjustmentController = stockAdjustmentController;
		this.saveBtn.addActionListener(stockAdjustmentController);
		this.deleteBtn.addActionListener(stockAdjustmentController);
		this.warehouseTable.getSelectionModel().addListSelectionListener(stockAdjustmentController);
		this.catalogTable.getSelectionModel().addListSelectionListener(stockAdjustmentController);
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public void clearField() {
		this.warehouseId = 0;
		this.setWarehouseCode("");
		this.setItemCode("");
		this.itemId = 0;
		this.setQty("");
	}
	
	public void clearTable() {
		this.getWarehouseTable().clearSelection();
		this.getCatalogTable().clearSelection();
	}
	
	public void clearScreen() {
		clearField();
		clearTable();
	}
}

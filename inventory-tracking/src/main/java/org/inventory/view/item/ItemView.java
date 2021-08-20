package org.inventory.view.item;

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
import org.inventory.view.warehouse.WarehouseController;

public class ItemView extends JPanel{
	
	private JTextField itemCode;
	private JTextField description;
	private JTextField price;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JButton editBtn;
	private JButton clearBtn;
	private JTable itemTable;
	private DefaultTableModel tableModel;
	private ItemController itemController;
	private long itemId;
	
	public ItemView() {
		this.initializeView();
	}
	
	public void initializeView() {
		//frame header
		JLabel header = new JLabel("Item Master");
		header.setFont(new Font("", Font.PLAIN, 20));
		
		//item code field and label
		JLabel warehouseCodeLabel = new JLabel("Item Code:");
		this.itemCode = new MyTextField(16);

		//description field and label
		JLabel address1Label = new JLabel("Description:");
		this.description = new MyTextField(16);
		
		//price field and label
		JLabel address2Label = new JLabel("Price:");
		this.price = new MyTextField(16);
		
		//save button
		this.saveBtn = new JButton("Save");
		
		//delete button
		this.deleteBtn = new JButton("Delete");
		
		//edit button
		this.editBtn = new JButton("Edit");
		
		//clear button
		this.clearBtn = new JButton("Clear");
		
		//table to display all warehouses
		this.itemTable = new JTable();
		this.itemTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.itemTable.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(this.itemTable);
        scrollPane.setHorizontalScrollBarPolicy(
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        scrollPane.setVerticalScrollBarPolicy(
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
							.addComponent(address1Label)
							.addComponent(address2Label))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.itemCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.description, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.price, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
					.addGroup(layout.createSequentialGroup()
						.addComponent(saveBtn)
						.addComponent(editBtn)
						.addComponent(deleteBtn)
						.addComponent(clearBtn))
					.addComponent(scrollPane)
		);
		layout.setVerticalGroup(
				layout.createSequentialGroup()
					.addComponent(header)
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(warehouseCodeLabel)
							.addComponent(this.itemCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(address1Label)
							.addComponent(this.description, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(address2Label)
							.addComponent(this.price, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(editBtn)
						.addComponent(deleteBtn)
						.addComponent(clearBtn))
					.addComponent(scrollPane)
		);
		this.setVisible(true);
	}

	public String getItemCode() {
		return itemCode.getText();
	}

	public void setItemCode(String itemCode) {
		this.itemCode.setText(itemCode);
	}

	public String getDescription() {
		return description.getText();
	}

	public void setDescription(String description) {
		this.description.setText(description);
	}

	public String getPrice() {
		return price.getText();
	}

	public void setPrice(String price) {
		this.price.setText(price);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public JTable getItemTable() {
		return itemTable;
	}

	public void setItemTable(JTable itemTable) {
		this.itemTable = itemTable;
	}

	public ItemController getItemController() {
		return itemController;
	}

	public void setItemController(ItemController itemController) {
		this.itemController = itemController;
		this.saveBtn.addActionListener(itemController);
		this.deleteBtn.addActionListener(itemController);
		this.editBtn.addActionListener(itemController);
		this.clearBtn.addActionListener(itemController);
		this.itemTable.getSelectionModel().addListSelectionListener(itemController);
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public long getItemId() {
		return itemId;
	}
	
	public void setItemId(long itemId) {
		this.itemId = itemId;
	}
	
	public void removeColumn(int i) {
		TableColumnModel tcm = this.itemTable.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
	}
	
	public void setFieldEditable(boolean b) {
		this.itemCode.setEditable(b);
		this.description.setEditable(b);
		this.price.setEditable(b);
	}
	
	public void clearField() {
		this.itemId = 0;
		this.itemCode.setText("");
		this.description.setText("");
		this.price.setText("");
	}
}
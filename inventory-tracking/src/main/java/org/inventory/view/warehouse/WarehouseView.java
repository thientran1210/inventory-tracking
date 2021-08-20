package org.inventory.view.warehouse;

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

public class WarehouseView extends JPanel{
	
	private JTextField warehouseCode;
	private JTextField address1;
	private JTextField address2;
	private JTextField state;
	private JTextField postcode;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JButton editBtn;
	private JButton clearBtn;
	private JTable warehouseTable;
	private DefaultTableModel tableModel;
	private WarehouseController warehouseController;
	private long warehouseId;
	
	public WarehouseView() {
		this.initializeView();
	}
	
	public void initializeView() {
		//frame header
		JLabel header = new JLabel("Warehouse Master");
		header.setFont(new Font("", Font.PLAIN, 20));
		
		//warehouse code field and label
		JLabel warehouseCodeLabel = new JLabel("Warehouse Code:");
		this.warehouseCode = new MyTextField(16);

		//address 1 field and label
		JLabel address1Label = new JLabel("Address 1:");
		this.address1 = new MyTextField(16);
		
		//address 2 field and label
		JLabel address2Label = new JLabel("Address 2:");
		this.address2 = new MyTextField(16);
		
		//state field and label
		JLabel stateLabel = new JLabel("State:");
		this.state = new MyTextField(16);
		
		//postcode field and label
		JLabel postcodeLabel = new JLabel("Postcode:");
		this.postcode = new MyTextField(16);
		
		//save button
		this.saveBtn = new JButton("Save");
		
		//delete button
		this.deleteBtn = new JButton("Delete");
		
		//edit button
		this.editBtn = new JButton("Edit");
		
		//clear button
		this.clearBtn = new JButton("Clear");
		
		//table to display all warehouses
		this.warehouseTable = new JTable();
		this.warehouseTable.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);

		tableModel = new DefaultTableModel() {
			@Override
			public boolean isCellEditable(int row, int col) {
				return false;
			}
		};
		this.warehouseTable.setModel(tableModel);
		
		JScrollPane scrollPane = new JScrollPane(this.warehouseTable);
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
							.addComponent(address2Label)
							.addComponent(stateLabel)
							.addComponent(postcodeLabel))
						.addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
							.addComponent(this.warehouseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.address1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.address2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.state, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)
							.addComponent(this.postcode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE)))
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
							.addComponent(this.warehouseCode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(address1Label)
							.addComponent(this.address1, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(address2Label)
							.addComponent(this.address2, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(stateLabel)
							.addComponent(this.state, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
							.addComponent(postcodeLabel)
							.addComponent(this.postcode, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE, GroupLayout.PREFERRED_SIZE))
					.addGroup(layout.createParallelGroup(GroupLayout.Alignment.BASELINE)
						.addComponent(saveBtn)
						.addComponent(editBtn)
						.addComponent(deleteBtn)
						.addComponent(clearBtn))
					.addComponent(scrollPane)
		);
		this.setVisible(true);
	}

	public String getWarehouseCode() {
		return warehouseCode.getText();
	}

	public void setWarehouseCode(String warehouseCode) {
		this.warehouseCode.setText(warehouseCode);
	}

	public String getAddress1() {
		return address1.getText();
	}

	public void setAddress1(String address1) {
		this.address1.setText(address1);
	}

	public String getAddress2() {
		return address2.getText();
	}

	public void setAddress2(String address2) {
		this.address2.setText(address2);
	}

	public String getState() {
		return state.getText();
	}

	public void setState(String state) {
		this.state.setText(state);
	}

	public String getPostcode() {
		return postcode.getText();
	}

	public void setPostcode(String postcode) {
		this.postcode.setText(postcode);
	}

	public DefaultTableModel getTableModel() {
		return tableModel;
	}

	public void setTableModel(DefaultTableModel tableModel) {
		this.tableModel = tableModel;
	}
	
	public JTable getWarehouseTable() {
		return warehouseTable;
	}

	public void setWarehouseTable(JTable warehouseTable) {
		this.warehouseTable = warehouseTable;
	}

	public WarehouseController getNewWarehouseController() {
		return warehouseController;
	}

	public void setNewWarehouseController(WarehouseController warehouseController) {
		this.warehouseController = warehouseController;
		this.saveBtn.addActionListener(warehouseController);
		this.deleteBtn.addActionListener(warehouseController);
		this.editBtn.addActionListener(warehouseController);
		this.clearBtn.addActionListener(warehouseController);
		this.warehouseTable.getSelectionModel().addListSelectionListener(warehouseController);
	}
	
	public void showDialog(String message) {
		JOptionPane.showMessageDialog(this, message);
	}
	
	public long getWarehouseId() {
		return warehouseId;
	}
	
	public void setWarehouseId(long warehouseId) {
		this.warehouseId = warehouseId;
	}
	
	public void removeColumn(int i) {
		TableColumnModel tcm = this.warehouseTable.getColumnModel();
		tcm.removeColumn(tcm.getColumn(0));
	}
	
	public void setFieldEditable(boolean b) {
		this.warehouseCode.setEditable(b);
		this.address1.setEditable(b);
		this.address2.setEditable(b);
		this.state.setEditable(b);
		this.postcode.setEditable(b);
	}
	
	public void clearField() {
		this.warehouseId = 0;
		this.warehouseCode.setText("");
		this.address1.setText("");
		this.address2.setText("");
		this.state.setText("");
		this.postcode.setText("");
	}
}
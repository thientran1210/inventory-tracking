package org.inventory.view.warehouse;

import java.awt.Dimension;
import java.awt.Font;

import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JTextField;

public class WarehouseView extends JPanel{
	
	private JTextField warehouseCode;
	private JTextField address1;
	private JTextField address2;
	private JTextField state;
	private JTextField postcode;
	private JButton saveBtn;
	private JButton deleteBtn;
	private JTable warehouseTable;
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
		this.warehouseCode = new JTextField(16);
		this.warehouseCode.setPreferredSize(new Dimension(200,20));

		//address 1 field and label
		JLabel address1Label = new JLabel("Address 1:");
		this.address1 = new JTextField(16);
		this.address1.setPreferredSize(new Dimension(200,20));
		
		//address 2 field and label
		JLabel address2Label = new JLabel("Address 2:");
		this.address2 = new JTextField(16);
		this.address2.setPreferredSize(new Dimension(200,20));
		
		//state field and label
		JLabel stateLabel = new JLabel("State:");
		this.state = new JTextField(16);
		this.state.setPreferredSize(new Dimension(200,20));
		
		//postcode field and label
		JLabel postcodeLabel = new JLabel("Postcode:");
		this.postcode = new JTextField(16);
		this.postcode.setPreferredSize(new Dimension(200,20));
		
		//save button
		this.saveBtn = new JButton("Save");
		
		//delete button
		this.deleteBtn = new JButton("Delete");
		
		//table to display all warehouses
		this.warehouseTable = new JTable();
		
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
					.addComponent(saveBtn)
					.addComponent(deleteBtn)
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
					.addComponent(saveBtn)
					.addComponent(deleteBtn)
		);
		this.setVisible(true);
	}

	public JTextField getWarehouseCode() {
		return warehouseCode;
	}

	public void setWarehouseCode(JTextField warehouseCode) {
		this.warehouseCode = warehouseCode;
	}

	public JTextField getAddress1() {
		return address1;
	}

	public void setAddress1(JTextField address1) {
		this.address1 = address1;
	}

	public JTextField getAddress2() {
		return address2;
	}

	public void setAddress2(JTextField address2) {
		this.address2 = address2;
	}

	public JTextField getState() {
		return state;
	}

	public void setState(JTextField state) {
		this.state = state;
	}

	public JTextField getPostcode() {
		return postcode;
	}

	public void setPostcode(JTextField postcode) {
		this.postcode = postcode;
	}

	public WarehouseController getNewWarehouseController() {
		return warehouseController;
	}

	public void setNewWarehouseController(WarehouseController warehouseController) {
		this.warehouseController = warehouseController;
		this.saveBtn.addActionListener(warehouseController);
		this.deleteBtn.addActionListener(warehouseController);
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
	
	
}
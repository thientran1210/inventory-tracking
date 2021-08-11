package org.inventory.newwarehouse;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JTextField;

public class NewWarehouseView extends JDialog{
	
	private JTextField name;
	private NewWarehouseController newWarehouseController;
	
	public NewWarehouseView(NewWarehouseController newWarehouseController) {
		this.newWarehouseController = new NewWarehouseController();
		this.initializeView();
	}
	
	public void initializeView() {
		JButton saveBtn = new JButton("Save");
		this.name = new JTextField("Enter warehouse name");
		this.add(saveBtn);
		this.add(name);
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		this.pack();
		this.setVisible(true);
	}
}

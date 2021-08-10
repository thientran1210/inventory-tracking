package org.inventory.view;

import javax.swing.*;

public class MainView extends JPanel{
    
	public MainView() {
		JFrame f = new JFrame("Inventory Tracking");
		JPanel p = new JPanel();
		JButton b=new JButton("click");//creating instance of JButton  
		b.setBounds(130, 100, 100, 40);//x axis, y axis, width, height  
		          
		p.add(b);//adding button in JFrame  
		          
		p.setSize(400,500);//400 width and 500 height  
		p.setLayout(null);//using no layout managers
		p.setVisible(true);
		f.add(p);
		f.setSize(400,500);
		f.setVisible(true);
	}

}

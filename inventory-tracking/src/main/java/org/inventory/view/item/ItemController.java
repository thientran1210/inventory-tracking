package org.inventory.view.item;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import org.inventory.view.warehouse.WarehouseModel;
import org.inventory.view.warehouse.WarehouseView;

public class ItemController implements ActionListener{

	private ItemModel itemModel;
	private ItemView itemView;
	public ItemController(ItemModel itemModel, ItemView itemView) {
		this.itemModel = itemModel;
		this.itemView = itemView;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		
	}

}

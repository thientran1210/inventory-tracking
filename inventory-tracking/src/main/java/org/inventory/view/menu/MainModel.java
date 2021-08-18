package org.inventory.view.menu;

import org.inventory.view.item.ItemView;

public class MainModel {
	private static ItemView itemView;
	
	public void openNewItem() {
		itemView = new ItemView();
	}
	
	
}

package org.inventory.menu;

import org.inventory.newitem.NewItemView;

public class MainModel {
	private static NewItemView newItemView;
	
	public void openNewItem() {
		newItemView = new NewItemView();
	}
	
	
}

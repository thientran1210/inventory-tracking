package org.inventory.util;

import java.awt.Dimension;

import javax.swing.JTextField;
import javax.swing.text.AbstractDocument;
import javax.swing.text.DocumentFilter;

public class MyTextField extends JTextField{

	public MyTextField(int i) {
		super(i);
		//force upper case
		DocumentFilter filter = new UppercaseDocumentFilter();
		setPreferredSize(new Dimension(200,20));
		((AbstractDocument) getDocument()).setDocumentFilter(filter);
	}
}

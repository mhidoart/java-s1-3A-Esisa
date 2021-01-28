package com.esisa.java.swing.contactmanager;

import java.awt.BorderLayout;
import java.util.Vector;

import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class ContactListPanel extends JPanel {
	private JTable table;
	private DefaultTableModel model;
	
	public ContactListPanel() {
		String titles[] = {"Id", "Nom", "Naissance", "Tel", "Email"};
		model = new DefaultTableModel(titles, 0);
		
		table = new JTable(model);
		
		setLayout(new BorderLayout());
		add("Center", new JScrollPane(table));
	}
	
	public void add(Contact contact) {
		model.addRow(new Object[] {contact.getId(), contact.getName(), contact.getBirthday(), contact.getTel(), contact.getEmail()});
	}
	
	public void set(Vector<Contact> list) {
		model.setRowCount(0);
		for (Contact contact : list) {
			add(contact);
		}
	}
}

package com.esisa.java.swing.contactmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import com.esisa.java.swing.components.Menu;

public class ContactManagerFrame extends JFrame implements ActionListener {
	private ContactManager manager;
	private String target = "resources/contacts.txt";
	
	private ContactFormDialog contactFormDialog;
	private ContactListDialog contactListDialog;

	
	public ContactManagerFrame() {
		manager = new ContactManager();
		contactFormDialog = new ContactFormDialog(this, manager);
		contactListDialog = new ContactListDialog(this, manager);
		contactListDialog.setTarget(target);
		
		createMenu();
		setExtendedState(MAXIMIZED_BOTH);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
	}
	
	private void createMenu() {
		String labels[][] = {
			{"Gestion de contacts", 
				"Nouveau Contact",
				"Liste de contacts",
				"Recherche Contact par Id",
				"Recherche Contact par nom",
				"-",
				"Quitter"
			}
		};
		Menu menu = new Menu(labels, "resources/contacts/", ".png");
		menu.addActionListener(this);
		setJMenuBar(menu);
	}
	
	public static void main(String[] args) {
		new ContactManagerFrame();
	}

	public void actionPerformed(ActionEvent e) {
		JMenuItem item = (JMenuItem)e.getSource();
		if (item.getText().equals("Nouveau Contact")) {
			contactFormDialog.setVisible(true);
		}
		else if (item.getText().equals("Liste de contacts")) {
			contactListDialog.refresh();
			contactListDialog.setVisible(true);
		}
	}
}

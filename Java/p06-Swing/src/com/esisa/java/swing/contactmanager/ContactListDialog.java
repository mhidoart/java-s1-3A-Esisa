package com.esisa.java.swing.contactmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import com.esisa.java.swing.components.ButtonPanel;

public class ContactListDialog extends JDialog implements ActionListener {
	private ContactManager manager;
	private ContactListPanel list;
	private String target;

	public ContactListDialog(JFrame owner, ContactManager manager) {
		super(owner, true);
		this.manager = manager;
		list = new ContactListPanel();
		getContentPane().add("Center", list);
		ButtonPanel p1 = new ButtonPanel("Enregistrer", "Fermer");
		p1.addActionListener(this);
		getContentPane().add("South", p1);
		pack();
		setLocationRelativeTo(owner);
		
	}

	public void setTarget(String target) {
		this.target = target;
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if (src.getText().equals("Enregistrer")) {
			manager.save(target);
			dispose();
		}
		else if (src.getText().equals("Fermer")) {
			dispose();
		}
	}
	
	public void refresh() {
		list.set(manager.getAllContacts());
	}
}

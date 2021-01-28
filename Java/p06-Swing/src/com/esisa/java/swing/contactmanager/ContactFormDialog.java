package com.esisa.java.swing.contactmanager;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.esisa.java.swing.components.ButtonPanel;

public class ContactFormDialog extends JDialog implements ActionListener {
	private ContactForm form;
	private ContactManager manager;
	
	public ContactFormDialog(JFrame owner, ContactManager manager) {
		super(owner, true);
		this.manager = manager;
		form = new ContactForm();
		getContentPane().add("Center", form);
		ButtonPanel p1 = new ButtonPanel("Enregistrer", "Vider", "Annuler");
		p1.addActionListener(this);
		getContentPane().add("South", p1);
		pack();
		setLocationRelativeTo(owner);
	}
	
	public static void main(String[] args) {
		new ContactFormDialog(null, new ContactManager());
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.getText().equals("Enregistrer")) {
			Contact contact = form.getContact();
			manager.add(contact);
			JOptionPane.showMessageDialog(this, "Contact bien enregistré : " + contact.getName());
			form.clear();
			dispose();
		}
		else if (b.getText().equals("Vider")) {
			form.clear();
		}
		else if (b.getText().equals("Annuler")) {
			dispose();
		}
	}
}

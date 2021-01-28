package com.esisa.java.io.presentation;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import com.esisa.java.io.business.ContactManager;
import com.esisa.java.io.models.Company;
import com.esisa.java.io.models.Contact;
import com.esisa.java.io.presentation.components.ButtonPanel;

public class ContactFormDialog extends JDialog implements ActionListener {
	private static final long serialVersionUID = 1L;
	
	private ContactForm form;
	private ContactManager manager;
	
	public ContactFormDialog(JFrame owner, ContactManager manager) {
		super(owner, true);
		this.manager = manager;
		form = new ContactForm(manager.companies());
		getContentPane().add("Center", form);
		ButtonPanel p1 = new ButtonPanel("Enregistrer", "Vider", "Annuler");
		p1.addActionListener(this);
		getContentPane().add("South", p1);
		pack();
		setLocationRelativeTo(owner);
	}

	public void actionPerformed(ActionEvent e) {
		JButton b = (JButton)e.getSource();
		if (b.getText().equals("Enregistrer")) {
			Contact contact = form.getContact();
			manager.add(contact);
			JOptionPane.showMessageDialog(this, "Contact bien enregistré : " 
					+ contact.getFirstName() + " " + contact.getLastName());
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

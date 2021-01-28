package com.esisa.java.swing.contactmanager;

import com.esisa.java.swing.components.Form;

public class ContactForm extends Form {
	public ContactForm() {
		super("Nouveau Contact", 120);
		add("Identificateur", 10);
		add("Nom", 30);
		add("Date de naissance", 12);
		add("Téléphone", 15);
		add("Adresse email", 30);
	}
	
	public Contact getContact() {
		Contact contact = new Contact(
			getIntValue(0), getValue(1), new Date(getValue(2)), getValue(3), getValue(4)
		);
		
		return contact;
	}
	
	public void setContact(Contact contact) {
		setValue(0, "" + contact.getId());
		setValue(1, contact.getName());
		setValue(2, contact.getBirthday().toString());
		setValue(3, contact.getTel());
		setValue(4, contact.getEmail());
	}
}

package com.esisa.java.io.presentation;

import java.util.List;

import com.esisa.java.io.models.Company;
import com.esisa.java.io.models.Contact;
import com.esisa.java.io.presentation.components.Form;

public class ContactForm extends Form {

	public ContactForm(List<Company> companies) {
		super("Nouveau Contact", 120);
		add("Identificateur", 10);
		add("Nom", 30);
		add("Prénom", 30);
		add("Adresse email", 40);
		Object items[] = new Company[companies.size()];
		companies.toArray(items);
		addComboChoiceField("Entreprise", items);
	}

	public Contact getContact() {
		Contact c = new Contact(
			getIntValue(0), getValue(2), getValue(1), getValue(3)
		);
		c.setCompany((Company)getObjectValue(4));
		return c;
	}
}

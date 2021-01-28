package com.esisa.java.io.presentation;

import com.esisa.java.io.models.Company;
import com.esisa.java.io.presentation.components.Form;

public class CompanyForm extends Form {

	public CompanyForm() {
		super("Nouvelle entreprise", 120);
		add("Identificateur", 10);
		add("Nom", 30);
		add("Ville", 20);
		add("Site Web", 40);
	}

	public Company getCompany() {
		return new Company(
			getIntValue(0), getValue(1), getValue(2), getValue(3)
		);
	}
	
	public void setCompany(Company company) {
		setValues("" + company.getId(), 
				company.getName(), company.getCity(), company.getWebSite());
	}
}

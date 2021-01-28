package com.esisa.java.io.presentation;

import java.util.List;
import java.util.Vector;

import com.esisa.java.io.business.ContactManager;
import com.esisa.java.io.business.ContactManagerDefault;
import com.esisa.java.io.dao.CompanyDAO;
import com.esisa.java.io.dao.CompanyDAOObject;
import com.esisa.java.io.dao.ContactDAO;
import com.esisa.java.io.dao.ContactDAOObject;
import com.esisa.java.io.models.Company;

public class Test {

	public Test() {
		exp04();
	}
	
	void exp01() {
		Vector<Company> cmp = new Vector<>();
		cmp.add(new Company(101, "Capgemini", "Rabat", "www.capgemini.com"));
		cmp.add(new Company(102, "CGI", "Fès", "www.cgi.com"));
		cmp.add(new Company(103, "Atos", "Casablanca", "www.atos.net"));
		
		CompanyDAO companyDao = new  CompanyDAOObject("resources/companies.com");
		companyDao.save(cmp);
	}
	
	void exp02() {
		CompanyDAO companyDao = new  CompanyDAOObject("resources/companies.com");
		List<Company> cmp = companyDao.load();
		for (Company company : cmp) {
			System.out.println(company);
		}
	}
	
	void exp03() {
		CompanyDAO companyDAO = new CompanyDAOObject("resources/gdc/companies.obj");
		ContactManagerDefault contactManager = new ContactManagerDefault(companyDAO, null);
		contactManager.setSaveStrategy(ContactManagerDefault.SAVE_AUTO);
		CompanyFormDialog companyFormDialog = new CompanyFormDialog(null, contactManager);
		
		companyFormDialog.setVisible(true);
	}
	
	void exp04() {
		CompanyDAO companyDAO = new CompanyDAOObject("resources/gdc/companies.obj");
		ContactDAO contactDAO = new ContactDAOObject("resources/gdc/contacts.obj");
		
		ContactManagerDefault contactManager = new ContactManagerDefault(companyDAO, contactDAO);
		contactManager.setSaveStrategy(ContactManagerDefault.SAVE_AUTO);
		ContactFormDialog contactFormDialog = new ContactFormDialog(null, contactManager);
		
		contactFormDialog.setVisible(true);
	}

	public static void main(String[] args) {
		new Test();
	}

}

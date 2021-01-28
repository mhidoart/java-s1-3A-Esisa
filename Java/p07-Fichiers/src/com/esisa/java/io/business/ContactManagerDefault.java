package com.esisa.java.io.business;

import java.util.List;
import java.util.Vector;

import com.esisa.java.io.dao.CompanyDAO;
import com.esisa.java.io.dao.ContactDAO;
import com.esisa.java.io.models.Company;
import com.esisa.java.io.models.Contact;

public class ContactManagerDefault implements ContactManager {
	public static final int SAVE_AUTO = 0;
	public static final int SAVE_REQUEST = 1;
	
	private int saveStrategy = SAVE_AUTO;
	
	private List<Company> companiesList;
	private List<Contact> contactsList;
	
	private CompanyDAO companyDAO;
	private ContactDAO contactDAO;
	
	public ContactManagerDefault() {
		companiesList = new Vector<>();
		contactsList = new Vector<>(); 
	}
	
	public ContactManagerDefault(CompanyDAO companyDAO, ContactDAO contactDAO) {
		setCompanyDAO(companyDAO);
		setContactDAO(contactDAO);
	}

	public ContactDAO getContactDAO() {
		return contactDAO;
	}

	public void setContactDAO(ContactDAO contactDAO) {
		this.contactDAO = contactDAO;
		contactsList = contactDAO.load();
		if (contactsList == null) {
			contactsList = new Vector<>();
		}
	}

	public CompanyDAO getCompanyDAO() {
		return companyDAO;
	}

	public void setCompanyDAO(CompanyDAO companyDAO) {
		this.companyDAO = companyDAO;
		companiesList = companyDAO.load();
		if (companiesList == null) {
			companiesList = new Vector<>();
		}
	}

	public int getSaveStrategy() {
		return saveStrategy;
	}

	public void setSaveStrategy(int saveStrategy) {
		this.saveStrategy = saveStrategy;
	}

	public void add(Contact contact) {
		contactsList.add(contact);
		if (saveStrategy == SAVE_AUTO) {
			contactDAO.save(contactsList);
		}
	}
	
	public void add(Company company) {
		companiesList.add(company);
		if (saveStrategy == SAVE_AUTO) {
			companyDAO.save(companiesList);
		}
	}

	public Company getCompany(int id) {
		return null;
	}

	public Contact getContact(int id) {
		return null;
	}

	public List<Company> companies() {
		return companiesList;
	}

	public List<Company> companies(String keyword) {
		return null;
	}

	public void save() {
		companyDAO.save(companiesList);
		contactDAO.save(contactsList);
	}
}

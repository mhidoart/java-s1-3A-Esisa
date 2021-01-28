package com.esisa.java.io.business;

import java.util.List;

import com.esisa.java.io.models.Company;
import com.esisa.java.io.models.Contact;

public interface ContactManager {
	public void add(Contact contact);
	public void add(Company company);
	public Company getCompany(int id);
	public Contact getContact(int id);
	public List<Company> companies();
	public List<Company> companies(String keyword);
	public void save();
}

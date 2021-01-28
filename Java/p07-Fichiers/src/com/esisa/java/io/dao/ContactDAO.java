package com.esisa.java.io.dao;

import java.util.List;

import com.esisa.java.io.models.Contact;

public interface ContactDAO {
	public void save(List<Contact> contacts);
	public List<Contact> load();
}

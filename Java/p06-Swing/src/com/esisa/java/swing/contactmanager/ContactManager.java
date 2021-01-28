package com.esisa.java.swing.contactmanager;

import java.io.FileWriter;
import java.util.Vector;

public class ContactManager {
	private Vector<Contact> list;
	
	public ContactManager() {
		list = new Vector<>();
	}
	
	public void add(Contact contact) {
		list.add(contact);
	}
	
	public Contact get(int id) {
		for (Contact contact : list) {
			if (contact.getId() == id) return contact;
		}
		return null;
	}
	
	public Vector<Contact> seek(String keyword) {
		Vector<Contact> v = new Vector<>();
		keyword = keyword.toLowerCase();
		for (Contact contact : list) {
			if (contact.getName().toLowerCase().contains(keyword)) {
				v.add(contact);
			}
		}
		return v;
	}

	public Vector<Contact> getAllContacts() {
		return list;
	}
	
	public void save(String target) {
		try {
			FileWriter out = new FileWriter(target);
			for (Contact contact : list) {
				out.write(contact.toString() + "\n");
			}
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}

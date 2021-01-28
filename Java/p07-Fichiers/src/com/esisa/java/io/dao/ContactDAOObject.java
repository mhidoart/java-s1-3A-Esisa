package com.esisa.java.io.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import com.esisa.java.io.models.Company;
import com.esisa.java.io.models.Contact;

public class ContactDAOObject implements ContactDAO {
	private String source;
	
	public ContactDAOObject() {	
	}
	
	public ContactDAOObject(String source) {
		super();
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void save(List<Contact> contacts) {
		try {
			FileOutputStream f = new FileOutputStream(source);
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(contacts);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Contact> load() {
		try {
			File file = new File(source);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				return new Vector<Contact>();
			}
			FileInputStream f = new FileInputStream(source);
			ObjectInputStream in = new ObjectInputStream(f);
			List<Contact> contacts = (List<Contact>)in.readObject();
			in.close();
			return contacts;
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}
}

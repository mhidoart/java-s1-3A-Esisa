package com.esisa.java.io.dao;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;
import java.util.Vector;

import com.esisa.java.io.models.Company;

public class CompanyDAOObject implements CompanyDAO {
	private String source;
	
	public CompanyDAOObject() {	
	}
	
	public CompanyDAOObject(String source) {
		super();
		this.source = source;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public void save(List<Company> companies) {
		try {
			FileOutputStream f = new FileOutputStream(source);
			ObjectOutputStream out = new ObjectOutputStream(f);
			out.writeObject(companies);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			e.printStackTrace();
		}
	}

	public List<Company> load() {
		try {
			File file = new File(source);
			if (!file.exists()) {
				file.getParentFile().mkdirs();
				return new Vector<Company>();
			}
			FileInputStream f = new FileInputStream(source);
			ObjectInputStream in = new ObjectInputStream(f);
			List<Company> cmp = (List<Company>)in.readObject();
			in.close();
			return cmp;
		} 
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return null;
		}
	}

}

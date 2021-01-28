package com.esisa.stock.dao;

import java.util.List;
import java.util.Vector;

import com.esisa.java.jdbc.dao.Database;
import com.esisa.stock.models.Produit;

public class ProduitDaoJdbc implements ProduitDao {
	private Database db;
	
	public ProduitDaoJdbc() {
	}

	public ProduitDaoJdbc(Database db) {
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}

	public Database getDatabase() {
		return db;
	}
	
	public boolean insert(Produit p) {
		return db.insert("Produit", p.getRef(), p.getDesig(), p.getPu(), p.getQs());
	}

	public void update(Produit p) {

	}

	public boolean delete(String ref) {
		return db.delete("Produit", "Ref", ref);
	}

	public Produit select(String ref) {
		String data[][] = db.select("Produit", "Ref", ref);
		if (data != null && data.length >= 2) {
			return new Produit(data[1]);
		}
		return null;
	}

	public List<Produit> select() {
		String data[][] = db.select("Produit");
		Vector<Produit> list = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			list.add(new Produit(data[i]));
		}
		return list;
	}

}

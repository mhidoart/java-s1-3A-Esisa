package com.esisa.stock.swing;

import java.util.List;

import com.esisa.java.jdbc.dao.DataSource;
import com.esisa.java.jdbc.dao.Database;
import com.esisa.java.jdbc.dao.MySQLDataSource;
import com.esisa.stock.dao.ProduitDao;
import com.esisa.stock.dao.ProduitDaoJdbc;
import com.esisa.stock.models.Produit;

public class Examples {
	public Examples() {
		exp04();
	}
	
	void exp01() {
		Produit t[] = {
				new Produit("R01", "Clavier", 200, 10),
				new Produit("R02", "Ecran", 2400, 7),
				new Produit("R03", "Souris", 176, 12)
		};
		// Wiring :
		DataSource ds = new MySQLDataSource("Stock");
		Database db = new Database(ds);
		ProduitDao dao = new ProduitDaoJdbc(db);
		
		for (int i = 0; i < t.length; i++) {
			dao.insert(t[i]);
		}
	}
	
	void exp02() {
		DataSource ds = new MySQLDataSource("Stock");
		Database db = new Database(ds);
		ProduitDao dao = new ProduitDaoJdbc(db);
		List<Produit> list = dao.select();
		for (Produit produit : list) {
			System.out.println(produit);
		}
		
	}
	
	void exp03() {
		DataSource ds = new MySQLDataSource("Stock");
		Database db = new Database(ds);
		ProduitDao dao = new ProduitDaoJdbc(db);
		Produit p = dao.select("R02");
		System.out.println(p);
	}
	
	void exp04() {
		DataSource ds = new MySQLDataSource("Stock");
		Database db = new Database(ds);
		ProduitDao dao = new ProduitDaoJdbc(db);
		dao.delete("R02");
		
		List<Produit> list = dao.select();
		for (Produit produit : list) {
			System.out.println(produit);
		}
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}

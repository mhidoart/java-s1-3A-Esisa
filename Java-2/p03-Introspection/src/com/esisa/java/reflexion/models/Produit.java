package com.esisa.java.reflexion.models;

import com.esisa.java.reflexion.annotations.Form;
import com.esisa.java.reflexion.annotations.TextField;

@Form(title="Liste des produits", labelWidth=200)
public class Produit {
	@TextField(label = "Référence")
	private String ref;
	@TextField(label = "Désignation", size = 30)
	private String desig;
	@TextField(label = "Prix Unitaire", size = 10)
	private double pu;
	@TextField(label = "Quantit en Stock", size = 10)
	private double qs;

	public Produit() {
	}

}

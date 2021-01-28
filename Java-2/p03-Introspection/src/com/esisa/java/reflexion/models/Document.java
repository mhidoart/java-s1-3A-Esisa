package com.esisa.java.reflexion.models;

import com.esisa.java.reflexion.annotations.Form;
import com.esisa.java.reflexion.annotations.TextField;

@Form(title="Nouveau Document")
public class Document {
	@TextField(label="ISBN")
	private String isbn;
	@TextField(label="Titre", size=40)
	private String title;
	@TextField(label="Prix Unitaire", size=10)
	private double price;
	private int publisherId;
	
	public Document() {
		super();
	}

	public Document(String isbn, String title, double price, int publisherId) {
		super();
		this.isbn = isbn;
		this.title = title;
		this.price = price;
		this.publisherId = publisherId;
	}

	@Override
	public String toString() {
		return "Document [isbn=" + isbn + ", title=" + title + ", price=" + price + ", publisherId=" + publisherId
				+ "]";
	}
	
	public void print() {
		System.out.println(this);
	}
	
	public void print(String msg, int index) {
		System.out.println(index + " : " + msg + " (" + isbn + ", " + title + ", " + price + ", " + publisherId + ")");
	}
}

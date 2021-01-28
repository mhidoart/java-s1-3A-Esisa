package com.esisa.java;

public class Product {
	private int id;
	private String name;
	private double price;
	private Date date;
	
	public Product() {
	}
	// Surcharge = Surdéfinition
	public Product(int id, String name, double price, Date date) {
		this.id = id;
		this.name = name;
		this.price = price;
		this.date = date;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}
	
	public Date getDate() {
		return date;
	}
	
	public void setDate(Date date) {
		this.date = date;
	}
	// Surcharge = Surdéfinition de la méthode setDate
	public void setDate(int day, int month, int year) {
		this.date = new Date(day, month, year);
	}
	
	public void print() {
		System.out.print("Produit(" + id + ", " + name + ", " + price + ", ");
		if (date != null) date.print();
		System.out.println(")");
	}
}

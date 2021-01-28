package com.esisa.java.exp02;

public class Document {
	private int id;
	private String title;
	private Author author; // un tableau d'auteurs après
	private double price;
	private boolean available;
	
	public Document() {
		super();
	}

	public Document(int id, String name, Author author, double price, boolean available) {
		super();
		this.id = id;
		this.title = name;
		this.author = author;
		this.price = price;
		this.available = available;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String name) {
		this.title = name;
	}

	public Author getAuthor() {
		return author;
	}

	public void setAuthor(Author author) {
		this.author = author;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public boolean isAvailable() {
		return available;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", name=" + title + ", author=" + author + ", price=" + price + ", available="
				+ available + "]";
	}
}

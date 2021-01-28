package com.esisa.jee.models;

public class Authors {

	private int id;
	private String Author;
	private YearGenerator YearBorn;
	
	public Authors() {
		
	}

	public Authors(int id, String author, YearGenerator yearBorn) {
		super();
		this.id = id;
		Author = author;
		YearBorn = yearBorn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAuthor() {
		return Author;
	}

	public void setAuthor(String author) {
		Author = author;
	}

	public YearGenerator getYearBorn() {
		return YearBorn;
	}

	public void setYearBorn(YearGenerator yearBorn) {
		YearBorn = yearBorn;
	}

	@Override
	public String toString() {
		return "Authors [id=" + id + ", Author=" + Author + ", YearBorn=" + YearBorn + "]";
	}

	
}

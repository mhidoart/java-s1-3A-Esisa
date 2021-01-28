package com.esisa.java.io.models;

import java.io.Serializable;

public class Company implements Serializable {
	private static final long serialVersionUID = 1L;
	
	private int id;
	private String name;
	private String city;
	private String webSite;
	
	public Company() {
		super();
	}

	public Company(int id, String name, String city, String webSite) {
		super();
		this.id = id;
		this.name = name;
		this.city = city;
		this.webSite = webSite;
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

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getWebSite() {
		return webSite;
	}

	public void setWebSite(String webSite) {
		this.webSite = webSite;
	}

	@Override
	public String toString() {
		return name;
	}
}

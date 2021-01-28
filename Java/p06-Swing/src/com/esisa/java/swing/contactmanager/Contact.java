package com.esisa.java.swing.contactmanager;

public class Contact {
	private int id;
	private String name;
	private Date birthday;
	private String tel;
	private String email;
	
	public Contact() {
		super();
	}

	public Contact(int id, String name, Date birthday, String tel, String email) {
		super();
		this.id = id;
		this.name = name;
		this.birthday = birthday;
		this.tel = tel;
		this.email = email;
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

	public Date getBirthday() {
		return birthday;
	}

	public void setBirthday(Date birthday) {
		this.birthday = birthday;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString() {
		return id + "," + name + "," + birthday + "," + tel + "," + email;
	}
}

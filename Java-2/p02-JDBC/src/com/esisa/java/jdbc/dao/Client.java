package com.esisa.java.jdbc.dao;

public class Client {
	
	public Client() {
		exp04();
	}
	
	void exp01() {
		DataSource ds = new MySQLDataSource("biblio");
		Database db = new Database(ds);
		db.select();
	}
	
	void print(String data[][]) {
		for (int i = 0; i < data.length; i++) {
			for (int j = 0; j < data[i].length; j++) {
				System.out.print(data[i][j] + ", ");
			}
			System.out.println();
		}
	}
	
	void exp02() {
		DataSource ds = new MySQLDataSource("biblio");
		Database db = new Database(ds);
		String data[][] = db.select("Titles");
		print(data);
	}
	
	void exp03() {
		DataSource ds = new MySQLDataSource("biblio");
		Database db = new Database(ds);
		String data[][] = db.selectLike("Titles", "Title", "Java");
		print(data);
	}
	
	void exp04() {
		DataSource ds = new MySQLDataSource("biblio");
		Database db = new Database(ds);
		String data[][] = db.select("Authors", "Au_ID", 240);
		print(data);
	}

	public static void main(String[] args) {
		new Client();
	}
}

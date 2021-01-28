package com.esisa.jee.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class MySQLDataSource extends DataSource {
	public static final String MYSQL_DRIVER = "com.mysql.jdbc.Driver";
	public static final String MYSQL_BRIDGE = "jdbc:mysql:";
	
	public MySQLDataSource(String host, String source, String userName, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE + "//" + host + "/" + source, userName, password);
	}
	
	public MySQLDataSource(String source, String userName, String password) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE + "//localhost/" + source, userName, password);
	}
	
	public MySQLDataSource(String source, String userName) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE + "//localhost/" + source, userName, "");
	}
	
	public MySQLDataSource(String source) {
		super(MYSQL_DRIVER, MYSQL_BRIDGE + "//localhost/" + source, "root", "");
	}

	public Connection getConnection() {
		try {
			//1. Chargement du Driver
			Class.forName(MYSQL_DRIVER);
			//3. Connexion
			Connection db = DriverManager.getConnection(getUrl(), getUser(), getPassword());
			System.out.println("Connexion bien établie...");
			return db;
		}
		catch (Exception e) {
			System.out.println("Erreur de connexion : " + e.getMessage());
			return null;
		}
	}

}

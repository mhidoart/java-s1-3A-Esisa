package com.esisa.java.web;

public class Test {
	public Test() {
		WebServer server = new WebServer();
		server.start();
	}
	
	public static void main(String[] args) {
		new Test();
	}
}

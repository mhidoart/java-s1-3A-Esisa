package com.esisa.java;

public class ConsolePrinter implements Printer {

	public ConsolePrinter() {
	}

	public void print(String[] t) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
}

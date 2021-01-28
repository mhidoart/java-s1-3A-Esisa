package com.esisa.java.io;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Examples {
	
	void exp00() {
		try {
			exp01();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp01() throws Exception {
		FileReader f = new FileReader("");
	}
	
	void exp02() {
		try {
			FileReader f = new FileReader(""); // FileNotFoundException
			f.read(); // IOException
		}
		catch (FileNotFoundException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		catch (IOException e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp03() {
		try {
			FileReader f = new FileReader("src/com/esisa/java/io/Examples.java");
			int c;
			while ((c = f.read()) > 0 ) {
				System.out.print((char)c);
			}
			f.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp04() {
		try {
			FileReader f = new FileReader("src/com/esisa/java/io/Examples.java");
			FileWriter out = new FileWriter("resources/Exp01.java");
			int c;
			while ((c = f.read()) > 0 ) {
				out.write(c);
				System.out.print((char)c);
			}
			f.close();
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}

	public Examples() {		
		exp04();
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}

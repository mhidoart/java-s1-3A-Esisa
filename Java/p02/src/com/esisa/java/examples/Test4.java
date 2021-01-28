package com.esisa.java.examples;

import com.esisa.java.modifiers.Grade;
import com.esisa.java.modifiers.Person;

public class Test4 {
	private Person p1, p2, p3;
	
	public Test4() {
		exp02();
	}
	
	public static void main(String[] args) {
		new Test4();
	}
	
	void exp01() {
		System.out.println("Compteur : " + Person.getCounter());
		
		p1 = new Person("Omar", "omar@gmail.com", "0661342345");
		p2 = new Person("Khalid", "khalid@gmail.com", "0662324312");
		p3 = new Person("Amine", "amine@gmail.com", "0663436545");
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println("Compteur : " + Person.getCounter());
	}

	void exp02() {
		Grade g1 = new Grade(18);
		g1.setValue(21);
		System.out.println(g1);
		
		System.out.println("MAX VALUE est = " + Grade.MAX_VALUE);
	}
}

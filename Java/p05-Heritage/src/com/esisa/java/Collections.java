package com.esisa.java;

import java.util.LinkedList;
import java.util.Vector;

public class Collections {

	public Collections() {
		exp02();
	}
	
	void exp01() {
		Vector<Object> v1 = new Vector<>();
		
		v1.add("Une chaîne");
		v1.add(new Point(10, 30));
		v1.add(20); // Autoboxing + Affectation Fille Mère
		
		System.out.println(v1);
		Point p1 = (Point)v1.get(1);
		p1.print();
	}
	
	void exp02() {
		LinkedList<Object> v1 = new LinkedList<>();
		
		v1.add("Une chaîne");
		v1.add(new Point(10, 30));
		v1.add(20); // Autoboxing + Affectation Fille Mère
		
		System.out.println(v1);
		Point p1 = (Point)v1.get(1);
		p1.print();
	}

	public static void main(String[] args) {
		new Collections();
	}
}

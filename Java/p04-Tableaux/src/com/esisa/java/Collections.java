package com.esisa.java;

import java.util.Vector;

public class Collections {

	public Collections() {
		exp03();
	}
	
	void exp01() {
		Vector v1 = new Vector();
		v1.add(20);
		v1.add("une chaîne");
		v1.add(12.5);
		
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
		}
	}
	// Le type générique
	void exp02() {
		Vector<Integer> v1 = new Vector<>();
		v1.add(20);
		v1.add(30);
		v1.add(40);
		
		for (int i = 0; i < v1.size(); i++) {
			System.out.println(v1.get(i));
		}
	}
	
	void exp03() {
		Vector<Point> v1 = new Vector<>();
		v1.add(new Point(10, 30));
		v1.add(new Point(23, 10));
		v1.add(new Point(15, 17));
		
		for (Point p : v1) {
			System.out.println(p);
		}
	}

	public static void main(String[] args) {
		new Collections();
	}

}

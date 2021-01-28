package com.esisa.java;

import java.awt.Color;

public class Examples {

	public Examples() {
		exp07();
	}
	
	void exp01() {
		Point p1 = new Point(10, 20);
		p1.print();
	}
	
	void exp02() {
		Pixel p1 = new Pixel();
		p1.setX(20);
		p1.setY(30);
		p1.print();
	}

	void exp03() {
		Pixel p1 = new Pixel(10, 20);
		p1.print();
		
		Pixel p2 = new Pixel(20, 30, new Color(255, 0, 0));
		p2.print();
	}
	
	void exp04() {
		// Affectation Fille Mère
		Point p1 = new Pixel(10, 15, Color.BLUE);
		//System.out.println(p1.getClass().getSimpleName());
		p1.print();
		
		Point m1 = new Point(10, 30);
		// Affectation Mère fille :
		Pixel p2 = (Pixel)p1;
	}
	
	void exp05() {
		Point p1 = new Point(12, 17);
		Pixel p2 = new Pixel(10, 53, Color.black);
		afficher2(p1);
		afficher(p2);
	}
	
	void afficher(Point p) {
		System.out.println("Type de p : " + p.getClass().getSimpleName());
		p.print();
	}
	
	void afficher2(Object x) {
		System.out.println(x);
	}
	
	void exp06() {
		Object p1 = new Point(10, 20);
		Object p2 = new Pixel(10, 20, Color.white);
		
		Point p3 = (Point)p1;
		p3.print();
		
		Point p4 = (Point)p2;
		System.out.println(((Pixel)p4).getColor());
		p4.print();
		
		Point p5 = new Point(10, 20);
		System.out.println(p1 == p5);
		System.out.println("p1.equals(p5) = " + p1.equals(p5));
		
		Color c1 = new Color(10, 200, 120);
		Color c2 = new Color(10, 200, 120);
		System.out.println(c1);
		System.out.println(c1.equals(c2));
		
		System.out.println(p1.equals(p2));
		
		Object p6 = new Pixel(10, 20, Color.blue);
		System.out.println(p2.equals(p6));
	}
	
	void exp07() {
		DataManager dm = new DataManager();
		dm.addPrinter(new ConsolePrinter());
		dm.addPrinter(new DialogPrinter());
		dm.add("Swing");
		dm.add("LayoutManager");
		dm.add("JPanel");
		dm.add("Component");
		dm.add("Container");
		dm.print();
	}
	
	public static void main(String[] args) {
		new Examples();
	}

}

package com.esisa.java;

public class Test3 {

	public static void main(String[] args) {
		Date d1 = new Date(21, 9, 2018);
		//d1.print();
		Product p1 = new Product(101, "Ecarn", 2400, d1);
		p1.getDate().setYear(2020);
		p1.print();
		
		d1.print();
		System.out.println();
		
		p1.setDate(new Date(10, 9, 2018));
		p1.print();
		
		p1.setDate(10, 12, 2017);
		p1.print();
	}

}

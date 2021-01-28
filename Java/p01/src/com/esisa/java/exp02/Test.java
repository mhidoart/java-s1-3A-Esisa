package com.esisa.java.exp02;

import com.esisa.java.Date;

public class Test {
	public static void main(String[] args) {
		Date d1 = new Date(21, 9, 2018);
		System.out.println(d1);
		
		Author a1 = new Author(1120, "Erich Gamma", new Date(13, 3, 1961));
		System.out.println(a1);
		//System.out.println(a1.toString());
		
		Document doc1 = new Document(10, "Design Patterns", a1, 1250, true);
		System.out.println(doc1);
	}
}

package com.esisa.java;

public class Test2 {

	public static void main(String[] args) {
		Product p1 = new Product(101, "Clavier", 260, null);
		// affectation de références (adresses) :
		Product p2 = p1;
		
		p2.setName("Ecran");
		
		p1.print();
		
		Product p3 = new Product(101, "Ecran", 260, null);
		p3.print();
		
		// comparaison de références (adresses)
		System.out.println(p1 == p2);
		System.out.println(p1 == p3);
	}

}

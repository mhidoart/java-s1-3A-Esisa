package com.esisa.java;

public class Examples {

	public Examples() {
		exp06();
	}
	
	// Les chaînes de caractères :
	public void exp01() {
		String s1 = "Une chaîne";
		String s2 = new String("Une autre chaîne");
		System.out.println(s1.length());
		System.out.println(s2.length());
		System.out.println("Une 3ème chaine".length());
		String s4 = "Une chaîne";
		String s5 = s1;
		String s6 = new String("Une autre chaîne");
		
		System.out.println(s4 == s1);
		System.out.println(s4.equals(s1));
		System.out.println(s5 == s1);
		System.out.println(s6 == s2);
		System.out.println(s6.equals(s2));
	}
	
	public void exp02() {
		String s1 = "Souris";
		String s2 = "Clavier";
		String s3 = "Ecran";
		if ( (s1.compareTo(s2) < 0) && (s1.compareTo(s3) < 0)) {
			if (s2.compareTo(s3) < 0) System.out.println(s1 + ", " + s2 + ", " + s3);
			else System.out.println(s1 + ", " + s3 + ", " + s2);
		}
		else if ( (s2.compareTo(s1) < 0) && (s2.compareTo(s3) < 0) ) {
			if (s1.compareTo(s3) < 0) System.out.println(s2 + ", " + s1 + ", " + s3);
			else System.out.println(s2 + ", " + s3 + ", " + s1);
		}
		else {
			if (s1.compareTo(s2) < 0) System.out.println(s3 + ", " + s1 + ", " + s2);
			else System.out.println(s3 + ", " + s2 + ", " + s1);
		}
	}
	
	public void exp03() {
		String s1 = "Une Chaîne de caractères";
		String s2 = "chaîne";
		System.out.println(s1.toLowerCase().contains(s2.toLowerCase()));
		System.out.println(s1.toUpperCase());
	}
	
	public void exp04() {
		String s1 = "245";
		int x = Integer.parseInt(s1); // Classe Wrapper (enveloppe)
		System.out.println(x);
		
		double y = Double.parseDouble(s1);
		System.out.println(y);
		
		Integer x2 = new Integer(123); // Deprecated depuis la version 9
		Integer x3 = 123; // Autoboxing depuis la version 5
		
		int x4 = x3; // Unboxing depuis la version 5;
		int x5 = x3.intValue(); // avant la version 5;
		// Liste des 8 types Wrappers
		// Byte, Short, Integer, Long, Float, Double, Character, Boolean
		
		String s2 = "ABC";
		int x6 = 0;
		try {
			x6 = Integer.parseInt(s2);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		System.out.println("s6 = " + x6);
		
		int x7 = 234;
		String s3 = "" + x7;
		System.out.println(s3);
	}
	
	public void exp05() {
		String s1 = "Une chaine";
		String s2 = s1.toUpperCase();
		s2 = s2.replace("CHAINE", "NOUVELLE CHAINE");
		System.out.println(s2);
		
		for (int i = 0; i < s2.length(); i++) {
			System.out.println(s2.charAt(i));
		}
		
		String s3 = s2.substring(4, 12);
		System.out.println(s3);
	}
	
	public void exp06() {
		String s1 = "Une chaine de cracartères est une instance de la classe String";
		String s2 = s1.toLowerCase();
		String word = "c";
		
		int n = 0;
		int p;
		
		p = s2.indexOf(word);
		while (p >= 0) {
			System.out.println(p);
			n++;
			p = s2.indexOf(word, p + 1);
		}
		System.out.println("Nombre d'occurences : " + n);
	}

	public static void main(String[] args) {
		new Examples();
	}

}

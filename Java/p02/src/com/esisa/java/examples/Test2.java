package com.esisa.java.examples;

import com.esisa.java.modifiers.Visibility;

public class Test2 {
	public static void main(String[] args) {
		Visibility v1 = new Visibility();
		//v1.p2++; erreur
		v1.p4++;
		System.out.println(v1);
	}
}

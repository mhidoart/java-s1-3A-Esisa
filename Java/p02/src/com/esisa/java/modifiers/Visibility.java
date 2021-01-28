package com.esisa.java.modifiers;

public class Visibility {
	private int p1;
	int p2; // default public || public par défaut || niveau package
	protected int p3;
	public int p4;
	
	public Visibility() {
		p1 = 10;
		p2 = 20;
		p3 = 30;
		p4 = 40;
	}

	public String toString() {
		return "Visibility [p1=" + p1 + ", p2=" + p2 + ", p3=" + p3 + ", p4=" + p4 + "]";
	}
}

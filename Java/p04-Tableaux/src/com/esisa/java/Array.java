package com.esisa.java;

public class Array {
	private int values[];
	
	public Array() {
		values = new int[0];
	}

	public void add(int element) {
		// 1. Cr�ation d'un nouveau tableau de taille suffisante :
		int tmp[] = new int[values.length + 1];
		// 2. Copie des �lements du premier tableau dans le deuxi�me :
		for (int i = 0; i < values.length; i++) {
			tmp[i] = values[i];
		}
		// 3. Placer element � la fin du tableau :
		tmp[values.length] = element;
		// 4. Pointer le deuxi�me tableau par le premier :
		values = tmp;
	}
	
	public int size() {
		return values.length;
	}
	
	public int get(int index) {
		return values[index];
	}
	
	public void insert(int element, int index) {
		
	}
	
	public String toString() {
		return "";
	}
}

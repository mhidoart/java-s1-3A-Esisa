package com.esisa.java;
// Tableaux :
public class Examples {

	public Examples() {
		exp10();
	}
// 1. Tableaux d'éléments de type primitf	
	public void exp01() {
		// 1.1 Par initialisation
		int t1[] = {32, 15, 20, 40, 12};
		sort(t1);
		print(t1);
	}
	
	public void print(int t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
	
	public void sort(int t[]) {
		for (int i = 0; i < t.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < t.length; j++) {
				if (t[j] < t[min]) min = j;
			}
			int tmp = t[i];
			t[i] = t[min];
			t[min] = tmp;
		}
	}
	
	public void exp02() {
		// 1.2 Par instanciation :
		int t1[], n = 5;
		t1 = new int[n];
		// Remplir le tableau avec des entiers aléatoires entre 100 et 999 
		for (int i = 0; i < t1.length; i++) {
			t1[i] = 100 + (int)(Math.random() * 900);
		}
		sort(t1);
		print(t1);
	}
	
	public void exp03() {
		// 1.3 Par instanciation et initialisation;
		int t1[];
		t1 = new int[] {20, 14, 56, 19, 30};
		sort(t1);
		print(t1);
		
	}
	
	public void exp04() {
		Array t1 = new Array();
		t1.add(20);
		t1.add(30);
		t1.add(40);
		
		for (int i = 0; i < t1.size(); i++) {
			System.out.println(t1.get(i));
		}
	}
// Tableaux d'objets :	
	public void exp05() {
		Point p1 = new Point(10, 20);
		Point t1[] = {p1, new Point(10, 15), new Point(11, 12)};
		for (int i = 0; i < t1.length; i++) {
			System.out.println(t1[i]);
		}
	}
	
	public void exp06() {
		Point t1[] = new Point[10];
		// Création :
		for (int i = 0; i < t1.length; i++) {
			t1[i] = new Point((int)(Math.random() * 100), (int)(Math.random() * 100));
		}
		// Affichage :
		for (int i = 0; i < t1.length; i++) {
			System.out.println(t1[i]);
		}
	}
	
	public void exp07() {
		Point t1[];
		t1 = new Point[] {new Point(10, 30), new Point(12, 20), new Point(40, 23)};
		
		//print(t1);
		/*-------------------------------------*/
		Point t2[] = t1;
		t2[0] = new Point(100, 100);
		//print(t1);
		
		/*-------------------------------------*/
		Point t3[] = new Point[t1.length];
		for (int i = 0; i < t3.length; i++) {
			t3[i] = t1[i];
		}
		t3[0] = new Point(200, 200);
		//print(t1);
		t3[1].setX(1000);
		print(t1);
		/*-------------------------------------*/
		t3 = null;
		Point t4[] = new Point[t1.length];
		for (int i = 0; i < t4.length; i++) {
			t4[i] = new Point(t1[i]);
		}
		
	}
	// Surcharge = Surdéfinition de la méthode print()
	public void print(Point t[]) {
		for (int i = 0; i < t.length; i++) {
			System.out.println(t[i]);
		}
	}
// Matrices :	
	void exp08() {
		int m[][] = {
			{30, 12, 24, 15},
			{19, 45},
			{20, 35, 43}
		};
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + " - ");
			}
			System.out.println();
		}
	}
	
	void exp09() {
		int m[][];
		m = new int[5][10];
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				m[i][j] = i * j;
			}
		}
		for (int i = 1; i < m.length; i++) {
			for (int j = 1; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}
	}
	
	void exp10() {
		int m[][];
		m = new int[3][];
		m[0] = new int[3];
		m[1] = new int[] {10, 20, 30, 40};
		m[2] = new int[2];
		
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				System.out.print(m[i][j] + "\t");
			}
			System.out.println();
		}		
	}

	public static void main(String[] args) {
		new Examples();
	}

}

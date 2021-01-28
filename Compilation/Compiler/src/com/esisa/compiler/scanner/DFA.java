package com.esisa.compiler.scanner;

public class DFA {
	private String name;
	private int T[][];
	private boolean A[];
	
	public DFA(String name, int statesCount, int ...accepting) {
		this.name = name;
		T = new int[statesCount][256];
		for (int e = 0; e < T.length; e++) {
			for (int c = 0; c < 256; c++) {
				T[e][c] = -1;
			}
		}
		
		A = new boolean[statesCount];
		for (int e = 0; e < A.length; e++) {
			A[e] = false;
		}
		for (int i = 0; i < accepting.length; i++) {
			int e = accepting[i];
			A[e] = true;
		}
	}
	
	public void add(int e1, int e2, int s) {
		T[e1][s] = e2;
	}
	
	public void add(int e1, int e2, int min, int max) {
		for (int s = min; s <= max; s++) {
			T[e1][s] = e2;
		}
	}
	
	public void add(int e1, int e2, String set) {
		for (int i = 0; i < set.length(); i++) {
			T[e1][set.charAt(i)] = e2;
		}
	}
	
	public int get(int e, int s) {
		return T[e][s];
	}
	
	public boolean isAccepting(int e) {
		return A[e];
	}
	
	public Token extract(InputTape inputTape) {
		int e = 0;
		inputTape.mark();
		char s = inputTape.current();
		while (T[e][s] != -1) { // Tant qu'il y a une transition
			// on transite
			e = T[e][s];
			s = inputTape.next();
		}
		if (isAccepting(e)) {
			String value = inputTape.getToken();
			Token t = new Token(value, name);
			return t;
		}
		inputTape.reset();
		return null;
	}
}

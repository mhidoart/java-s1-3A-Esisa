package com.esisa.compiler.parser;

public class Dec extends Parser {
	private Lid L;
	
	public Dec() {
	}
	
	public Dec(Lid L) {
		super(L.getScanner());
		this.L = L;
	}

	public boolean axiom() {
		if (next("type")) {
			if (next("id")) {
				if (L.parse(getInputTape())) {
					setToken(L.getToken());
					return is(";");
				}
				setToken(L.getToken());
			}
		}
		return false;
	}

}

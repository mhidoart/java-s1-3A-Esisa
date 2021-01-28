package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Separator extends DFA {

	public Separator() {
		this("separator");
	}

	public Separator(String name) {
		super(name, 2, 1);
		add(0, 1, ",;{}[]().");
	}
}

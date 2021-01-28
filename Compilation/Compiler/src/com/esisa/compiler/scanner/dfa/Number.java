package com.esisa.compiler.scanner.dfa;

import com.esisa.compiler.scanner.DFA;

public class Number extends DFA {

	public Number() {
		this("nb");
	}

	public Number(String name) {
		super(name, 4, 3, 1);
		add(0, 1, '0', '9');
		add(0, 2, '.');
		add(1, 1, '0', '9');
		add(1, 3, '.');
		add(2, 3, '0', '9');
		add(3, 3, '0', '9');
	}

}

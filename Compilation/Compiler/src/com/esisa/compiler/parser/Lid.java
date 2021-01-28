package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;

public class Lid extends Parser {

	public Lid() {
	}

	public Lid(Scanner scanner) {
		super(scanner);
	}

	public boolean axiom() {
		if (next(",")) {
			if (next("id")) {
				return axiom();
			}
			return false;
		}
		// Cas Epsilon :
		undo();
		return true;
	}
}

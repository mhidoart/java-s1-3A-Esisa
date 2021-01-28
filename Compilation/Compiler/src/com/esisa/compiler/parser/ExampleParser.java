package com.esisa.compiler.parser;

import com.esisa.compiler.scanner.Scanner;

/*
 * Dec	-> 	type id Lid ;
 * Lid	->	, id Lid | eps
 * 
 */
public class ExampleParser extends Parser {

	public ExampleParser() {
		super();
	}

	public ExampleParser(Scanner scanner) {
		super(scanner);
	}

	public boolean axiom() {
		return Dec();
	}
	
	private boolean Dec() {
		if (next("type")) {
			if (next("id")) {
				if (Lid()) {
					return next(";");
				}
			}
		}
		return false;
	}
	
	private boolean Lid() {
		if (next(",")) {
			if (next("id")) {
				return Lid();
			}
			return false;
		}
		// Cas Epsilon :
		undo();
		return true;
	}
}

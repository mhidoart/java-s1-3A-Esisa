package com.esisa.compiler.scanner;

public enum ErrorType {
	LEXICAL("Erreur Lexicale"), 
	SYNTACTIC("Erreur Syntaxique"), 
	SEMANTIC("Erreur Sémantque");
	
	private String name;
	
	private ErrorType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

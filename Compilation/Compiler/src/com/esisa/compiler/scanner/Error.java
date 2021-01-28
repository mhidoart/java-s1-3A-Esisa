package com.esisa.compiler.scanner;

public class Error {
	private int id;
	private ErrorType type;
	private Object symbol;
	private int position;
	
	public Error() {
	}

	public Error(int id, ErrorType type, Object symbol, int position) {
		super();
		this.id = id;
		this.type = type;
		this.symbol = symbol;
		this.position = position;
	}

	public String getMessage() {
		String message = type.getName() + " N° " + id 
				+ " sur le symbole : '" + symbol + "' à la position : " + position;
		return message;
	}
}

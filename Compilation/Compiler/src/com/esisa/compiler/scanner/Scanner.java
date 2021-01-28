package com.esisa.compiler.scanner;

import java.util.Vector;

import com.esisa.compiler.scanner.dfa.Assign;
import com.esisa.compiler.scanner.dfa.Blank;
import com.esisa.compiler.scanner.dfa.Identifier;
import com.esisa.compiler.scanner.dfa.LitteralString;
import com.esisa.compiler.scanner.dfa.Number;
import com.esisa.compiler.scanner.dfa.Operator;
import com.esisa.compiler.scanner.dfa.Oprel;
import com.esisa.compiler.scanner.dfa.Separator;

public class Scanner {
	public static final Token EOF = new Token("$", "$");
	
	private Vector<DFA> A;
	private Vector<Token> tokenList;
	private Vector<Error> errorList;
	private Error error;
	private Vector<ReservedWords> reservedWords;
	
	public Scanner() {
		A = new Vector<>();
		tokenList = new Vector<>();
		errorList = new Vector<>();
		reservedWords = new Vector<>();
		
		add(new Identifier());
		add(new Number());
		add(new Oprel());
		add(new LitteralString());
		add(new Blank());
		add(new Separator());
		add(new Operator());
		add(new Assign());
		
		addReservedWords("type", "byte", "short", "int", "float", "double", "char", "boolean");
		addReservedWords("modifiers", "private", "public", "protected", "static", "final", "synchronized");
	}
	
	public void add(DFA a) {
		A.add(a);
	}
	
	public void addReservedWords(ReservedWords list) {
		this.reservedWords.add(list);
	}
	
	public void addReservedWords(String name, String ...words) {
		this.reservedWords.add(new ReservedWords(name, words));
	}
	
	public void scanReservedWord(Token token) {
		for (ReservedWords rw : reservedWords) {
			if (rw.contains(token.getValue())) {
				token.setLexicalUnit(rw.getName());
			}
		}
	}

	public Token next(InputTape inputTape) { // Ruban d'entrée
		if (inputTape.eof()) {
			return EOF;
		}
		for (DFA a : A) {
			Token t = a.extract(inputTape);
			if (t != null) {
				if (t.getLexicalUnit().equals("blank")) {
					if ((!inputTape.eof())) {
						return next(inputTape);
					}
					else {
						return null;
					}
				}
				else {
					if (t.getLexicalUnit().equals("id")) {
						scanReservedWord(t);
					}
					tokenList.add(t);
					return t;
				}
			}
		}
		error = new Error(errorList.size() + 1, ErrorType.LEXICAL, inputTape.current(), inputTape.getReadHead());
		errorList.add(error);
		inputTape.next();
		return null;
	}
	
	public void scan(InputTape inputTape) {
		errorList.clear();
		tokenList.clear();
		while (!inputTape.eof()) next(inputTape);
	}
	
	public void scan(String text) {
		scan(new InputTape(text));
	}
	
	public Error getError() {
		return error;
	}
	
	public Vector<Error> getErrorList() {
		return errorList;
	}
	
	public Vector<Token> getTokenList() {
		return tokenList;
	}
}

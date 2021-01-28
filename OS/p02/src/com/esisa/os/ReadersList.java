package com.esisa.os;

public class ReadersList extends ThreadList {
	
	public ReadersList(Buffer buffer) {
		super("File d'attente des Lecteurs", buffer);
	}
	
	public ReadersList(String name, Buffer buffer) {
		super(name, buffer);
	}

	public void newReader() {
		newReader("R" + (size() + 1));
	}

	public void newReader(String name) {
		Reader reader = new Reader(name, getBuffer());
		add(reader);
	}
}

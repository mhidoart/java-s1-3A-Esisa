package com.esisa.os;

public class WritersList extends ThreadList {
	
	public WritersList(Buffer buffer) {
		super("File d'attente des Redacteurs", buffer);
	}
	
	public WritersList(String name, Buffer buffer) {
		super(name, buffer);
	}

	public void newWriter() {
		newWriter("W" + (size() + 1));
	}

	public void newWriter(String name) {
		Writer writer = new Writer(name, getBuffer());
		add(writer);
	}
}

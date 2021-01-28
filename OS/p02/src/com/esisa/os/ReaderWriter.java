package com.esisa.os;

public class ReaderWriter {

	public ReaderWriter() {
		exp02();
	}
	
	void exp01() {
		Buffer buffer = new Buffer(10);
		
		Writer w[] = new Writer[3];
		for (int i = 0; i < w.length; i++) {
			w[i] = new Writer("W" + i, buffer);
			w[i].start();
		}
	}
	
	void exp02() {
		// Ressource partagée
		Buffer buffer = new Buffer(10);
		
		Writer w[] = new Writer[1];
		for (int i = 0; i < w.length; i++) {
			w[i] = new Writer("W" + i, buffer);
			w[i].start();
		}
		
		Reader r[] = new Reader[3];
		for (int i = 0; i < r.length; i++) {
			r[i] = new Reader("R" + i, buffer);
			r[i].start();
		}
	}

	public static void main(String[] args) {
		new ReaderWriter();
	}
}

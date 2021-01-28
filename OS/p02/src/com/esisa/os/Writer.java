package com.esisa.os;

public class Writer extends Thread {
	private Buffer buffer;
	
	public Writer(String name, Buffer buffer) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		do {
			int data = (int)(Math.random() * 900 + 100);
			buffer.write(data);
		}
		while (true);
	}

	public String toString() {
		return getName();
	}
}

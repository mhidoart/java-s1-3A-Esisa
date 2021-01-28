package com.esisa.os;

public class Reader extends Thread {
	private Buffer buffer;
	
	public Reader(String name, Buffer buffer) {
		super(name);
		this.buffer = buffer;
	}

	public void run() {
		do {
			int info = buffer.read();
			System.out.println(Thread.currentThread() + " a lu : " + info);
		}
		while (true);
	}
	public String toString() {
		return getName();
	}
}

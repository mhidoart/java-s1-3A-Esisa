package com.esisa.os;

public class Processus extends Thread {
	public Processus(String name) {
		super(name);
	}

	public void run() {
		do {
			System.out.println(Thread.currentThread().getName());
			pause(100);
		} 
		while (true);
	}
	
	public static void pause(long time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {}
	}
}

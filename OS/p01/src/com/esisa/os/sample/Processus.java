package com.esisa.os.sample;

public class Processus implements Runnable { // Comportement du processus
	private Thread runner;
	
	public Processus(String name) {
		runner = new Thread(this, name);
	}
	
	public void start() {
		runner.start();
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

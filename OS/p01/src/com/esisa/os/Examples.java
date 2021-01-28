package com.esisa.os;

public class Examples {
	public Examples() {
		exp02();
	}
	
	void exp01() {
		Thread p1 = new Thread();
		p1.start();
	}
	
	void exp02() {
		Processus p1 = new Processus("P01");
		Processus p2 = new Processus("P02");
		
		p1.start();
		p2.start();
		do {
			System.out.println(Thread.currentThread().getName());
			Processus.pause(100);
		} 
		while (true);
	}
	
	public static void main(String[] args) {
		new Examples();
	}
}

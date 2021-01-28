package com.esisa.os.sample;

public class Test {

	public Test() {
		exp01();
	}
	
	void exp01() {
		Processus p1 = new Processus("P01");
		Processus p2 = new Processus("P02");

		p1.start();
		p2.start();
	}

	public static void main(String[] args) {
		new Test();
	}

}

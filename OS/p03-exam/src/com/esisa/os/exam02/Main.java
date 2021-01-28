package com.esisa.os.exam02;

import javax.swing.JFrame;

public class Main extends JFrame {

	public Main() {
		ScreenBuffer buffer = new ScreenBuffer(100);
		ScreenBufferPanel screen = new ScreenBufferPanel(buffer);
		IconGenerator generator = new IconGenerator(buffer);
		getContentPane().add("Center", screen);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
		generator.start();
	}

	public static void main(String[] args) {
		new Main();
	}

}

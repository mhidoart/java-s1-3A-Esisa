package com.esisa.os.exam02;

public class IconGenerator extends Thread {
	private ScreenBuffer screenBuffer;

	public IconGenerator(ScreenBuffer screenBuffer) {
		super();
		this.screenBuffer = screenBuffer;
	}

	public void run() {
		do {
			screenBuffer.createIcon((int)(Math.random() * 4));
			try {
				Thread.sleep(1000);
			} catch (Exception e) {
				// TODO: handle exception
			}
		}
		while (true);
	}
}

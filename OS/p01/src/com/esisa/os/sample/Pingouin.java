package com.esisa.os.sample;

import java.awt.Graphics;
import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class Pingouin extends JPanel implements Runnable {
	private static int counter = 0;
	private Thread runner;
	
	private String source[] = {
		"stop", "right1", "right2", "right3", "left1", "left2", "left3"	
	};
	private String path = "resources/seq/";
	private String ext = ".gif";
	private Image film[];
	private int current = 0;
	private int x = 300, y = 100;
	private int size = 30;
	private int step = 3;
	
	public Pingouin() {
		this("P" + (counter + 1));
	}
	
	public Pingouin(String name) {
		runner = new Thread(this, name);
		
		loadImages();
		counter++;
		y = size * counter + 20;
		setLocation(x, y);
		setSize(size, size);
	}
	
	public void loadImages() {
		film = new Image[source.length];
		for (int i = 0; i < film.length; i++) {
			ImageIcon icon = new ImageIcon(path + source[i] + ext);
			film[i] = icon.getImage();
		}
	}
	
	public void start() {
		runner.start();
	}

	public void run() {
		do {
			double decision = Math.random() * 100;
			if (decision < 45) {
				goRight(3);
			}
			else if (decision < 90) {
				goLeft(3);
			}
			else {
				stop();
			}
		} 
		while (true);
	}
	
	public void goRight(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 1; i <= 3; i++) {
				current = i;
				x = x + step;
				setLocation(x, y);
				repaint();
				pause(100);
			}
		}
	}
	
	public void goLeft(int n) {
		for (int j = 0; j < n; j++) {
			for (int i = 4; i <= 6; i++) {
				current = i;
				x = x - step;
				setLocation(x, y);
				repaint();
				pause(100);
			}
		}
	}
	
	public void stop() {
		current = 0;
		repaint();
		pause((int)(Math.random() * 3000 + 1000));
	}
	
	public static void pause(long time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {}
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawImage(film[current], 0, 0, null);
	}
}

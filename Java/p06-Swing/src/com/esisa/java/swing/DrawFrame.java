package com.esisa.java.swing;

import java.awt.Point;
import java.util.Vector;

import javax.swing.JFrame;

import com.esisa.java.swing.listeners.MouseDrawPanel;

public class DrawFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public DrawFrame() {
		exp03();
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}
	
	void exp01() {
		DrawPanel p1 = new DrawPanel();
		setContentPane(p1);
		
		Vector<Point> v = new Vector<>();
		for (int x = 0; x < 100; x++) {
			int y = (int)(Math.random() * 200 - 100);
			v.add(new Point(x * 10, y));
		}
		p1.setShape(v);
	}
	
	void exp02() {
		DrawPanel p1 = new DrawPanel();
		setContentPane(p1);
		
		Vector<Point> v = new Vector<>();
		for (int x = 0; x < 1000; x++) {
			int y = (int)(Math.cos(x / 20.) * 200);
			v.add(new Point(x, y));
		}
		p1.setShape(v);
	}
	
	void exp03() {
		MouseDrawPanel p1 = new MouseDrawPanel();
		setContentPane(p1);
	}
	
	public static void main(String[] args) {
		new DrawFrame();
	}

}

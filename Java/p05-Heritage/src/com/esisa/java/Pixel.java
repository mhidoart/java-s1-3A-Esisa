package com.esisa.java;

import java.awt.Color;

import javax.swing.JOptionPane;

public class Pixel extends Point {
	private Color color;
	
	public Pixel() {
		this(0, 0);
	}

	public Pixel(int x, int y) {
		super(x, y);
	}

	public Pixel(int x, int y, Color color) {
		super(x, y);
		this.color = color;
	}

	public Color getColor() {
		return color;
	}

	public void setColor(Color color) {
		this.color = color;
	}
	
	public void print() {
		JOptionPane.showMessageDialog(null, "(" + getX() + ", " + getY() + ", " + color + ")");
	}
	
	public boolean equals(Object obj) {
		if (obj instanceof Pixel) {
			Pixel p = (Pixel)obj;
			return (p.getX() == getX() && p.getY() == getY() && color.equals(p.color));
		}
		return false;
	}
}

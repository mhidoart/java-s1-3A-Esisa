package com.esisa.java.swing;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.util.Vector;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

public class DrawPanel extends JPanel {
	private Vector<Point> shape;
	private int y0 = 0;
	
	public DrawPanel() {
		shape = new Vector<>();
		setBackground(Color.white);
		setBorder(BorderFactory.createLineBorder(Color.black));
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawXAxis(g);
		
		//exp01(g);
		g.setColor(Color.blue);
		for (int i = 1; i < shape.size(); i++) {
			g.drawLine(
				shape.get(i-1).x, y0 - shape.get(i-1).y, 
				shape.get(i).x, y0 - shape.get(i).y
			);
		}
	}
	
	public void drawXAxis(Graphics g) {
		y0 = getHeight() / 2;
		g.setColor(Color.red);
		g.drawLine(0, y0, getWidth(), y0);
	}
	
	public void setShape(Vector<Point> shape) {
		this.shape = shape;
		repaint();
	}
	
	public void add(int x, int y) {
		shape.add(new Point(x, y));
		repaint();
	}

	void exp01(Graphics g) {
		g.setColor(Color.blue);
		g.drawLine(0, 0, 100, 100);
		
		g.setColor(Color.gray);
		g.drawRect(100, 100, 200, 50);
		
		g.setColor(Color.red);
		g.drawOval(100, 100, 200, 50);
		
		g.fillOval(150, 50, 100, 40);
		
		System.out.println("paintComponent()");
	}
}

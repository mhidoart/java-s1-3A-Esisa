package com.esisa.java.swing.listeners;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.Vector;

import javax.swing.JPanel;

public class MouseDrawPanel extends JPanel implements MouseListener, MouseMotionListener {
	private Vector<Point> circles;
	private Vector<Vector<Point>> shape;
	private int ray = 30;
	private Vector<Point> next;
	
	public MouseDrawPanel() {
		circles = new Vector<>();
		shape = new Vector<>();
		setBackground(Color.BLUE);
		addMouseListener(this);
		addMouseMotionListener(this);
		setCursor(new Cursor(Cursor.HAND_CURSOR));
	}

	public void mouseClicked(MouseEvent e) {
		System.out.println("(" + e.getX() + ", " + e.getY() + ")");
		if (e.getButton() == MouseEvent.BUTTON1) {
			circles.add(new Point(e.getX(), e.getY()));
			repaint();
		}
	}

	public void mousePressed(MouseEvent e) {
		if (e.getButton() == MouseEvent.BUTTON1) {
			next = new Vector<>();
			shape.add(next);
		}
		System.out.println(">> pressed");
	}

	public void mouseReleased(MouseEvent e) {
		//	System.out.println(">> released");
	}

	public void mouseEntered(MouseEvent e) {
		
	}

	public void mouseExited(MouseEvent e) {
		
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
			
		g.setColor(Color.yellow);
		int d = ray * 2;
		for (Point p : circles) {
			g.drawOval(p.x - ray, p.y - ray, d, d);
		}
		
		for (Vector<Point> v : shape) {
			for (int i = 1; i < v.size(); i++) {
				g.drawLine(v.get(i-1).x, v.get(i-1).y, v.get(i).x, v.get(i).y);
			}
		}
		
	}

	public void mouseDragged(MouseEvent e) {
		next.add(new Point(e.getX(), e.getY()));
		repaint();
	}

	public void mouseMoved(MouseEvent e) {
		//System.out.println("moved");
	}
}

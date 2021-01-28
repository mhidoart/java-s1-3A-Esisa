package com.esisa.os.exam02;

import java.awt.Point;
import java.awt.Rectangle;
import java.util.Vector;

import javax.swing.JPanel;

public class ScreenBuffer {
	public static final int ICON1 = 0;
	public static final int ICON2 = 1;
	public static final int ICON3 = 2;
	public static final int ICON4 = 3;
	
	private JPanel linkedPanel;
	private Vector<Point> icons[];
	private Rectangle screen[];
	private int w, h, margin;
	
	@SuppressWarnings("unchecked")
	public ScreenBuffer(int margin) {
		this.margin = margin;
		icons = new Vector[4];
		for (int i = 0; i < icons.length; i++) {
			icons[i] = new Vector<Point>();
		}
	}

	public JPanel getLinkedPanel() {
		return linkedPanel;
	}

	public void setLinkedPanel(JPanel linkedPanel) {
		this.linkedPanel = linkedPanel;
	}

	synchronized public void createIcon(int type) {
		w = linkedPanel.getWidth() / 2;
		h =  linkedPanel.getHeight() / 2;
		screen = new Rectangle[] {
			new Rectangle(0, 0, w, h),
			new Rectangle(w, 0, w, h),
			new Rectangle(0, h, w, h),
			new Rectangle(w, h, w, h)
		};

		Rectangle r = screen[type];
		int x = r.x + margin + (int)(Math.random() * (w - 2 * margin));
		int y = r.y + margin + (int)(Math.random() * (h - 2 * margin));
		icons[type].add(new Point(x, y));
		linkedPanel.repaint();
	}
	
	public Vector<Point>[] getIcons() {
		return icons;
	}
	
}

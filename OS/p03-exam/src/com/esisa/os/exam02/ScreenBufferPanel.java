package com.esisa.os.exam02;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JPanel;

public class ScreenBufferPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private ScreenBuffer screenBuffer;
	private Image icon[];

	public ScreenBufferPanel() {
		String path = "resources/icons/";
		String src[] = {"e01.png", "e05.png", "e08.jpg", "e29.jpg"};
		icon = new Image[4];
		for (int i = 0; i < icon.length; i++) {
			icon[i] = new ImageIcon(path + src[i]).getImage();
		}
	}

	public ScreenBufferPanel(ScreenBuffer screenBuffer) {
		this();
		setScreenBuffer(screenBuffer);
	}

	public ScreenBuffer getScreenBuffer() {
		return screenBuffer;
	}

	public void setScreenBuffer(ScreenBuffer screenBuffer) {
		this.screenBuffer = screenBuffer;
		screenBuffer.setLinkedPanel(this);
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		Vector<Point> icons[] = screenBuffer.getIcons();
		for (int i = 0; i < icons.length; i++) {
			for (Point p : icons[i]) {
				g.drawImage(icon[i], p.x, p.y, null);
			}
		}
	}
}

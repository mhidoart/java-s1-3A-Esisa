package com.esisa.os.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JPanel;

import com.esisa.os.WaitingThreadList;

public class WaitingThreadListPanel extends JPanel {
	private WaitingThreadList list;
	private int width;
	private int max;
	private int margin = 20;

	public WaitingThreadListPanel(int width, int max) {
		this.width = width;
		this.max = max;
	}

	public void setWaitingThreadList(WaitingThreadList list) {
		this.list = list;
		list.setListComponent(this);
	}
	
	public WaitingThreadList getWaitingThreadList() {
		return list;
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		// Ecriture du titre :
		g.setColor(Color.blue);
		g.drawString(list.getName() + " : ", 5, margin - 5);
		
		// Dessin de la file d'attente :
		g.setColor(Color.white);
		g.fillRect(0, margin, width * max, width);
		
		g.setColor(Color.blue);
		g.drawLine(0, margin, width * max, margin);
		g.drawLine(0, margin + width - 1, width * max, margin + width - 1);
		
		// Ecriture des processus en attente :
		for (int i = 0; i < list.size(); i++) {
			g.setColor(Color.yellow);
			g.fillOval(i * width + 2, margin + 2, width - 4, width - 5);
			g.setColor(Color.blue);
			g.drawOval(i * width + 2, margin + 2, width - 4, width - 5);
			
			g.drawString(list.thread(i).getName(), i * width + 7, margin + width / 2);
		}
	}

	public Dimension getPreferredSize() {
		return new Dimension(width * max, margin + width);
	}
}

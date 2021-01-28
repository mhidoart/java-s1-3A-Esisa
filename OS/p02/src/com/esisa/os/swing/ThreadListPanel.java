package com.esisa.os.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.esisa.os.ThreadList;

public class ThreadListPanel extends JPanel {
	private ThreadList threadList;
	private int width;
	private int margin = 20;

	public ThreadListPanel(ThreadList threadList, int width) {
		setThreadList(threadList);
		this.width = width;
		setBackground(Color.white);
		setBorder(BorderFactory.createEtchedBorder());
	}

	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		
		g.drawString(threadList.getName(), 5, 15);
		
		g.setColor(Color.white);
		g.fillRect(0, margin, getWidth(), width - 1);	
		g.setColor(Color.blue);
		g.drawRect(2, margin, getWidth() - 5, width - 5);
		
		for (int i = 0; i < threadList.size(); i++) {
			g.setColor(Color.yellow);
			g.fillRect(i * width + 2, margin + 2, width - 4, width - 5);
			g.setColor(Color.blue);
			g.drawRect(i * width + 2, margin + 2, width - 4, width - 5);
			
			g.drawString(threadList.get(i).getName(), i * width + 7, margin + width / 2);
		}
	}
	
	public void setThreadList(ThreadList threadList) {
		this.threadList = threadList;
		threadList.setLinkedComponent(this);
	}

	public Dimension getPreferredSize() {
		int max = 10;
		if (max < threadList.size()) max = threadList.size();
		return new Dimension(width * max, margin + width);
	}
}

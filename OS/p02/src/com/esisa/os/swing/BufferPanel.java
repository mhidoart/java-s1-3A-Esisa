package com.esisa.os.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import com.esisa.os.Buffer;

public class BufferPanel extends JPanel {
	private Buffer buffer;
	private int width;// largeur d'une cellule
	private int bufferWidth;
	private int margin = 50;
	
	public BufferPanel(int width) {
		this.width = width;
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
		this.bufferWidth = width * buffer.size();
		
		setBorder(BorderFactory.createLineBorder(new Color(45, 165, 132)));
		repaint();
		
		buffer.setBufferComponent(this);
	}
	
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		// Dessin du Buffer
		int leftMargin = (getWidth() - bufferWidth) / 2;
		g.setColor(Color.white);
		g.fillRect(leftMargin, margin, bufferWidth - 1, width - 1);
		
		g.setColor(Color.blue);
		g.drawRect(leftMargin, margin, bufferWidth - 1, width - 1);
		
		for (int i = 1; i < buffer.size(); i++) {
			g.drawLine(leftMargin + width * i, margin, leftMargin + width * i, margin + width - 1);
		}
		
		// Ecriture du contenu
		g.setColor(Color.blue);
		for (int i = 0; i < buffer.size(); i++) {
			if (buffer.getData(i) != -1) {
				int x = leftMargin + width * i + 5;
				int y = margin + width / 2;
				g.drawString("" + buffer.getData(i), x, y);
			}
		}
		
		// Current Writer :
		if (buffer.getCurrentWriter() != null) {
			g.setColor(Color.red);
			int x = leftMargin + width * buffer.getWritePosition() + 5;
			int y = margin - 15;
			g.drawString(buffer.getCurrentWriter().getName(), x, y);
			
			g.fillOval(x, y + 2, 10, 10);
		}
		
		// Current Reader :
		if (buffer.getCurrentReader() != null) {
			g.setColor(Color.blue);
			int x = leftMargin + width * buffer.getReadPosition() + 5;
			int y = margin + width + 2;
			String text = buffer.getCurrentReader().getName() + "(" + buffer.getReadData() + ")";
			g.drawString(text, x, y + 22);
			
			g.fillOval(x, y, 10, 10);
		}
		
	}

	public Dimension getPreferredSize() {
		return new Dimension(bufferWidth + 2 * margin, width + 2 * margin);
	}

}

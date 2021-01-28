package com.esisa.java.swing.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class AlphaListener implements KeyListener {
	public void keyTyped(KeyEvent e) {
		if (
				(e.getKeyChar() < 'a' || e.getKeyChar() > 'z') && 
				(e.getKeyChar() < 'A' || e.getKeyChar() > 'Z')
		) {
			e.setKeyChar('\0');
		}
	}
	public void keyPressed(KeyEvent e) {}
	public void keyReleased(KeyEvent e) {}
}

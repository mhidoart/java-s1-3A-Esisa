package com.esisa.java.swing.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class ToUpperListener extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() >= 'a' && e.getKeyChar() <= 'z') {
			e.setKeyChar((char)(e.getKeyChar() - 'a' + 'A'));
		}
	}
}

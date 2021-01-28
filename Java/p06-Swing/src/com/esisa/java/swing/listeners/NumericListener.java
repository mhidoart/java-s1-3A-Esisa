package com.esisa.java.swing.listeners;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class NumericListener extends KeyAdapter {
	public void keyTyped(KeyEvent e) {
		if (e.getKeyChar() < '0' || e.getKeyChar() > '9') {
			e.setKeyChar('\0');
		}
	}
}

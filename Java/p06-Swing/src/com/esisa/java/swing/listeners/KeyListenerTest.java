package com.esisa.java.swing.listeners;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyListenerTest implements KeyListener {

	public void keyTyped(KeyEvent e) {
		System.out.println("keyTyped() : " + e.getKeyChar() + " , " + e.getKeyCode());
	}

	public void keyPressed(KeyEvent e) {
		System.out.println("keyPressed() : " + e.getKeyChar() + " , " + e.getKeyCode());
	}

	public void keyReleased(KeyEvent e) {
		System.out.println("keyReleased() : " + e.getKeyChar() + " , " + e.getKeyCode());
	}

}

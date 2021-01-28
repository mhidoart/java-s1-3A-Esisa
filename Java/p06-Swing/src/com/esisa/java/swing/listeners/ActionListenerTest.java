package com.esisa.java.swing.listeners;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;

public class ActionListenerTest implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		JButton b1 = (JButton)e.getSource();
		System.out.println(b1.getText());
	}
}

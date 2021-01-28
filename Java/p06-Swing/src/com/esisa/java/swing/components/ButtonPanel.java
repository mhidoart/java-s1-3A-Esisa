package com.esisa.java.swing.components;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public ButtonPanel(String ...labels) {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		
		for (int i = 0; i < labels.length; i++) {
			JButton b1 = new JButton(labels[i]);
			add(b1);
		}
	}
	
	public JButton getButton(int index) {
		return (JButton)getComponent(index);
	}
	
	public int length() {
		return getComponentCount();
	}
	
	public void addActionListener(ActionListener a) {
		for (int i = 0; i < length(); i++) {
			getButton(i).addActionListener(a);
		}
	}
	
	public void addActionListener(int index, ActionListener a) {
		getButton(index).addActionListener(a);
	}
}

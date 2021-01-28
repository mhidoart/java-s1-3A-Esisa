package com.esisa.os.swing;

import java.awt.FlowLayout;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class ButtonPanel extends JPanel {

	public ButtonPanel(String ...labels) {
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		for (int i = 0; i < labels.length; i++) {
			JButton b = new JButton(labels[i]);
			b.setName(labels[i]);
			add(b);
		}
	}

	public void addActionListener(ActionListener listener) {
		for (int i = 0; i < getComponentCount(); i++) {
			((JButton)getComponent(i)).addActionListener(listener);
			
		}
	}
}

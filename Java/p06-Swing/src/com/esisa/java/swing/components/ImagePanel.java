package com.esisa.java.swing.components;

import java.awt.FlowLayout;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;

public class ImagePanel extends JLayeredPane {
	private JPanel front;
	private JLabel back;
	
	public ImagePanel(String image) {
		back = new JLabel(new ImageIcon(image));
		front = new JPanel();
		
		front.setLayout(new FlowLayout());
		front.setOpaque(false);
		
		add(front);
		add(back);
		
		front.setBounds(0, 0, 200, 300);
		back.setBounds(0, 0, 200, 300);
		
		front.add(new JButton("JLayeredPane"));
	}

}

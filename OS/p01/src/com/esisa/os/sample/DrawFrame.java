package com.esisa.os.sample;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawFrame extends JFrame implements ActionListener {
	private JPanel screen;
	
	public DrawFrame() {
		screen = new JPanel();
		screen.setLayout(null);
		screen.setBackground(Color.BLACK);
		
		getContentPane().add("Center", screen);
		
		JButton b1 = new JButton("Nouveau Pingouin");
		getContentPane().add("South", b1);
		b1.addActionListener(this);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setExtendedState(MAXIMIZED_BOTH);
		setVisible(true);
	}

	public static void main(String[] args) {
		new DrawFrame();
	}

	public void actionPerformed(ActionEvent e) {
		Pingouin p = new Pingouin();
		screen.add(p);
		p.start();
	}
}

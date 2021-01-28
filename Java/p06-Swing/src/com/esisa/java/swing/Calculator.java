package com.esisa.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculator extends JPanel implements ActionListener {
	private JLabel screen;
	private JPanel container;
	private double value = 0;
	private String operator = "+";
	private double result = 0;
	
	public Calculator() {
		setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
		container = new JPanel(new BorderLayout(0, 10));
		add(container);
		createScreen();
		createButtons();
	}
	
	private void createScreen() {
		screen = new JLabel("" + value);
		container.add("North", screen);
		screen.setFont(new Font("Consolas", Font.PLAIN, 32));
		screen.setHorizontalAlignment(JLabel.RIGHT);
		screen.setBorder(BorderFactory.createLoweredBevelBorder());
		screen.setBackground(new Color(220, 220, 240));
		screen.setOpaque(true);
	}
	
	private void createButtons() {
		String m[][] = {
			{"7", "8", "9", "+"},
			{"4", "5", "6", "-"},
			{"1", "2", "3", "*"},
			{"0", ",", "=", "/"}
		};
		
		JPanel p1 = new JPanel(new GridLayout(4, 4, 2, 2));
		container.add("Center", p1);
		for (int i = 0; i < m.length; i++) {
			for (int j = 0; j < m[i].length; j++) {
				createButton(m[i][j], p1);
			}
		}
	}
	
	private void createButton(String label, JPanel p) {
		JButton b1 = new JButton(label);
		p.add(b1);
		b1.setFocusable(false);
		b1.setFont(new Font("Consolas", Font.PLAIN, 18));
		
		b1.addActionListener(this);
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		System.out.println("Click sur : " + src.getText());
		try {
			int d = Integer.parseInt(src.getText());
			insert(d);
		}
		catch (Exception ex) {
			operation(src.getText());
		}
	}

	private void insert(int d) {
		value = value * 10 + d;
		screen.setText("" + value);
	}
	
	private void operation(String op) {
		switch (operator) {
		case "+":
			result = result + value;
			break;
		case "-":
			result = result - value;
			break;
		case "*":
			result = result * value;
			break;
		case "/":
			result = result / value;
			break;

		default:
			break;
		}
		screen.setText("" + result);
		value = 0;
		operator = op;
	}
}

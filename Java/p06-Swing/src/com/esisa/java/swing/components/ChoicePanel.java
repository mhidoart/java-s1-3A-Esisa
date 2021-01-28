package com.esisa.java.swing.components;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

public class ChoicePanel extends JPanel {
	public static final int UNIQUE = 0;
	public static final int MULTIPLE = 1;

	public ChoicePanel(String label, String ...choices) {
		this(UNIQUE, label, choices);
	}
	
	public ChoicePanel(int type, String label, String ...choices) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		if (!label.contains(":")) label = label + " : ";
		add(new JLabel(label));
		
		if(type == UNIQUE) {
			ButtonGroup g1 = new ButtonGroup();
			for (int i = 0; i < choices.length; i++) {
				JRadioButton b1 = new JRadioButton(choices[i]);
				add(b1);
				g1.add(b1);
			}
		}
		else if (type == MULTIPLE) {
			for (int i = 0; i < choices.length; i++) {
				JCheckBox b1 = new JCheckBox(choices[i]);
				add(b1);
			}
		}
	}


	public ChoicePanel(int type, String label, int labelWidth, String ...choices) {
		this(type, label, choices);
		JLabel l1 = (JLabel)getComponent(0);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
	}
}

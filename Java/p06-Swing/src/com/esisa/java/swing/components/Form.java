package com.esisa.java.swing.components;

import java.awt.Color;
import java.awt.Component;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Form extends JPanel {
	private int labelWidth = 100;
	private JPanel container;
	
	public Form() {
		this("");
	}
	
	public Form(String title) {
		setLayout(new FlowLayout(FlowLayout.LEFT));
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		
		//setBorder(BorderFactory.createLineBorder(Color.red));
		//container.setBorder(BorderFactory.createLineBorder(Color.blue));
		if (!title.equals("")) {
			if (!title.contains(":")) title = " " + title + " : ";
			Border border = BorderFactory.createEtchedBorder();
			container.setBorder(BorderFactory.createTitledBorder(border, title));
		}
	}

	public Form(int labelWidth) {
		this();
		this.labelWidth = labelWidth;
	}

	public Form(String title, int labelWidth) {
		this(title);
		this.labelWidth = labelWidth;
	}

	public void add(String label, int size) {
		LabeledTextField t1 = new LabeledTextField(label, size, labelWidth);
		container.add(t1);
	}
	
	public void addUniqueChoicesField(String label, String ...choices) {
		ChoicePanel p1 = new ChoicePanel(ChoicePanel.UNIQUE, label, labelWidth, choices);
		container.add(p1);
	}
	
	public void addMultipleChoicesField(String label, String ...choices) {
		ChoicePanel p1 = new ChoicePanel(ChoicePanel.MULTIPLE, label, labelWidth, choices);
		container.add(p1);
	}
	
	public String getValue(int index) {
		Component cmp = container.getComponent(index);
		if (cmp instanceof LabeledTextField) {
			return ((LabeledTextField)cmp).getValue();
		}
		else if(cmp instanceof ChoicePanel) {
			//??
		}
		return null;
	}
	
	public int getIntValue(int index) {
		try {
			return Integer.parseInt(getValue(index));
		} 
		catch (Exception e) {
			return 0;
		}
	}
	
	public double getDoubleValue(int index) {
		try {
			return Double.parseDouble(getValue(index));
		} 
		catch (Exception e) {
			return 0;
		}
	}
	
	public void setValue(int index, String value) {
		Component cmp = container.getComponent(index);
		if (cmp instanceof LabeledTextField) {
			((LabeledTextField)cmp).setValue(value);
		}
		else if(cmp instanceof ChoicePanel) {
			//??
		}
	}
	
	public void setValues(String ...values) {
		for (int i = 0; i < values.length; i++) {
			setValue(i, values[i]);
		}
	}
	
	public void clear() {
		for (int i = 0; i < container.getComponentCount(); i++) {
			setValue(i, "");
		}
		setFocus(0);
	}
	
	public void setFocus(int index) {
		Component cmp = container.getComponent(index);
		if (cmp instanceof LabeledTextField) {
			((LabeledTextField)cmp).setFocus();
		}
		else if(cmp instanceof ChoicePanel) {
			//??
		}
	}
}

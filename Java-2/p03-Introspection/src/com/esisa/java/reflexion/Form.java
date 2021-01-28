package com.esisa.java.reflexion;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.lang.reflect.Field;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import com.esisa.java.reflexion.annotations.TextField;


public class Form extends JPanel {
	private int labelWidth = 100;
	private JPanel container;
	private String title = "";

	public Form(Object x) {
		com.esisa.java.reflexion.annotations.Form f 
			= x.getClass().getDeclaredAnnotation(com.esisa.java.reflexion.annotations.Form.class);
		if (f != null) {
			title = f.title();
			labelWidth = f.labelWidth();
		}
		else {
			title = x.getClass().getSimpleName();
		}
		
		setLayout(new FlowLayout(FlowLayout.LEFT));
		container = new JPanel();
		container.setLayout(new BoxLayout(container, BoxLayout.Y_AXIS));
		add(container);
		if (!title.contains(":")) title = " " + title + " : ";
		Border border = BorderFactory.createEtchedBorder();
		container.setBorder(BorderFactory.createTitledBorder(border, title));
		
		createFields(x);
	}
	
	private void createFields(Object x) {
		Field f[] = x.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			TextField field = f[i].getAnnotation(TextField.class);
			if (field != null) {
				JTextField t1 = add(field.label(), field.size());
				Object value = getValue(x, f[i]);
				if (value != null) t1.setText("" + value);
			}
		}
	}
	
	public Object getValue(Object x, Field f) {
		try {
			f.setAccessible(true);
			Object value = f.get(x);
			f.setAccessible(false);
			return value;
		}
		catch (Exception e) {
			return null;
		}
	}

	public JTextField add(String label, int size) {
		JPanel t1 = new JPanel(new FlowLayout(FlowLayout.LEFT));
		if (!label.contains(":")) label = label + " : ";
		JLabel l1 = new JLabel(label);
		l1.setPreferredSize(new Dimension(labelWidth, l1.getPreferredSize().height));
		t1.add(l1);
		JTextField text = new JTextField(size);
		t1.add(text);
		container.add(t1);
		return text;
	}
}

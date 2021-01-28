package com.esisa.java.reflexion;

import java.io.PrintWriter;
import java.lang.reflect.Field;

import javax.swing.JTextField;

import com.esisa.java.reflexion.annotations.TextField;

public class HtmlFormGenerator {
	private StringBuffer form;
	
	public HtmlFormGenerator(Object x) {
		com.esisa.java.reflexion.annotations.Form f 
		= x.getClass().getDeclaredAnnotation(com.esisa.java.reflexion.annotations.Form.class);
		String title = "";
		if (f != null) {
			title = f.title();
		}
		else {
			title = x.getClass().getSimpleName();
		}
		String s1 = "<!DOCTYPE html>\n<html>\n<body>\n"
			+ "\t<h1>" + title + "</h1>\n";
		form = new StringBuffer(s1 + "\t<form action='' method='get'>\n");
		form.append("\t<table>\n");
		
		createFields(x);
		
		form.append("\t</table>\n");
		form.append("\t<input type='submit' value='Valider'>\n");
		form.append("\t</form>\n</body></html>");
	}
	
	private void createFields(Object x) {
		Field f[] = x.getClass().getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			TextField field = f[i].getAnnotation(TextField.class);
			if (field != null) {
				form.append("\t\t<tr><td>" + field.label() + "</td><td>");
				form.append("<input type='text' size='" + field.size() 
					+ "' name='" + f[i].getName() + "' value='" + getValue(x, f[i]) + "' />");
				form.append("</td></tr>\n");
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

	public void generate(String target) {
		try {
			PrintWriter out = new PrintWriter(target);
			out.println(form);
			out.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}

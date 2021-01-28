package com.esisa.java.reflexion;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

import javax.swing.JFrame;

import com.esisa.java.reflexion.models.Document;
import com.esisa.java.reflexion.models.Produit;

public class Examples {

	public Examples() {
		exp08();
	}
	
	void exp01() {
		Document doc = new Document("543-6543-321", "Programmation Web avec JavaScript", 654, 10);
		setFieldValue(doc, "isbn", "111-222-3333");
		reflection(doc);
	}
	
	void setFieldValue(Object x, String fieldName, Object value) {
		Class<?> cls = x.getClass();
		try {
			Field f = cls.getDeclaredField(fieldName);
			boolean a = f.isAccessible();
			f.setAccessible(true);
			f.set(x, value);
			f.setAccessible(a);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void reflection(Object x) {
		Class<?> cls = x.getClass();
		System.out.println(cls.getName());
		System.out.println(cls.getSimpleName());
		
		Field f[] = cls.getDeclaredFields();
		for (int i = 0; i < f.length; i++) {
			Object value = 0;
			try {
				boolean a = f[i].isAccessible();
				f[i].setAccessible(true);
				value = f[i].get(x);
				f[i].setAccessible(a);
			}
			catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
			System.out.println(" - " + f[i].getName() + " = " + value);
		}
	}
	
	void exp02() {
		Class<?> cls = Document.class;
		Method m[] = cls.getDeclaredMethods();
		for (int i = 0; i < m.length; i++) {
			System.out.println(" - " + m[i].getName() + "()");
		}
		
		Document doc = new Document("543-6543-321", "Programmation Web avec JavaScript", 654, 10);
		try {
			m[1].invoke(doc);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp03() {
		Document doc = new Document("543-6543-321", "Programmation Web avec JavaScript", 654, 10);
		invoke(doc, "print");
	}
	
	void invoke(Object x, String method) {
		try {
			Method m = x.getClass().getDeclaredMethod(method);
			m.invoke(x);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp04() {
		Document doc = new Document("543-6543-321", "Programmation Web avec JavaScript", 654, 10);
		try {
			Method m = doc.getClass().getDeclaredMethod("print", String.class, int.class);
			m.invoke(doc, "Document", 10);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp05() {
		Document doc = (Document)newInstance(Document.class);
		doc.print();
	}
	
	Object newInstance(Class<?> cls) {
		try {
			return cls.getConstructor().newInstance();
		}
		catch (Exception e) {
			System.out.println();
			return null;
		}
	}
	
	void exp06() {
		try {
			String name = "com.esisa.java.reflexion.models.Document";
			Class<?> cls = Class.forName(name);
			Object x = cls.getConstructor(String.class, String.class, double.class, int.class)
				.newInstance("564-432-2314", "Introspection", 876, 101);
			System.out.println(x);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	void exp07() {
		JFrame f = new JFrame();
		f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Form form = new Form(new Document("543-132-1324", "Introspection en Java", 654, 10));
//		Form form = new Form(new Produit());
	
		f.setContentPane(form);
		f.pack();
		f.setResizable(false);
		f.setVisible(true);
	}
	
	void exp08() {
		Document doc = new Document("543-132-1324", "Introspection en Java", 654, 10);
		HtmlFormGenerator gen = new HtmlFormGenerator(doc);
		gen.generate("resources/NouveauDocumentForm.html");
	}

	public static void main(String[] args) {
		new Examples();
	}

}

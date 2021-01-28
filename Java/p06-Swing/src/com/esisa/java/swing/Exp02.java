package com.esisa.java.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
//import java.util.Iterator;
//import java.util.LinkedList;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import com.esisa.java.swing.components.ButtonPanel;
import com.esisa.java.swing.components.ChoicePanel;
import com.esisa.java.swing.components.Form;
import com.esisa.java.swing.components.ImagePanel;
import com.esisa.java.swing.components.LabeledTextField;
import com.esisa.java.swing.components.Menu;
import com.esisa.java.swing.listeners.ActionListenerTest;
import com.esisa.java.swing.listeners.AlphaListener;
import com.esisa.java.swing.listeners.ExitAction;
import com.esisa.java.swing.listeners.KeyListenerTest;
import com.esisa.java.swing.listeners.NumericListener;
import com.esisa.java.swing.listeners.ToUpperListener;

public class Exp02 extends JFrame {

	public Exp02() {
		init();
		exp11();
		setVisible(true);
	}
	
	void exp01() {
		setSize(500, 300);
		setLocation(100, 100);
		JPanel p1 = new JPanel();
		p1.setLayout(new GridLayout(2, 2));
		JLabel l1 = new JLabel("Nom : ");
		JTextField t1 = new JTextField(20);
		JButton b1 = new JButton("Valider");
		p1.add(l1);
		p1.add(t1);
		p1.add(b1);
		setContentPane(p1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	void exp02() {
		setSize(500, 300);
		setLocation(100, 100);
		JPanel p1 = new JPanel();
		p1.setLayout(new BorderLayout());
		JLabel l1 = new JLabel("Nom : ");
		JTextField t1 = new JTextField(20);
		JButton b1 = new JButton("Valider");
		p1.add("West", l1);
		p1.add("North", t1);
		p1.add("South", b1);
		setContentPane(p1);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		setVisible(true);
	}
	
	void init() {
		setSize(600, 300);
		setLocation(100, 100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);		
	}
	
	void exp03() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		JButton b1 = new JButton("Valider");
		JButton b2 = new JButton("Annuler");
		JPanel p1 = new JPanel();
		p1.setBackground(Color.GRAY);
		p1.add(b1);
		p1.add(b2);
		
		container.add("South", p1);
		
		setContentPane(container);
		setVisible(true);
	}

	void exp04() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		ButtonPanel p1 = new ButtonPanel("Valider", /*"Enregistrer",*/ "Annuler");
		container.add("South", p1);
		
		JPanel form = new JPanel();
		form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
		container.add("Center", form);
		
		form.add(new LabeledTextField("Nom", 20));
		form.add(new LabeledTextField("Prénom", 20));
		form.add(new LabeledTextField("Tel", 12));
			
		setContentPane(container);
		setVisible(true);
	}
	
	void exp05() {
		JPanel container = new JPanel();
		container.setLayout(new BorderLayout());
		
		ButtonPanel p1 = new ButtonPanel("Valider", /*"Enregistrer",*/ "Annuler");
		container.add("South", p1);
		
		Form form = new Form("Saisie d'un document");
		container.add("Center", form);
		
		form.add("Identificateur", 10);
		form.add("Titre", 40);
		form.add("Editeur", 30);
		form.add("Année d'édition", 10);
		form.addUniqueChoicesField("Langues", "Français", "Anglais", "Arabe");
		form.addUniqueChoicesField("Etat", "Disponible", "Non disponible");
		form.addMultipleChoicesField("Format", "Papier", "Electronique");
			
		setContentPane(container);
		pack();
		//setResizable(false);
	}
	
	void exp06() {
		ChoicePanel p1 = new ChoicePanel("Langues", "Français", "Anglais", "Arabe");
		ChoicePanel p2 = new ChoicePanel(ChoicePanel.MULTIPLE, "Langues", "Français", "Anglais", "Arabe");
		getContentPane().add("North", p1);
		getContentPane().add("South", p2);
		
		JButton b1 = new JButton("");
	}
	
	void exp07() { //??
		ImagePanel p1 = new ImagePanel("resources/wp01.png");
		getContentPane().add("Center", p1);
	}
	
	void exp08() {
		JButton b1 = new JButton("Quitter");
		b1.addActionListener(new ExitAction());
		getContentPane().add("South", b1);
	}
	
	void exp09() {
		JTextField t1 = new JTextField();
		getContentPane().add("North", t1);
		
		//t1.addKeyListener(new KeyListenerTest());
		t1.addKeyListener(new AlphaListener());
		//t1.addKeyListener(new NumericListener());
		t1.addKeyListener(new ToUpperListener());
	}
	
	void exp10() {
		ButtonPanel p1 = new ButtonPanel("Nouveau", "Enregistrer", "Annuler");
		p1.addActionListener(new ActionListenerTest());
		getContentPane().add("South", p1);
	}
	
	void exp11() {
		String labels[][] =  {
			{"File", "New", "Open", "Save", "-", "Quitter"},
			{"Edit", "Copy", "Cut", "Paste"}
		};
		Menu menu = new Menu(labels);
		setJMenuBar(menu);
	}

	public static void main(String[] args) {
		/*
		LinkedList<String> l1 = new LinkedList<>();
		
		Iterator<String> it = l1.iterator();
		String first = it.next();
		String second = it.next();
		*/
		new Exp02();
	}
}

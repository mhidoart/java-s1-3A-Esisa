package com.esisa.compiler.scanner.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileReader;
import java.util.Vector;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextArea;
import javax.swing.JToolBar;
import javax.swing.table.DefaultTableModel;

import com.esisa.compiler.scanner.Error;
import com.esisa.compiler.scanner.Scanner;
import com.esisa.compiler.scanner.Token;

public class ScannerPanel extends JPanel implements ActionListener {
	private Scanner scanner;
	private JTextArea source;
	private DefaultTableModel tokens;
	private DefaultListModel<String> errors;
	private JFileChooser fileChooser;
	
	private String items[] = {"Nouveau", "Ouvrir", "Enregistrer", "Enregistrer sous", "Analyser", "-", "Quitter"};
	private String icons[] = {"new.png", "open.png", "save.png", "saveas.png", "scan.png", "-", "stop.png"};
	private String iconsFolder = "resources/icons/";
	
	public ScannerPanel(Scanner scanner) {
		this.scanner = scanner;
		setLayout(new BorderLayout());
		
		source = new JTextArea();
		source.setFont(new Font("Consolas", Font.PLAIN, 20));
		source.setForeground(Color.blue);
		add("Center", new JScrollPane(source));
		
		tokens = new DefaultTableModel(new String[] {"Lexème", "Unité Lexicale"},  0);
		JTable table = new JTable(tokens);
		add("East", new JScrollPane(table));
		
		errors = new DefaultListModel<>();
		JList<String> list = new JList<>(errors);
		add("South", new JScrollPane(list));
		
		createToolBar();
		fileChooser = new JFileChooser(".");
	}
	
	private void createToolBar() {
		Cursor cursor = new Cursor(Cursor.HAND_CURSOR);
		JToolBar bar = new JToolBar();
		bar.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 2));
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals("-")) {
				bar.addSeparator();
			}
			else {
				JButton b1 = new JButton(new ImageIcon(iconsFolder + icons[i]));
				b1.setToolTipText(items[i]);
				b1.setName(items[i]);
				b1.addActionListener(this);
				b1.setBorder(null);
				b1.setCursor(cursor);
				bar.add(b1);
			}
		}
		add("North", bar);
	}
	
	public JMenuBar createMenu() {
		JMenuBar menuBar = new JMenuBar();
		JMenu menu = new JMenu("Fichier");
		menuBar.add(menu);
		for (int i = 0; i < items.length; i++) {
			if (items[i].equals("-")) {
				menu.addSeparator();
			}
			else {
				JMenuItem item = new JMenuItem(items[i], new ImageIcon(iconsFolder + icons[i]));
				item.setName(items[i]);
				item.addActionListener(this);
				menu.add(item);
			}
		}
		return menuBar;
	}

	public void actionPerformed(ActionEvent e) {
		JComponent src = (JComponent)e.getSource();
		
		if (src.getName().equals("Analyser")) scan();
		if (src.getName().equals("Ouvrir")) open();
	}
	
	public void printTokens(Vector<Token> t) {
		tokens.setRowCount(0);
		for (Token token : t) {
			tokens.addRow(new String[] {token.getValue(), token.getLexicalUnit()});
		}
	}
	
	public void printErrors(Vector<Error> e) {
		errors.clear();
		if (e.size() == 0) {
			errors.addElement("Aucune erreur Lexicale");
		}
		else {
			for (Error error : e) {
				errors.addElement(error.getMessage());
			}
		}
	}
//-------------- Actions ----------------------------------------------
	public void scan() {
		scanner.scan(source.getText());
		printErrors(scanner.getErrorList());
		printTokens(scanner.getTokenList());
	}
	
	public void open() {
		int result = fileChooser.showOpenDialog(this);
		if (result == JFileChooser.APPROVE_OPTION) {
			File f = fileChooser.getSelectedFile();
			try {
				FileReader in = new FileReader(f);
				char t[] = new char[(int)f.length()];
				in.read(t);
				in.close();
				source.setText(new String(t));
			}
			catch (Exception e) {
				System.out.println("Erreur : " + e.getMessage());
			}
		}
	}
}

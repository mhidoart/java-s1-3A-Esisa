package com.esisa.java.swing.components;

import java.awt.event.ActionListener;
import java.util.Vector;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class Menu extends JMenuBar {
	private String iconFolder = "resources/edit/";
	private String extension = ".gif";
	private Vector<JMenuItem> items;
	
	public Menu(String m[][], String iconFolder, String extension) {
		this.iconFolder = iconFolder;
		this.extension = extension;
		createMenuBar(m);
	}
	
	public Menu(String m[][]) {
		createMenuBar(m);
	}
	
	public void createMenuBar(String m[][]) {
		items = new Vector<>();
		for (int i = 0; i < m.length; i++) {
			createMenu(m[i]);
		}
	}
	
	public void createMenu(String t[]) {
		JMenu m = new JMenu(t[0]);
		add(m);
		for (int i = 1; i < t.length; i++) {
			if (t[i].equals("-")) {
				m.addSeparator();
			}
			else {
				Icon icon = new ImageIcon(iconFolder + t[i].toLowerCase() + extension);
				JMenuItem item = new JMenuItem(t[i], icon);
				items.add(item);
				m.add(item);
			}
		}
	}
	
	public void addActionListener(ActionListener a) {
		for (JMenuItem item : items) {
			item.addActionListener(a);
		}
	}
}

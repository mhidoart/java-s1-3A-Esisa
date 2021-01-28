package com.esisa.os;

import java.util.Vector;

import javax.swing.JComponent;

public class WaitingThreadList {
	private String name;
	private Vector<Thread> list;
	
	private JComponent listComponent = null;
	
	public WaitingThreadList(String name) {
		this.name = name;
		list = new Vector<>();
	}

	public void add(Thread thread) {
		list.add(thread);
		repaintComponent();
	}
	
	public boolean remove(Thread thread) {
		boolean b = list.remove(thread);
		repaintComponent();
		return b;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Vector<Thread> getList() {
		return list;
	}
	
	public int size() {
		return list.size();
	}
	
	public Thread thread(int index) {
		return list.get(index);
	}
	
	public JComponent getListComponent() {
		return listComponent;
	}
	
	public void setListComponent(JComponent listComponent) {
		this.listComponent = listComponent;
	}
	
	public void repaintComponent() {
		if (listComponent != null) {
			listComponent.repaint();
		}
	}
}

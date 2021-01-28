package com.esisa.os;

import java.util.Vector;

import javax.swing.JComponent;

public class ThreadList {
	private String name;
	private Buffer buffer;
	private JComponent linkedComponent = null;
	private Vector<Thread> list;
	
	public ThreadList() {
		list = new Vector<>();
	}
	
	public ThreadList(String name) {
		this.name = name;
		list = new Vector<>();
	}
	
	public ThreadList(Buffer buffer) {
		this.buffer = buffer;
		list = new Vector<>();
	}
	
	public ThreadList(String name, Buffer buffer) {
		this.name = name;
		this.buffer = buffer;
		list = new Vector<>();
	}

	public void add(Thread thread) {
		list.add(thread);
		if (linkedComponent != null) linkedComponent.repaint();
		thread.start();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public JComponent getLinkedComponent() {
		return linkedComponent;
	}

	public void setLinkedComponent(JComponent linkedComponent) {
		this.linkedComponent = linkedComponent;
	}
	
	public int size() {
		return list.size();
	}
	
	public Thread get(int index) {
		return list.get(index);
	}

	public Buffer getBuffer() {
		return buffer;
	}

	public void setBuffer(Buffer buffer) {
		this.buffer = buffer;
	}
}

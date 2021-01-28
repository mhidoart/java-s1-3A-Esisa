package com.esisa.java;

import java.util.Vector;

public class DataManager {
	private Vector<String> data;
	private Vector<Printer> printers;
	private Sorter sorter;
	
	public DataManager() {
		data = new Vector<>();
		printers = new Vector<>();
	}

	public void add(String item) {
		data.add(item);
	}
	
	public int size() {
		return data.size();
	}
	
	public String get(int index) {
		return data.get(index);
	}

	public void addPrinter(Printer printer) {
		printers.add(printer);
	}

	public Sorter getSorter() {
		return sorter;
	}

	public void setSorter(Sorter sorter) {
		this.sorter = sorter;
	}

	public void print() {
		String t[] = new String[data.size()];
		data.toArray(t);
		for (Printer printer : printers) {
			printer.print(t);
		}
	}
	public void sort() {
		if (sorter != null) {
			String t[] = new String[data.size()];
			data.toArray(t);
			sorter.sort(t);
		}
	}
}

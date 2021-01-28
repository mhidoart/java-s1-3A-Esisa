package com.esisa.java;

import java.util.Arrays;

import javax.swing.JOptionPane;

public class DialogPrinter implements Printer {

	public DialogPrinter() {
	}

	public void print(String[] t) {
		JOptionPane.showMessageDialog(null, Arrays.toString(t));
	}

}

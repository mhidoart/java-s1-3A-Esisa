package com.esisa.os;

import javax.swing.JComponent;

// Ressource partag�e 
public class Buffer {
	private int data[];
	private int readIndex = 0;
	private int writeIndex = 0;
	
	private int readerCounter = 0; // Nombre de lecteurs bloqu�s
	private int writerCounter = 0; // Nombre de r�dacteurs bloqu�s
	
	private JComponent bufferComponent = null;
	
	private Thread currentWriter = null;
	private int writePosition = 0;
	
	private Thread currentReader = null;
	private int readPosition = 0;
	private int readData = 0;
	
	private WaitingThreadList readers;
	private WaitingThreadList writers;
	
	public Buffer(int size) {
		data = new int[size];
		for (int i = 0; i < data.length; i++) {
			data[i] = -1;
		}
		
		readers = new WaitingThreadList("File d'attente des Lecteurs bloqu�s");
		writers = new WaitingThreadList("File d'attente des R�dacteurs bloqu�s");
	}
	// Cr�ation d'une m�thode de Moniteur => Exclusion Mutuelle = Acc�s Exclusif
	synchronized public int read() {
		System.out.println(">> D�but Lecture � la position " + readIndex + " : " + Thread.currentThread());
		if (data[readIndex] == -1) {
			readerCounter++;
			readers.add(Thread.currentThread());
			bloquer();
			readers.remove(Thread.currentThread());
			readerCounter--;
		}
		
		int info = data[readIndex];
		data[readIndex] = -1;
		currentReader = Thread.currentThread();
		readPosition = readIndex;
		readData = info;
		repaintComponent();
		
		pause(2000);

		readIndex++;
		if (readIndex >= data.length) {
			readIndex = 0;
		}
		System.out.println(">> Fin Lecture : " + Thread.currentThread() + " (" + info + ")");
		if (writerCounter > 0) { // S'il existe au moins un r�dacteur bloqu�
			reveiller(); // Je r�veille 1
		}
		return info;
	}
	
	synchronized public void write(int info) {
		System.out.println(">> D�but Ecriture � la position " + writeIndex + " : " + Thread.currentThread());
		if (data[writeIndex] != -1) {
			writerCounter++;
			writers.add(Thread.currentThread());
			bloquer();
			writers.remove(Thread.currentThread());
			writerCounter--;
		}
		
		data[writeIndex] = info;
		currentWriter = Thread.currentThread();
		writePosition = writeIndex;
		repaintComponent();
		
		pause(2000);

		writeIndex++;
		if (writeIndex >= data.length) {
			writeIndex = 0;
		}
		System.out.println(">> Fin Ecriture : " + Thread.currentThread());
		if (readerCounter > 0) { // S'il existe au moins un lecteur bloqu�
			reveiller(); // Je r�veille 1
		}
	}
	
	public static void pause(int time) {
		try {
			Thread.sleep(time);
		}
		catch (Exception e) {}
	}
	
	public void bloquer() {
		try {
			System.out.println(">>>> " + Thread.currentThread() + " se bloque");
			wait();
			System.out.println(">>>> " + Thread.currentThread() + " se r�veille");
		}
		catch (Exception e) {}
	}
	
	public void reveiller() {
		notify();
	}
	
	public int size() {
		return data.length;
	}
	
	public int getData(int index) {
		return data[index];
	}
	
	public void repaintComponent() {
		if (bufferComponent != null) {
			bufferComponent.repaint();
		}
	}
	
	public JComponent getBufferComponent() {
		return bufferComponent;
	}
	
	public void setBufferComponent(JComponent bufferComponent) {
		this.bufferComponent = bufferComponent;
	}
	
	public Thread getCurrentWriter() {
		return currentWriter;
	}
	
	public int getWritePosition() {
		return writePosition;
	}
	
	public Thread getCurrentReader() {
		return currentReader;
	}
	
	public int getReadPosition() {
		return readPosition;
	}
	
	public int getReadData() {
		return readData;
	}
	
	public WaitingThreadList getWaitingReaders() {
		return readers;
	}
	
	public WaitingThreadList getWaitingWriters() {
		return writers;
	}
}

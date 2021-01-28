package com.esisa.os.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JPanel;

import com.esisa.os.Buffer;
import com.esisa.os.Reader;
import com.esisa.os.ReadersList;
import com.esisa.os.Writer;
import com.esisa.os.WritersList;

public class ReaderWriterFrame extends JFrame implements ActionListener {
	private JPanel screen;
	private Buffer buffer;
	private BufferPanel bufferPanel;
	private WaitingThreadListPanel waitingReaders;
	private WaitingThreadListPanel waitingWriters;
	private ReadersList readersList;
	private WritersList writersList;
	private ThreadListPanel readersListPanel;
	private ThreadListPanel writersListPanel;
	
	public ReaderWriterFrame() {
		screen = new JPanel();
		screen.setLayout(new BorderLayout());
				
		buffer = new Buffer(10);		
		bufferPanel = new BufferPanel(40);
		bufferPanel.setBuffer(buffer);
		screen.add("South", bufferPanel);
		
		readersList = new ReadersList(buffer);
		writersList = new WritersList(buffer);
		readersListPanel = new ThreadListPanel(readersList, 40);
		writersListPanel = new ThreadListPanel(writersList, 40);
		
		JPanel p = new JPanel(new GridLayout(1, 2));
		p.add(readersListPanel);
		p.add(writersListPanel);
		screen.add("North", p);

		waitingReaders = new WaitingThreadListPanel(40, 10);
		screen.add("West", waitingReaders);

		waitingWriters = new WaitingThreadListPanel(40, 10);
		screen.add("East", waitingWriters);
		
		waitingReaders.setWaitingThreadList(buffer.getWaitingReaders());
		waitingWriters.setWaitingThreadList(buffer.getWaitingWriters());
		
		getContentPane().add("Center", screen);
		ButtonPanel bp = new ButtonPanel("Nouveau Lecteur", "Nouveau Rédacteur", "Quitter");
		bp.addActionListener(this);
		getContentPane().add("South", bp);
		
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		//setExtendedState(MAXIMIZED_BOTH);
		setBounds(100, 100, 1000, 800);
		setVisible(true);

		//createReadersAndWriters();
	}
	
	public void createReadersAndWriters() {
		Writer w[] = new Writer[1];
		for (int i = 0; i < w.length; i++) {
			w[i] = new Writer("W" + i, buffer);
			w[i].start();
		}
	
		Reader r[] = new Reader[5];
		for (int i = 0; i < r.length; i++) {
			r[i] = new Reader("R" + i, buffer);
			r[i].start();
		}

	}

	public static void main(String[] args) {
		new ReaderWriterFrame();
	}

	public void actionPerformed(ActionEvent e) {
		JButton src = (JButton)e.getSource();
		if (src.getName().equals("Nouveau Lecteur")) {
			readersList.newReader();
		}
		else if (src.getName().equals("Nouveau Rédacteur")) {
			writersList.newWriter();
		}
		else if (src.getName().equals("Quitter")) {
			System.exit(0);
		}
	}
}

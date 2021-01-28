package com.esisa.java.web;

import java.net.ServerSocket;
import java.net.Socket;

public class WebServer extends Thread {
	private int port = 80;

	public WebServer() {
	}
	
	public WebServer(int port) {
		this.port = port;
	}

	public void run() {
		try {
			ServerSocket ss = new ServerSocket(port);
			System.out.println("Serveur démaré...");
			do {
				System.out.println("Serveur à l'écoute...");
				Socket socket = ss.accept();
				System.out.println("Demande de connexion : ");
				ResponseThread responseThread = new ResponseThread(socket);
				responseThread.start();
			}
			while (true);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
}

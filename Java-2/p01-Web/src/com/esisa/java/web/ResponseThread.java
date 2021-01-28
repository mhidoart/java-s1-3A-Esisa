package com.esisa.java.web;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;

public class ResponseThread extends Thread {
	private Socket socket;
	private String request;
	private String resource;

	public ResponseThread(Socket socket) {
		super();
		this.socket = socket;
	}

	public void run() {
		readRequest();
		System.out.println(request);
		readResource();
		System.out.println("Ressource demandée : " + resource);
		sendResource();
		close();
	}
	
	private void readRequest() {
		try {
			InputStream is = socket.getInputStream();
			InputStreamReader isr = new InputStreamReader(is);
			BufferedReader in = new BufferedReader(isr);
			
			String line = in.readLine();
			request = "";
			while (line != null && in.ready()) {
				request = request + line + "\n";
				line = in.readLine();
			}
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
		
	}
	
	private void readResource() {
		int i = request.indexOf("/") + 1;
		int j = request.indexOf(" ", i);
		if (i == j) {
			resource = "index.html";
		}
		else {
			resource = request.substring(i, j);
		}
	}
	
	private void sendResource() {
		try {
			OutputStream os = socket.getOutputStream();

			File in = new File("www/" + resource);
			if (in.exists()) {
				FileInputStream fis = new FileInputStream(in);
				byte bytes[] = new byte[(int)in.length()];
				fis.read(bytes);
				fis.close();
				
				os.write(bytes);
			}
			else {
				PrintWriter out = new PrintWriter(os);
				out.println("<h1>Ressource Introuvable</h1>");
				out.close();
				System.out.println("Ressource Introuvable : www/" + resource);
			}
			os.close();		
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	private void close() {
		try {
			socket.close();
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
		}
	}
	
	public String getRequest() {
		return request;
	}
	
	public String getResource() {
		return resource;
	}
}

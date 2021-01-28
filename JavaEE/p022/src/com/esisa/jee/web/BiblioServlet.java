package com.esisa.jee.web;

import java.io.IOException;
import java.util.Vector;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.esisa.jee.business.DocumentService;
import com.esisa.jee.business.DocumentServiceDefault;
import com.esisa.jee.dao.DocumentDao;
import com.esisa.jee.dao.DocumentDaoJdbc;
import com.esisa.jee.dao.jdbc.DataSource;
import com.esisa.jee.dao.jdbc.Database;
import com.esisa.jee.dao.jdbc.MySQLDataSource;
import com.esisa.jee.models.Document;
import com.esisa.jee.web.actions.BiblioAction;

public class BiblioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private BiblioAction action;
	
    public void init() throws ServletException {
    	System.out.println(">>> init() : Wiring");
    	DataSource ds = new MySQLDataSource("Biblio");
    	Database db = new Database(ds);
    	DocumentDao documentDao = new DocumentDaoJdbc(db);
    	DocumentService service = new DocumentServiceDefault(documentDao);
    	action = new BiblioAction(service);
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String uri = request.getRequestURI();
		System.out.println(uri);
		
		String view = "/views/Error.jsp";
		
		if (uri.endsWith("/DocumentList")) {
			view = action.documentList(request);
		}
		else if (uri.endsWith("/AddDocument")) {
			view = action.addDocument(request);
		}
		else if (uri.endsWith("/SearchDocumentsByKeyword")) {
			view = action.searchDocumentsByKeyword(request);
		}
		else if (uri.endsWith("/AuthorList")) {
			
		}
		//....
		request.getRequestDispatcher(view).forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
}

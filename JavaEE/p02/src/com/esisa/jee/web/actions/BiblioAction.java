package com.esisa.jee.web.actions;

import java.util.Hashtable;
import java.util.List;
import java.util.Vector;

import javax.servlet.http.HttpServletRequest;

import com.esisa.jee.business.DocumentService;
import com.esisa.jee.models.Document;
/*
 * Classe d'action
 */
public class BiblioAction {
	private DocumentService business;
	private Hashtable<String, Document> docs;
	
	public BiblioAction() {
    	docs = new Hashtable<>();
    	docs.put("324-435-7654", new Document("324-435-7654", "Développement Web en Java", 2019));
    	docs.put("765-987-1234", new Document("765-987-1234", "Architecture JavaEE", 2018));
    	docs.put("890-765-9870", new Document("890-765-9870", "POO en JavaScript", 2017));
	}
	
	public BiblioAction(DocumentService business) {
		super();
		this.business = business;
	}

	public void setBusiness(DocumentService business) {
		this.business = business;
	}

	/*
 * Méthodes d'action	
 */
	public String documentList(HttpServletRequest request) {
		List<Document> vDocs = business.documents();
		request.setAttribute("docs", vDocs);	
		request.setAttribute("message", "Liste de tous les documents");
		return "/views/DocumentList.jsp";
	}
	
	public String searchDocumentsByKeyword(HttpServletRequest request) {
		String keyword = request.getParameter("keyword");
		List<Document> vDocs = business.getDocumentsBykeyword(keyword);
		request.setAttribute("docs", vDocs);
		request.setAttribute("message", "Liste des documents concernant : " + keyword);
		return "/views/DocumentList.jsp";
	}
	
	public String addDocument(HttpServletRequest request) {
		System.out.println(">> addDocument()");
		Document doc = new Document();
		doc.setIsbn(request.getParameter("isbn"));
		doc.setTitle(request.getParameter("title"));
		//...
		
		docs.put(doc.getIsbn(), doc);
		
		Vector<Document> vDocs = new Vector<>(docs.values());
		request.setAttribute("model", vDocs);	
		return "/views/DocumentList.jsp";
	}
}

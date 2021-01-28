package com.esisa.jee.business;

import java.util.List;

import com.esisa.jee.dao.DocumentDao;
import com.esisa.jee.models.Document;

public class DocumentServiceDefault implements DocumentService {
	private DocumentDao documentDao;
	
	public DocumentServiceDefault() {
	}
	
	public DocumentServiceDefault(DocumentDao documentDao) {
		super();
		this.documentDao = documentDao;
	}

	public DocumentDao getDocumentDao() {
		return documentDao;
	}

	public void setDocumentDao(DocumentDao documentDao) {
		this.documentDao = documentDao;
	}

	public Document document(String isbn) {
		return documentDao.select(isbn);
	}

	public List<Document> documents() {
		return documentDao.selectAll();
	}

	public List<Document> getDocumentsBykeyword(String keyword) {
		return documentDao.selectByKeyword(keyword);
	}
}
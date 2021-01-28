package com.esisa.jee.dao;

import java.util.List;
import java.util.Vector;

import com.esisa.jee.dao.jdbc.Database;
import com.esisa.jee.dao.mappers.BiblioMapper;
import com.esisa.jee.models.Document;

public class DocumentDaoJdbc implements DocumentDao {
	private Database db;
	private String tableName = "Titles";
	
	public DocumentDaoJdbc() {
	}

	public DocumentDaoJdbc(Database db) {
		super();
		this.db = db;
	}

	public void setDatabase(Database db) {
		this.db = db;
	}
	
	public Database getDatabase() {
		return db;
	}

	public String getTableName() {
		return tableName;
	}

	public void setTableName(String tableName) {
		this.tableName = tableName;
	}

	public boolean insert(Document doc) {
		return false;
	}

	public void update(Document doc) {
	}

	public void delete(String isbn) {
	}

	public Document select(String isbn) {
		String data[][] = db.select(tableName, "ISBN", isbn);
		if (data == null) return null;
		if (data.length <= 1) return null;
		Document doc = BiblioMapper.getDocument(data[1]);
		return doc;
	}

	public List<Document> selectAll() {
		String data[][] = db.select(tableName);
		if (data == null) return null;
		Vector<Document> docs = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			Document doc = BiblioMapper.getDocument(data[i]);
			docs.add(doc);
		}
		return docs;
	}

	public List<Document> selectByKeyword(String keyword) {
		String data[][] = db.selectLike(tableName, "Title", keyword);
		if (data == null) return null;
		Vector<Document> docs = new Vector<>();
		for (int i = 1; i < data.length; i++) {
			Document doc = BiblioMapper.getDocument(data[i]);
			docs.add(doc);
		}
		return docs;
	}
	/*public static void main(String[] args) {
		int F = (int) (Math.random()*(1970-1930) + 1930);
		System.out.println(F); 
	}
	*/
	
}
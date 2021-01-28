package com.esisa.jee.dao.mappers;

import com.esisa.jee.models.Document;

public class BiblioMapper {
	
	public static Document getDocument(String...row) {
		Document doc = new Document();
		doc.setIsbn(row[0]);
		doc.setTitle(row[1]);
		doc.setYearPublished(getInt(row[2]));
		return doc;
	}
	
	public static int getInt(String data) {
		try {
			return Integer.parseInt(data);
		}
		catch (Exception e) {
			System.out.println("Erreur : " + e.getMessage());
			return 0;
		}
	}
}
package com.esisa.jee.dao;

import java.util.List;

import com.esisa.jee.models.Authors;

public interface AuthorsDao {
	public boolean insert(Authors aut);
	public void update(Authors aut);
	public void delete(String isbn);
	public Authors select(String isbn);
	public List<Authors> selectAll();
	public List<Authors> selectByKeyword(String keyword);
	
	
}


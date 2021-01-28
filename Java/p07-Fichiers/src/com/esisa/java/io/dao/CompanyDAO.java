package com.esisa.java.io.dao;

import java.util.List;

import com.esisa.java.io.models.Company;

public interface CompanyDAO {
	public void save(List<Company> companies);
	public List<Company> load();
}

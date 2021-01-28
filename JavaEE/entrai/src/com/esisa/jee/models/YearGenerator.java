package com.esisa.jee.models;

public class YearGenerator {
	public int generate() {
		return (int) (Math.random()*(1970-1930)-1930);
	}
}
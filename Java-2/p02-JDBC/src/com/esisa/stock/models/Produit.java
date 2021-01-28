package com.esisa.stock.models;

public class Produit {
	private String ref;
	private String desig;
	private double pu;
	private double qs;
	
	public Produit() {
	}

	public Produit(String ref, String desig, double pu, double qs) {
		super();
		this.ref = ref;
		this.desig = desig;
		this.pu = pu;
		this.qs = qs;
	}
	
	public Produit(String row[]) {
		ref = row[0];
		desig = row[1];
		try {
			pu = Double.parseDouble(row[2]);
			qs = Double.parseDouble(row[3]);
		}
		catch (Exception e) {}
	}

	public String getRef() {
		return ref;
	}

	public void setRef(String ref) {
		this.ref = ref;
	}

	public String getDesig() {
		return desig;
	}

	public void setDesig(String desig) {
		this.desig = desig;
	}

	public double getPu() {
		return pu;
	}

	public void setPu(double pu) {
		this.pu = pu;
	}

	public double getQs() {
		return qs;
	}

	public void setQs(double qs) {
		this.qs = qs;
	}

	@Override
	public String toString() {
		return "Produit [ref=" + ref + ", desig=" + desig + ", pu=" + pu + ", qs=" + qs + "]";
	}
}

package model;

public class Contractor extends Customer {
	
	private int discount;
	
	public Contractor(int discount) {
		this.discount=discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
}

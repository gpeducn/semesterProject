package model;

public class Contractor extends Customer {

	private int discount;
	
	public Contractor(String name, String phoneNumber, String zipcode, String adress,int discount) {
		super(name, phoneNumber, zipcode, adress);
		this.discount=discount;
	}

	public int getDiscount() {
		return discount;
	}

	public void setDiscount(int discount) {
		this.discount = discount;
	}
	
	@Override public void getInfo() {
		super.getInfo();
		System.out.println("Type: Contractor ");
		System.out.println("Discount: " + discount);
	}

}

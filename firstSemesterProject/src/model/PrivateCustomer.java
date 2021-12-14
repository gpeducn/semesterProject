package model;

public class PrivateCustomer extends Customer {

	public PrivateCustomer(String name, String phoneNumber, String zipcode, String adress) {
		super(name, phoneNumber, zipcode, adress);
	}

	public PrivateCustomer() {
		super();
	}
	
	@Override public void getInfo() {
		super.getInfo();
		System.out.println("Type: private customer ");
	}
}

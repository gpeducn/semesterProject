import java.util.Calendar;


public abstract class Customer {
	private Calendar registrationDate;
	private String name;
	private String phoneNumber;
	private int zipCode;
	private String address;
	
	public Customer(String name, String phoneNumber, int zipCode, String address) {
		super();
		this.name = name;
		this.phoneNumber = phoneNumber;
		this.zipCode = zipCode;
		this.address = address;
		registrationDate = Calendar.getInstance();
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	public int getZipCode() {
		return zipCode;
	}
	public void setZipCode(int zipCode) {
		this.zipCode = zipCode;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}	
}


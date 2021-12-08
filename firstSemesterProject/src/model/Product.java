package model;

public class Product {
	private int barcode;
	private String location;
	private double price;
	private double purchassePrice;
	private int quantity;
	private int discount;
	private int minimumStock;
	private int maximumStock;
	private boolean isMultipleItem; 

	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	public Product(String productName, int barcode, String location, double price,
			double purchassePrice, int quantity, int discount, int minimumStock, int maximumStock,
			boolean isMultipleItem) {
		super();
		this.productName = productName;
		this.barcode = barcode;
		this.location = location;
		this.price = price;
		this.purchassePrice = purchassePrice;
		this.quantity = quantity;
		this.discount = discount;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
		this.isMultipleItem = isMultipleItem;
	}

	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getBarcode() {
		return barcode;
	}
	public void setBarcode(int barcode) {
		this.barcode = barcode;
	}
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	public double getPurchassePrice() {
		return purchassePrice;
	}
	public void setPurchassePrice(double purchassePrice) {
		this.purchassePrice = purchassePrice;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public int getDiscount() {
		return discount;
	}
	public void setDiscount(int discount) {
		this.discount = discount;
	}
	public int getMinimumStock() {
		return minimumStock;
	}
	public void setMinimumStock(int minimumStock) {
		this.minimumStock = minimumStock;
	}
	public int getMaximumStock() {
		return maximumStock;
	}
	public void setMaximumStock(int maximumStock) {
		this.maximumStock = maximumStock;
	}
	public boolean isMultipleItem() {
		return isMultipleItem;
	}
	public void setMultipleItem(boolean isMultipleItem) {
		this.isMultipleItem = isMultipleItem;
	}
	private String productName;
}
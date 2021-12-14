package model;

public class Product {
	private String productName;
	private static int id;
	private int barcode;
	private String location;
	private double price;
	private double purchasePrice;
	private int quantity;
	private int discount;
	private int minimumStock;
	private int maximumStock;

	public Product(String productName) {
		super();
		this.productName = productName;
	}
	
	public Product(String productName, String location, double price,
			double purchasePrice, int quantity, int discount, int minimumStock, int maximumStock) {
		super();
		this.productName = productName;
		barcode = id++;
		this.location = location;
		this.price = price;
		this.purchasePrice = purchasePrice;
		this.quantity = quantity;
		this.discount = discount;
		this.minimumStock = minimumStock;
		this.maximumStock = maximumStock;
	}

	public void getInfo() {
		System.out.println("Barcode: " + barcode);
		System.out.println("Product name: " + productName);
		System.out.println("Location: " + location);
		System.out.println("Price: " + price);
		System.out.println("Purchase price: " + purchasePrice);
		System.out.println("Quantity: " + quantity);
		System.out.println("Discount: " + discount);
		System.out.println("");
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
	public double getPurchasePrice() {
		return purchasePrice;
	}
	public void setPurchasePrice(double purchasePrice) {
		this.purchasePrice = purchasePrice;
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
	
}
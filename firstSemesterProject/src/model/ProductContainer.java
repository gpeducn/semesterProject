package model;

import java.util.ArrayList;

public class ProductContainer {

	private static ProductContainer instance;
	private ArrayList<Product> products;
	
	private ProductContainer() {
		products = new ArrayList<>();
	}
	
	public static ProductContainer getInstance() {
		if(instance == null) {
			instance = new ProductContainer();
		}
		return instance;
	}
	
	public ArrayList<Product> getAllProducts() {
		return products;
	}
	
	public Product getProduct(int barcode) {
		Product foundProduct = null;
		for(Product element : products) {
			if(element.getBarcode() == barcode) {
				foundProduct= element;
			}
		}
		return foundProduct;
	}
	
	public boolean addProduct(Product product) {
		if(product != null) {
			products.add(product);
			return true;
		} else {
			return false;
		}
	}
	
	public boolean deletePorduct(int barcode) {
		return products.removeIf(product -> product.getBarcode() == barcode);
	}
}

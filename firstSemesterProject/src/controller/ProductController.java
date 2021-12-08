package controller;

import model.Product;

public class ProductController {
	
	public ProductController() {
		
	}
	
	public Product getProductById(int id) {
		return new Product(String.valueOf(id));
	}
}

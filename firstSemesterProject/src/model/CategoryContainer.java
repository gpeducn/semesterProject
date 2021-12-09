package model;

import java.util.ArrayList;

public class CategoryContainer {

	private static CategoryContainer instance;
	private ArrayList<Category> categories;
	
	private CategoryContainer() {
		categories = new ArrayList<>();
	}
	
	public static CategoryContainer getInstance() {
		if(instance == null) {
			instance = new CategoryContainer();
		}
		return instance;
	}
	
	public boolean addCategory(Category category) {
		if(category != null) {
			categories.add(category);
			return true;
		} else {
			return false;
		}
	}
	
	
}

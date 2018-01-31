package org.programmingmag.mag.web.dto;

public class CategoryDTO {
	
	private Long id;
	private String categoryName;
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long categoryId) {
		this.id = categoryId;
	}
	public String getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}
	
}

package com.sampath.blog.playloads;


import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity 
public class CategoryDto {
  
@Id
@GeneratedValue(strategy = GenerationType.IDENTITY)
 private Integer categoryId;
 private String  categoryTitle;
 private String  categoryDescription;


 public CategoryDto() {
	 
 }
public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryTitle = categoryTitle;
	this.categoryDescription = categoryDescription;
}

public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryTitle() {
	return categoryTitle;
}

public void setCategoryTitle(String categoryTitle) {
	this.categoryTitle = categoryTitle;
}

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}

	
	
	
	
	
	
	
	
	
}

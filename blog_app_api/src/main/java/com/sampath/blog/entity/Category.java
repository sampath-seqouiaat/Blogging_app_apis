package com.sampath.blog.entity;


import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="Category")
public class Category {
	
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer categoryId;
  
  private  String categoryTilte;
  
  private String categoryDescription;
  
  @OneToMany(mappedBy="category",cascade = CascadeType.ALL)
  private List<Post> posts = new ArrayList();
  
  
public Category(Integer categoryId, String categoryTilte, String categoryDescription) {
	super();
	this.categoryId = categoryId;
	this.categoryTilte = categoryTilte;
	this.categoryDescription = categoryDescription;
}

public Integer getCategoryId() {
	return categoryId;
}

public void setCategoryId(Integer categoryId) {
	this.categoryId = categoryId;
}

public String getCategoryTilte() {
	return categoryTilte;
}

public void setCategoryTilte(String categoryTilte) {
	this.categoryTilte = categoryTilte;
}

public String getCategoryDescription() {
	return categoryDescription;
}

public void setCategoryDescription(String categoryDescription) {
	this.categoryDescription = categoryDescription;
}
	
	
	
}

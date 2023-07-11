package com.sampath.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.sampath.blog.playloads.CategoryDto;


@Service
public interface CategoryService {
 
	
CategoryDto createCategory(CategoryDto categoryDto);

CategoryDto updateCategory(CategoryDto categoryDto,Integer categoryId);

void deletCategory(Integer categoryId);

List<CategoryDto> getAllCategory();

CategoryDto getCategoryById(Integer categoryId);
	
	
}

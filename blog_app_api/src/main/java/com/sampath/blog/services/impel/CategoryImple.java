package com.sampath.blog.services.impel;

import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;import com.sampath.blog.entity.Category;
import com.sampath.blog.exceptions.ResourceNotFoundException;
import com.sampath.blog.playloads.CategoryDto;
import com.sampath.blog.respositories.CategoryRepository;
import com.sampath.blog.services.CategoryService;

public class CategoryImple implements CategoryService{
    
	@Autowired
    private CategoryRepository categoryRepository;
	
    @Autowired
    private ModelMapper modelMapper;
	
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class);
		Category addedCategory = this.categoryRepository.save(category);
		
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer categoryId) {
		Category  category = this.categoryRepository.findById(categoryId).orElseThrow(()->new ResourceNotFoundException("Category", "categoryId",categoryId));
	    category.setCategoryTilte(categoryDto.getCategoryTitle());
	    category.setCategoryTilte(categoryDto.getCategoryDescription());
	    Category updatedCategory = this.categoryRepository.save(category);
	    return this.modelMapper.map(updatedCategory, CategoryDto.class);
	}

	@Override
	public void deletCategory(Integer categoryId) {
		// TODO Auto-generated method stub
       Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Category", "categoryId", categoryId));
	   this.categoryRepository.delete(category);
	   
	}

	@Override
	public List<CategoryDto> getAllCategory() {
	  List<Category> categories = this.categoryRepository.findAll();
	  List<CategoryDto> categoryDtos = categories.stream().map((cat)->this.modelMapper.map(categories, CategoryDto.class)).collect(Collectors.toList());
	  return categoryDtos;
	}

	@Override
	public CategoryDto getCategoryById(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("Ctaegory","categoryId",categoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

}

package com.sampath.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sampath.blog.entity.Category;
import com.sampath.blog.playloads.CategoryDto;
import com.sampath.blog.playloads.Response;
import com.sampath.blog.services.CategoryService;

@RestController
@RequestMapping("api/category")
public class CategoryController {
@Autowired
    private CategoryService categoryService;


//create
    @PostMapping("/")
    public ResponseEntity<CategoryDto> creatCategory(@RequestBody CategoryDto categoryDto){
	CategoryDto createCategory = this.categoryService.createCategory(categoryDto);
    return new ResponseEntity<CategoryDto>(createCategory,HttpStatus.CREATED);

}

    @PutMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> updateCategory(@RequestBody CategoryDto categoryDto,@PathVariable Integer categoryId){
	CategoryDto updateCategory = this.categoryService.updateCategory(categoryDto,categoryId);
    return new ResponseEntity<CategoryDto>(updateCategory,HttpStatus.OK);

}

    @DeleteMapping("/{categoryId}")
    public ResponseEntity<Response> deletCategory(@PathVariable Integer categoryId){
	this.categoryService.deletCategory(categoryId);
    return new ResponseEntity<Response>(new Response("categoryId deleted successfully",true),HttpStatus.OK);

}

    @PostMapping("/{categoryId}")
    public ResponseEntity<CategoryDto> getCategoryById(@PathVariable Integer categoryId){
	CategoryDto getCategory = this.categoryService.getCategoryById(categoryId);
    return new ResponseEntity<CategoryDto>(getCategory,HttpStatus.OK);

}

	

    @GetMapping("/")
    public ResponseEntity<List<CategoryDto>> getAllCategory(){
	List<CategoryDto> createCategory = this.categoryService.getAllCategory();
    return ResponseEntity.ok(createCategory);

}

		
		
	
	
	
	
	
	
}

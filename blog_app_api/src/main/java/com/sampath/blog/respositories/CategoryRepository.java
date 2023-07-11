package com.sampath.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampath.blog.entity.Category;

public interface CategoryRepository  extends JpaRepository<Category, Integer>{

}

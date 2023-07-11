package com.sampath.blog.respositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampath.blog.entity.Category;
import com.sampath.blog.entity.Post;
import com.sampath.blog.entity.User;

public interface PostRepository extends JpaRepository<Post, Integer> {

	List<Post> findByUser(User user);
	 
	List<Post> findByCategory(Category category);
	
	
	
	
}

package com.sampath.blog.services;

import java.util.List;

import org.springframework.stereotype.Service;
import com.sampath.blog.playloads.PostDto;

@Service
public interface PostService {

//create
	
	PostDto createPost(PostDto postDto,Integer userId,Integer categoryId);
	
//update
	
	PostDto updatePost(PostDto postDto,Integer postId);
	
//delete
	 
	void deletePost(Integer postId);
	 
//get all post
 
	List<PostDto> getAllPost(); 

// get single post
 
	PostDto getPostById(Integer postId); 

// get all post by category
	
	List<PostDto> getAllPostByCategory(Integer  categoryId);

//get all posts by user
	
    List<PostDto> getPostsByUser(Integer userId);

//search posts
    
    List<PostDto> searchPosts(String keywords);


	
	 
	
	
	
	
	
	
	
	
	
}





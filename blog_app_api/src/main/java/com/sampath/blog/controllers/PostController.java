package com.sampath.blog.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampath.blog.playloads.PostDto;
import com.sampath.blog.playloads.Response;
import com.sampath.blog.services.PostService;

@RestController
@RequestMapping("api/post")
public class PostController {

   @Autowired
   private PostService postService;


//createPost

   @PostMapping("/user:{userId}/category/{categoryId}/post")	
   public ResponseEntity<PostDto> createPost(@RequestBody PostDto postDto,@PathVariable Integer userId,@PathVariable Integer categoryId){
     PostDto createPostDto = this.postService.createPost(postDto, userId, categoryId);
     return new ResponseEntity<PostDto>(createPostDto,HttpStatus.CREATED);
}

//getByUser

   @GetMapping("/userId{userId}/posts")
   public ResponseEntity<List<PostDto>> getPostByUser(@PathVariable Integer userId){
     List<PostDto> getPostDto = this.postService.getPostsByUser(userId);
     return new ResponseEntity<List<PostDto>>(getPostDto,HttpStatus.OK);
	
}
//getByCategory
 
   @GetMapping("/category{categoryId}/posts")
   public ResponseEntity<List<PostDto>> getPostByCategory(@PathVariable Integer categoryId){
     List<PostDto> postsDto = this.postService.getAllPostByCategory(categoryId);
     return new ResponseEntity<List<PostDto>>(postsDto,HttpStatus.OK);
}

   @GetMapping("/posts")
   public ResponseEntity<List<PostDto>> getAllPosts(){
  	 List<PostDto> posts = this.postService.getAllPost();
	 return new ResponseEntity<List<PostDto>>(posts,HttpStatus.OK);
}

   @GetMapping("/posts{postId}")
   public ResponseEntity<PostDto> getPostById(@PathVariable Integer postId){
	 PostDto posts = this.postService.getPostById(postId);
	 return new  ResponseEntity<PostDto>(posts,HttpStatus.OK);
}

   @DeleteMapping("/post{postId}")
   public Response deletPost(@PathVariable Integer postId){
	 this.postService.deletePost(postId);
	  return  new Response("post is succefully deleted",true);
}

   @PutMapping("/post{postId}")
   public ResponseEntity<PostDto> updatePostById(@RequestBody PostDto postDto,@PathVariable Integer postId){
     PostDto post = this.postService.updatePost(postDto, postId);
     return new ResponseEntity<PostDto>(post,HttpStatus.OK);
	
}

	
}

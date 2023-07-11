package com.sampath.blog.controllers;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sampath.blog.playloads.CommentDto;
import com.sampath.blog.playloads.Response;
import com.sampath.blog.services.CommentService;
import com.sampath.blog.services.PostService;

@RestController
@RequestMapping("/api/comment")
public class CommentController {
    
	@Autowired
    private CommentService commentService;
	
	
	@PostMapping("/post/{postId}/comments")
	public ResponseEntity<CommentDto> createComment(@RequestBody  CommentDto commentDto,@PathVariable Integer postId){
	    CommentDto createComment =	this.commentService.createComment(commentDto, postId);
	    return  new ResponseEntity<CommentDto>(createComment,HttpStatus.CREATED);
		}
	
	@DeleteMapping("/comment/{commentId}/")
	public Response deletComment(@PathVariable   Integer commentId) {
	    this.commentService.deletComment(commentId);	
	    return  new Response("Comment is succesfully deleted",true);
	
	
	}
	
	
	
}

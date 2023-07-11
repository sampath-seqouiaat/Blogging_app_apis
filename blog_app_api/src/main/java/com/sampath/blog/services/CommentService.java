package com.sampath.blog.services;

import com.sampath.blog.playloads.CommentDto;

public interface CommentService {
   
    CommentDto createComment(CommentDto commentDto,Integer postId);	
	
	void deletComment(Integer commentId);
	
}

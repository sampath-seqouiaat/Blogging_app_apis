package com.sampath.blog.services.impel;



import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.sampath.blog.entity.Comment;
import com.sampath.blog.entity.Post;
import com.sampath.blog.exceptions.ResourceNotFoundException;
import com.sampath.blog.playloads.CommentDto;
import com.sampath.blog.respositories.CommentRepository;
import com.sampath.blog.respositories.PostRepository;
import com.sampath.blog.services.CommentService;

public class CommentServiceImpel implements CommentService {
    
	@Autowired
	private PostRepository postRepository;
	
	@Autowired
	private CommentRepository  commentRepository;
	 
	@Autowired
	private ModelMapper modelMapper;
	
	
	@Override
	public CommentDto createComment(CommentDto commentDto, Integer postId) {
	  Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "postId", postId));
	  Comment comment = this.modelMapper.map(commentDto, Comment.class);
	  comment.setPost(post);
	  Comment createComment = this.commentRepository.save(comment);
	  return this.modelMapper.map(createComment, CommentDto.class);
	}

	@Override
	public void deletComment(Integer commentId)    {
	  Comment comment = this.commentRepository.findById(commentId).orElseThrow(()-> new ResourceNotFoundException("comment", "commentId", commentId));
	  this.commentRepository.delete(comment);
		
	}

}

package com.sampath.blog.services.impel;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.sampath.blog.entity.Category;
import com.sampath.blog.entity.Post;
import com.sampath.blog.entity.User;
import com.sampath.blog.exceptions.ResourceNotFoundException;
import com.sampath.blog.playloads.PostDto;
import com.sampath.blog.respositories.CategoryRepository;
import com.sampath.blog.respositories.PostRepository;
import com.sampath.blog.respositories.UserRepo;
import com.sampath.blog.services.PostService;

public class PostServiceImplements implements PostService {
	
	@Autowired
	private PostRepository postRepository;

	@Autowired
	private ModelMapper modelMapper;
	 
	@Autowired
	private UserRepo userRepo;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Override
	public PostDto createPost(PostDto postDto,Integer userId,Integer categoryId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user", "userId", userId));
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","categoryId",categoryId));
		
		Post post = this.modelMapper.map(postDto, Post.class);
		post.setImageName("default.png");
		post.setAddedDate(new Date());
		post.setUser(user);
		post.setCategory(category);
		Post newPost = this.postRepository.save(post);
		return this.modelMapper.map(newPost, PostDto.class);
	}

	@Override
	public PostDto updatePost(PostDto postDto, Integer postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","postId", postId));
		post.setTitle(postDto.getTitle());
		post.setImageName(postDto.getImageName());
        post.setCategory(post.getCategory());
        Post updated = this.postRepository.save(post);
		return this.modelMapper.map(updated, PostDto.class);
	}

	@Override
	public void deletePost(Integer postId) {
		Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post","postId", postId));
		this.postRepository.delete(post);
	}

	@Override
	public List<PostDto> getAllPost() {
		List<Post> posts = this.postRepository.findAll();
		List<PostDto> postsDto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postsDto;
	}

	@Override
	public PostDto getPostById(Integer postId) {
	    Post post = this.postRepository.findById(postId).orElseThrow(()-> new ResourceNotFoundException("post", "postId",postId));
		return this.modelMapper.map(post, PostDto.class);
	}

	@Override
	public List<PostDto> getAllPostByCategory(Integer categoryId) {
		Category category = this.categoryRepository.findById(categoryId).orElseThrow(()-> new ResourceNotFoundException("category","categoryId",categoryId));
		List<Post> posts = this.postRepository.findByCategory(category);
		List<PostDto> postDto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
	   return postDto;
	}

	@Override
	public List<PostDto> getPostsByUser(Integer userId) {
		  User userid = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("user","userId",userId));
		  List<Post> posts = this.postRepository.findByUser(userid);
		  List<PostDto> postDto = posts.stream().map((post)->this.modelMapper.map(post, PostDto.class)).collect(Collectors.toList());
		return postDto;
	}

	@Override
	public List<PostDto> searchPosts(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

}

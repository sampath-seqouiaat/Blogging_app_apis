package com.sampath.blog.playloads;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


import com.sampath.blog.entity.Category;
import com.sampath.blog.entity.Comment;
import com.sampath.blog.entity.User;


import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class PostDto {
	
    private String title;
    
    private String content;
    
    private String  imageName;
     
    private Date addedDate;
    
    private User user;
    
    private Category category;
    
    private Set<Comment> comments = new HashSet<>();

	public String getTitle() {
		return title;
	}

	public Set<Comment> getComments() {
		return comments;
	}

	public void setComments(Set<Comment> comments) {
		this.comments = comments;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getImageName() {
		return imageName;
	}

	public void setImageName(String imageName) {
		this.imageName = imageName;
	}

	public Date getAddedDate() {
		return addedDate;
	}

	public void setAddedDate(Date addedDate) {
		this.addedDate = addedDate;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}
   
	
    

}

package com.sampath.blog.entity;



import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="post")
public class Post {
    
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer postId;
    
	 private String title;
     
     private String content;
     
     private String imageName;
    
     private Date addedDate;
	
     @ManyToOne
     private Category category;
	 
     @ManyToOne
     private User user;
     
     @OneToMany(mappedBy = "post",cascade = CascadeType.ALL)
     private Set<Comment> comments =new HashSet<>();
     

	 public Post(Integer postId, String title, String content, String imageName, Date addedDate, Category category,
			User user) {
		super();
		this.postId = postId;
		this.title = title;
		this.content = content;
		this.imageName = imageName;
		this.addedDate = addedDate;
		this.category = category;
		this.user = user;
	}

	 public Integer getPostId() {
		return postId;
	}

	 public void setPostId(Integer postId) {
		this.postId = postId;
	}

	 public String getTitle() {
		return title;
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

	 public Category getCategory() {
		return category;
	}

	 public void setCategory(Category category) {
		this.category = category;
	}

	 public User getUser() {
		return user;
	}

	 public void setUser(User user) {
		this.user = user;
	}

	
	
}

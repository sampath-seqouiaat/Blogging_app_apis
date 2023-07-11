package com.sampath.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampath.blog.entity.Comment;

public interface CommentRepository extends JpaRepository<Comment, Integer>{

}

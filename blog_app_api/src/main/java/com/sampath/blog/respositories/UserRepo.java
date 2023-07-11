package com.sampath.blog.respositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sampath.blog.entity.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}

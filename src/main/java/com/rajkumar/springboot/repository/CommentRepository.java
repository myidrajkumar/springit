package com.rajkumar.springboot.repository;

import com.rajkumar.springboot.model.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {
}

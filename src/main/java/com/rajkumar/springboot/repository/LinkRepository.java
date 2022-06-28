package com.rajkumar.springboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rajkumar.springboot.model.Link;

public interface LinkRepository extends JpaRepository<Link, Long> {
    
}

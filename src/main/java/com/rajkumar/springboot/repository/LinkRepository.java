package com.rajkumar.springboot.repository;

import com.rajkumar.springboot.model.Link;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LinkRepository extends JpaRepository<Link, Long> {

}

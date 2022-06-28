package com.rajkumar.springboot;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;

import com.rajkumar.springboot.model.Comment;
import com.rajkumar.springboot.model.Link;
import com.rajkumar.springboot.repository.CommentRepository;
import com.rajkumar.springboot.repository.LinkRepository;

@SpringBootApplication
@EnableJpaAuditing
public class SpringitApplication {
    
    public static void main(final String[] args) {
        SpringApplication.run(SpringitApplication.class, args);
    }
    
    @Bean
    CommandLineRunner runner(final CommentRepository commentRepository, final LinkRepository linkRepository) {
        return args -> {
            final var link = new Link("Getting Started with SpringBoot2", "https://rajkumar.com/SpringBoot2");
            linkRepository.save(link);
            
            final var comment = new Comment("This springboot2 link is awesome", link);
            commentRepository.save(comment);
            
            link.addComment(comment);
        };
    }
    
}

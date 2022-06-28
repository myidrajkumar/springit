/**
 *
 */
package com.rajkumar.springboot.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rajkumar.springboot.model.Link;
import com.rajkumar.springboot.repository.LinkRepository;

/**
 * @author Rajkumar. S
 *
 */
@RestController
@RequestMapping("/links")
public class LinkController {

    private final LinkRepository linkRepository;
    
    public LinkController(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }

    @GetMapping
    public List<Link> getAllLinks() {
        return this.linkRepository.findAll();
    }
    
    @PostMapping
    public Link createLink(@ModelAttribute final Link link) {
        return this.linkRepository.save(link);
    }

    @GetMapping("/${id}")
    public Optional<Link> getLink(@PathVariable final Long id) {
        return this.linkRepository.findById(id);
    }

    @PutMapping("/${id}")
    public Link updateLink(@PathVariable final Long id, @ModelAttribute final Link link) {
        return this.linkRepository.save(link);
    }

    @DeleteMapping("/${id}")
    public void deleteLink(@PathVariable final Long id) {
        this.linkRepository.deleteById(id);
    }
}

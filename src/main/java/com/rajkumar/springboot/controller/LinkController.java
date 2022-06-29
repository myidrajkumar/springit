/**
 *
 */
package com.rajkumar.springboot.controller;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.rajkumar.springboot.model.Link;
import com.rajkumar.springboot.repository.LinkRepository;

import lombok.extern.log4j.Log4j2;

/**
 * @author Rajkumar. S
 *
 */
@Controller
@Log4j2
public class LinkController {
    
    private final LinkRepository linkRepository;

    public LinkController(final LinkRepository linkRepository) {
        this.linkRepository = linkRepository;
    }
    
    @GetMapping("/")
    public String list(final Model model) {
        model.addAttribute("links", this.linkRepository.findAll());
        return "link/list";
    }
    
    @GetMapping("/link/{id}")
    public String read(@PathVariable final Long id, final Model model) {
        final var link = this.linkRepository.findById(id);
        if (link.isPresent()) {
            model.addAttribute("link", link.get());
            model.addAttribute("success", model.containsAttribute("success"));
            return "link/view";
        }
        return "redirect:/";
    }
    
    @GetMapping("/link/submit")
    public String newLinkForm(final Model model) {
        model.addAttribute("link", new Link());
        return "link/submit";
    }
    
    @PostMapping("/link/submit")
    public String createLink(@Valid final Link link, final BindingResult bindingResult, final Model model,
            final RedirectAttributes redirectAttributes) {
        if (bindingResult.hasErrors()) {
            log.info("Validation errors were found while submitting a new link.");
            model.addAttribute("link", link);
            return "link/submit";
        }
        // save our link
        this.linkRepository.save(link);
        log.info("New link was saved successfully");
        redirectAttributes.addAttribute("id", link.getId()).addFlashAttribute("success", true);
        return "redirect:/link/{id}";
    }
}

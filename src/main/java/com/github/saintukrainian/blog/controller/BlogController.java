package com.github.saintukrainian.blog.controller;

import com.github.saintukrainian.blog.repository.BlogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@RequiredArgsConstructor
public class BlogController {

  private final BlogRepository blogRepository;

  @GetMapping("/blogs")
  public String fetchAllBlogs(Model model) {
    model.addAttribute("blogs", blogRepository.findAll());
    return "blog";
  }
}

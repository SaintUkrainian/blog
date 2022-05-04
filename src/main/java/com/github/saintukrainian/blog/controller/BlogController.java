package com.github.saintukrainian.blog.controller;

import com.github.saintukrainian.blog.entity.Blog;
import com.github.saintukrainian.blog.service.BlogService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
public class BlogController {

  private final BlogService blogService;

  @GetMapping("/blogs/{pageNumber}")
  public String fetchAllBlogs(@PathVariable(required = false) Integer pageNumber, Model model) {
    model.addAttribute("new_blog", new Blog());
    model.addAttribute("blogs", blogService.findBlogsByPageNumber(pageNumber));
    model.addAttribute("pagesCount", blogService.getPagesCount());
    return "blog";
  }

  @PostMapping("/blogs")
  public String postBlog(@ModelAttribute("new_blog") Blog blog) {
    blogService.saveBlog(blog);
    return "redirect:/blogs/0";
  }
}

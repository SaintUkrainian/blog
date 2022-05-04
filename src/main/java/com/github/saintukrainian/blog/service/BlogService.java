package com.github.saintukrainian.blog.service;

import com.github.saintukrainian.blog.entity.Blog;
import com.github.saintukrainian.blog.repository.BlogRepository;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class BlogService {

  private static final int PAGE_SIZE = 4;
  private static final int ZERO_PAGE = 0;

  private final BlogRepository blogRepository;

  public List<Blog> findBlogsByPageNumber(Integer pageNumber) {
    return blogRepository.findAllDistinctByOrderByWriteDateDesc(
            PageRequest.of(Objects.requireNonNullElse(pageNumber, ZERO_PAGE), PAGE_SIZE))
        .getContent();
  }

  public void saveBlog(Blog blog) {
    if (blog != null) {
      blog.setWriteDate(LocalDateTime.now());
      blogRepository.save(blog);
    }
  }

  public long getPagesCount() {
    long blogsCount = blogRepository.countDistinctBy();
    return blogsCount / PAGE_SIZE;
  }
}

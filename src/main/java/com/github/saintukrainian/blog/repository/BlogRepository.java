package com.github.saintukrainian.blog.repository;

import com.github.saintukrainian.blog.entity.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BlogRepository extends JpaRepository<Blog, Integer> {

  Page<Blog> findAllDistinctByOrderByWriteDateDesc(Pageable pageable);

  long countDistinctBy();
}

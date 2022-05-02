package com.github.saintukrainian.blog.entity;

import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Size;
import lombok.Data;

@Data
@Entity(name = "blog")
public class Blog {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "blog_id")
  private Long blogId;

  @Column(name = "author")
  @Size(max = 70)
  private String author;

  @Column(name = "text")
  @Size(max = 140)
  private String text;

  @Column(name = "write_date")
  private LocalDateTime writeDate;
}

package com.github.saintukrainian.blog.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import lombok.Data;

@Data
@Entity
@Table(name = "blog")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Blog {

  @Id
  @SequenceGenerator(name = "blogIdSeq", sequenceName = "blog_blog_id_seq", allocationSize = 1)
  @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "blogIdSeq")
  @Column(name = "blog_id")
  private Integer blogId;

  @Column(name = "author")
  private String author;

  @Column(name = "text")
  private String text;

  @Column(name = "write_date")
  private LocalDateTime writeDate;
}

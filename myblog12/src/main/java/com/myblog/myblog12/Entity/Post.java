package com.myblog.myblog12.Entity;

import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name="posts")
@Data //by this getters and setters are automatically created
@AllArgsConstructor //automatically constructors with the arguments will be created
@NoArgsConstructor //it automatically creates a default constructor.
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String title;
    private String description;
    private String content;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "post")
    private List<Comment> comments;
}


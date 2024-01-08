package com.myblog.myblog12.Entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

}

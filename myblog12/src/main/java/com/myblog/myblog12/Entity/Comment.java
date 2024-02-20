package com.myblog.myblog12.Entity;


import javax.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

    @Entity
    @Table(name = "comments")
    @Data
    @AllArgsConstructor
    @NoArgsConstructor
    public class Comment {
        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        private long id;

        private String text;

        private String email;
        @ManyToOne
        @JoinColumn(name = "post_id", nullable = false)
        private Post post;

        // Other fields, getters, setters, and constructors
    }


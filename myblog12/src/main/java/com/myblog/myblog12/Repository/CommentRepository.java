package com.myblog.myblog12.Repository;

import com.myblog.myblog12.Entity.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentRepository extends JpaRepository<Comment, Long> {

}

package com.myblog.myblog12.Service;

import com.myblog.myblog12.Payload.CommentDto;


public interface CommentService {
   CommentDto createComment(CommentDto commentDto,long postId);

   void deleteComment(long id);

   CommentDto updateComment(long id, CommentDto commentDto, long postId);
}

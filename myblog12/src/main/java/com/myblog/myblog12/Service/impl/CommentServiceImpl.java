package com.myblog.myblog12.Service.impl;


import com.myblog.myblog12.Entity.Comment;
import com.myblog.myblog12.Entity.Post;
import com.myblog.myblog12.Exception.ResourceNotFoundException;
import com.myblog.myblog12.Payload.CommentDto;
import com.myblog.myblog12.Repository.CommentRepository;
import com.myblog.myblog12.Repository.PostRepository;
import com.myblog.myblog12.Service.CommentService;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
public class CommentServiceImpl implements CommentService {

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    private ModelMapper modelMapper;
    public CommentServiceImpl(PostRepository postRepository, CommentRepository commentRepository, ModelMapper modelMapper) {
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
        this.modelMapper=modelMapper;
    }

    @Override
    public CommentDto createComment(CommentDto commentDto, long postId) {
       Post post= postRepository.findById(postId).orElseThrow(
                ()-> new ResourceNotFoundException("Post Not Found with id "+postId)
        );
        Comment comment= new Comment();
        comment.setEmail(commentDto.getEmail());
        comment.setText(commentDto.getText());
        comment.setPost(post);

        Comment savedComment = commentRepository.save(comment);

        CommentDto dto= new CommentDto();
        dto.setId(savedComment.getId());
        dto.setEmail(savedComment.getEmail());
        dto.setText(savedComment.getText());
        return dto;
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public CommentDto updateComment(long id, CommentDto commentDto, long postId) {
        Post post = postRepository.findById(postId).orElseThrow(
                () -> new ResourceNotFoundException("Post Not Found with id " + postId)
        );
        Comment comment = commentRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("Comment Not Found for Id: " + id)
        );

        Comment c = mapToEntity(commentDto);
        c.setPost(post);
        c.setId(comment.getId());
        Comment savedComment = commentRepository.save(c);

        return mapToDto(savedComment);
    }

    CommentDto mapToDto(Comment comment){
        CommentDto dto = modelMapper.map(comment, CommentDto.class);
        return dto;
    }

    Comment mapToEntity(CommentDto commentDto){
        Comment comment = modelMapper.map(commentDto, Comment.class);
        return comment;
    }
}

package com.myblog.myblog12.Service.impl;
import com.myblog.myblog12.Entity.Post;
import com.myblog.myblog12.Payload.PostDto;
import com.myblog.myblog12.Repository.PostRepository;
import com.myblog.myblog12.Service.PostService;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post= new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        Post savedPost=postRepository.save(post);

        PostDto dto= new PostDto();
        dto.setTitle(savedPost.getTitle());
        dto.setDescription(savedPost.getDescription());
        dto.setContent(savedPost.getContent());
        return dto;
    }
}

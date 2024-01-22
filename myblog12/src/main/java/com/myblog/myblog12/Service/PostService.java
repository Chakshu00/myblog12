package com.myblog.myblog12.Service;

import com.myblog.myblog12.Payload.PostDto;

import java.util.List;


public interface PostService {
    PostDto createPost(PostDto postDto);

    PostDto getPostById(long id);

    List<PostDto> getAllPosts(int pageNo, int pageSize);
}

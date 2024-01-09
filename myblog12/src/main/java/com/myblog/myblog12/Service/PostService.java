package com.myblog.myblog12.Service;

import com.myblog.myblog12.Payload.PostDto;
import org.springframework.stereotype.Service;


public interface PostService {
    PostDto createPost(PostDto postDto);
}

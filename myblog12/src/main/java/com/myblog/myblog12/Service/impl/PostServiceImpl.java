package com.myblog.myblog12.Service.impl;
import com.myblog.myblog12.Entity.Post;
import com.myblog.myblog12.Exception.ResourceNotFoundException;
import com.myblog.myblog12.Payload.PostDto;
import com.myblog.myblog12.Repository.PostRepository;
import com.myblog.myblog12.Service.PostService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class PostServiceImpl implements PostService {

    private PostRepository postRepository;
    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }
    @Override
    public PostDto createPost(PostDto postDto) {
        Post post = mapToEntity(postDto);
        Post savedPost=postRepository.save(post);

        PostDto dto=mapToDto(savedPost); // this becomes method will make the things resusable
        return dto;
    }

    @Override
    public PostDto getPostById(long id) {
        //orElseThrow is a java 8 feature for throwing a exception
       Post post= postRepository.findById(id).orElseThrow(
               ()-> new ResourceNotFoundException("Post not found with id: "+id)
        );

        PostDto dto= new PostDto();
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }

    @Override
    public List<PostDto> getAllPosts(int pageNo, int pageSize, String sortBy, String sortDir) {
       Sort sort= (sortDir.equalsIgnoreCase(Sort.Direction.ASC.name()))?Sort.by(sortBy).ascending():Sort.by(sortBy).descending();
       Pageable pageable= PageRequest.of(pageNo,pageSize, sort); //for pagination and select  "of" with sort object
        Page<Post> pagedpost = postRepository.findAll(pageable);//select findAll which have pageable
        List<Post> posts = pagedpost.getContent();// to convert Page<Post> to List<Post>

        List<PostDto> dtos = posts.stream().map(p -> mapToDto(p)).collect(Collectors.toList());
        return dtos;
    }
    PostDto mapToDto(Post post){ // we are using this method in createPost (resuing it)
        PostDto dto= new PostDto();
        dto.setId(post.getId());
        dto.setTitle(post.getTitle());
        dto.setDescription(post.getDescription());
        dto.setContent(post.getContent());
        return dto;
    }
    Post mapToEntity(PostDto postDto){ // Dto to entity converting
        Post post= new Post();
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setContent(postDto.getContent());
        return post;
    }
}

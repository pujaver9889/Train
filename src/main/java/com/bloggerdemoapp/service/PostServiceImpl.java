package com.bloggerdemoapp.service;

import com.bloggerdemoapp.DTO.PostDto;
import com.bloggerdemoapp.entity.Post;
import com.bloggerdemoapp.repository.PostRepository;
import org.springframework.stereotype.Service;

@Service
public class PostServiceImpl implements PostService{
    private PostRepository postRepository;

    public PostServiceImpl(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    @Override
    public PostDto addPostService(PostDto dto) {
        Post post= new Post();
        post.setName(dto.getName());
        post.setContent(dto.getContent());

        //save the entity
        Post savedPostService = postRepository.save(post);
        PostDto postDto= new PostDto();
        postDto.setId(savedPostService.getId());
        postDto.setName(savedPostService.getName());
        postDto.setContent(savedPostService.getContent());
        return postDto;
    }
}

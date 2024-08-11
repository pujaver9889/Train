package com.bloggerdemoapp.contoller;

import com.bloggerdemoapp.DTO.PostDto;
import com.bloggerdemoapp.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/post")
public class PostController {

//http://localhost:8081/api/v1/post

    private PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }
    @PostMapping
    public ResponseEntity<PostDto> addPostService(@RequestBody PostDto dto) {
        PostDto postDto = postService.addPostService(dto);
        return new ResponseEntity<>(postDto, HttpStatus.CREATED);
    }
}


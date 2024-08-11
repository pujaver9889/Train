package com.bloggerdemoapp.contoller;


import com.bloggerdemoapp.DTO.CommentDto;
import com.bloggerdemoapp.entity.Comment;
import com.bloggerdemoapp.entity.Post;
import com.bloggerdemoapp.repository.CommentRepository;
import com.bloggerdemoapp.repository.PostRepository;
import com.bloggerdemoapp.service.CommentService;
import com.bloggerdemoapp.service.PostService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/v1/comment")
public class CommentController {

//http://localhost:8081/api/v1/post
    private CommentService commentService;

    private PostRepository postRepository;
    private CommentRepository commentRepository;

    public CommentController(CommentService commentService, PostRepository postRepository, CommentRepository commentRepository) {
        this.commentService = commentService;
        this.postRepository = postRepository;
        this.commentRepository = commentRepository;
    }
    //http://localhost:8081/api/v1/comment?1
    @PostMapping
    public ResponseEntity<CommentDto> addComment(@RequestParam long postId,  @RequestBody CommentDto dto) {
        CommentDto commentDto = commentService.addComment(dto,postId);
        return new ResponseEntity<>(commentDto, HttpStatus.CREATED);

    }
}

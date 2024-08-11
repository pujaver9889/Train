package com.bloggerdemoapp.service;

import com.bloggerdemoapp.DTO.CommentDto;
import com.bloggerdemoapp.entity.Comment;
import com.bloggerdemoapp.entity.Post;
import com.bloggerdemoapp.repository.CommentRepository;
import com.bloggerdemoapp.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CommentServiceImpl implements CommentService{

    private CommentRepository commentRepository;
   private  PostRepository postRepository;

    public CommentServiceImpl(CommentRepository commentRepository, PostRepository postRepository) {
        this.commentRepository = commentRepository;
        this.postRepository = postRepository;
    }


    @Override
    public CommentDto addComment(CommentDto dto, long postId) {

        Comment comment=new Comment();
        comment.setEmail(dto.getEmail());
        comment.setContent(dto.getContent());
        Post post = postRepository.findById(postId).get();
        comment.setPost(post);
        Comment savedComment = commentRepository.save(comment);
        CommentDto commentDto=new CommentDto();

        commentDto.setId(savedComment.getId());
        commentDto.setEmail(savedComment.getEmail());
        commentDto.setContent(savedComment.getContent());
        commentDto.setPost(savedComment.getPost());
        return commentDto;

    }
}

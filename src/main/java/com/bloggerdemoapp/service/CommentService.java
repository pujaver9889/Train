package com.bloggerdemoapp.service;

import com.bloggerdemoapp.DTO.CommentDto;
import com.bloggerdemoapp.entity.Comment;

public interface CommentService {

   CommentDto addComment(CommentDto dto, long postId);
}

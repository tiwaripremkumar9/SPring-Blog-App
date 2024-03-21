package com.blogapp.techviz.base.controllers;

import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.services.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/post")
public class PostController {

    @Autowired
    private PostService postService;

    @PostMapping("/{userId}/{categoryId}")
    public ResponseEntity<PostDTO> createPost(@RequestBody PostDTO postDTO, @PathVariable Integer userId, @PathVariable Integer categoryId)
    {
        PostDTO postDto = postService.createPost(postDTO,userId,categoryId);
        System.out.println("Inside POstController: "+postDto.toString());
        return new ResponseEntity<>(postDTO, HttpStatus.CREATED);
    }
}

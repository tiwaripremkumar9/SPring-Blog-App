package com.blogapp.techviz.base.services;

import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.Pojo.Post;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    List<Post> getAllPost();

    List<Post> getPostsByCategory();

    List<Post> getPostByUser();
}

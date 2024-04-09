package com.blogapp.techviz.base.services;

import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.Pojo.Post;
import com.blogapp.techviz.base.Response.PostResponse;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.List;

public interface PostService {

    PostDTO createPost(PostDTO postDTO, Integer userId, Integer categoryId);
    PostDTO updatePost(PostDTO postDTO, Integer postId);

    void deletePost(Integer postId);

    List<PostDTO> getAllPost();

    List<PostDTO> getPostsByCategory(Integer catgId);

    List<PostDTO> getPostByUser(Integer userId);

    //List<PostDTO> getAllPostByPagination(Integer pageSize, Integer pageNumber);

    PostResponse getAllPostByPagination(Integer pageSize, Integer pageNumber);

}

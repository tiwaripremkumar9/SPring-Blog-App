package com.blogapp.techviz.base.controllers;

import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.Response.DeleteResponse;
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

    @GetMapping("/category/{categoryId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByCategory(@PathVariable Integer categoryId){
        List<PostDTO> postsByCategory = postService.getPostsByCategory(categoryId);
        return new ResponseEntity<>(postsByCategory, HttpStatus.FOUND);
    }

    @GetMapping("/user/{userId}/posts")
    public ResponseEntity<List<PostDTO>> getPostByUser(@PathVariable Integer userId){
        List<PostDTO> postsByUser = postService.getPostByUser(userId);
        return new ResponseEntity<>(postsByUser, HttpStatus.FOUND);
    }

    @RequestMapping("/")
    public ResponseEntity<List<PostDTO>> getAllPost(){
        List<PostDTO> posts = postService.getAllPost();
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }

    /*
    by default shows 4 entries for a single page if no value passed.
    page number and page size value can be passed as below
    http://localhost:8080/api/post/posts/pageination?pageNumber=2&pageSize=3
     */

    @GetMapping("/posts/pageination")
    public ResponseEntity<List<PostDTO>> getAllPostsByPaginations(
            @RequestParam(value = "pageNumber", defaultValue = "1", required = false) Integer pageNum,
            @RequestParam(value = "pageSize", defaultValue = "4", required = false)  Integer pageSize) {

        List<PostDTO> posts = postService.getAllPostByPagination(pageSize, pageNum);
        return new ResponseEntity<>(posts, HttpStatus.FOUND);
    }

    @RequestMapping("/update/{postId}")
    public ResponseEntity<PostDTO> updatePost(@RequestBody PostDTO postDTO, @PathVariable Integer postId){
        PostDTO aDTO = postService.updatePost(postDTO, postId);
        return new ResponseEntity<>(aDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{postId}")
    public ResponseEntity<DeleteResponse> deletePost(@PathVariable Integer postId){
        postService.deletePost(postId);
        DeleteResponse delResp = new DeleteResponse();
        delResp.setMessage("Deleted Post with Id: "+postId);
        delResp.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(delResp, HttpStatus.OK);
    }
}

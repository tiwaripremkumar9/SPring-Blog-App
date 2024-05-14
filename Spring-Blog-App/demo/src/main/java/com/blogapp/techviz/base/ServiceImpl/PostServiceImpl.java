package com.blogapp.techviz.base.ServiceImpl;

import com.blogapp.techviz.base.DTO.CategoryDTO;
import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.ExceptionHandling.ResourceNotFoundException;
import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.Pojo.Post;
import com.blogapp.techviz.base.Pojo.User;
import com.blogapp.techviz.base.Response.PostResponse;
import com.blogapp.techviz.base.repositories.CategoryRepo;
import com.blogapp.techviz.base.repositories.PostRepo;
import com.blogapp.techviz.base.repositories.UserRepo;
import com.blogapp.techviz.base.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private UserRepo userRepo;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public PostDTO createPost(PostDTO postDTO, Integer userID, Integer categoryId) {
        Post aPost = modelMapper.map(postDTO, Post.class);
        aPost.setImageName("default.png");
        User user = userRepo.findById(userID).get();
        Category category = categoryRepo.findById(categoryId).get();
        aPost.setUser(user);
        aPost.setCategory(category);
        Post savedPost = postRepo.save(aPost);
        System.out.println("Inside PostServiceImpl PostDTO: "+modelMapper.map(savedPost, PostDTO.class).toString());
        PostDTO savedDTO = modelMapper.map(savedPost, PostDTO.class);
        return savedDTO;
    }

    @Override
    public PostDTO updatePost(PostDTO postDTO, Integer postId) {
        Post aPost = postRepo.findById(postId).get();
        Category category = aPost.getCategory();
        aPost.setCategory(category);
        aPost.setTitle(aPost.getTitle());
        aPost.setContent(aPost.getContent());
        List<PostDTO> postDtos = new ArrayList<>();

        Post savedPost = postRepo.save(aPost);

        PostDTO savedPostDTO = modelMapper.map(savedPost, PostDTO.class);
        return savedPostDTO;
    }

    @Override
    public void deletePost(Integer postId) {
        Post aPost = postRepo.findById(postId).get();
        postRepo.delete(aPost);
    }

    @Override
    public List<PostDTO> getAllPost() {
        List<Post> allPosts = postRepo.findAll();
        List<PostDTO> postDtos = new ArrayList<>();
        for (Post each: allPosts) {
            postDtos.add(modelMapper.map(each, PostDTO.class));
        }
        return postDtos;
    }

    public PostResponse getAllPostByPagination(Integer pageSize, Integer pageNumber, String sortBy) {
        ;
       // Pageable pageableObj = PageRequest.of(pageNumber, pageSize);
        /*
        PageRequest of(int pageNumber, int pageSize) -> Creates a new unsorted PageRequest.
        PageRequest of(int pageNumber, int pageSize, Sort sort) -> Creates a new PageRequest with sort parameters applied.

         */
        Pageable pageableObj = PageRequest.of(pageNumber, pageSize, Sort.by(sortBy));
        Page<Post> pageObj = postRepo.findAll(pageableObj);
        List<Post> posList = pageObj.getContent();
        List<PostDTO> postDtos = new ArrayList<>();
        for (Post each: posList) {
            postDtos.add(modelMapper.map(each, PostDTO.class));
        }

        PostResponse postResponse = new PostResponse();
        postResponse.setContent(postDtos);
        postResponse.setPageNumber(pageObj.getNumber());
        postResponse.setPageSize(pageObj.getSize());
        postResponse.setTotalElements(pageObj.getTotalElements());
        postResponse.setTotalPages(pageObj.getTotalPages());
        postResponse.setLastPage(pageObj.isLast());
        return postResponse;
    }

    @Override
    public List<PostDTO> getPostsByCategory(Integer categoryId) {
        Category catg = categoryRepo.findById(categoryId).get();
        if(catg == null)
            throw new ResourceNotFoundException("Category with id: "+categoryId+" not found");
         List<Post> posts = postRepo.findByCategory(catg);
         List<PostDTO> postDtos = new ArrayList<>();
        for (Post each: posts) {
            postDtos.add(modelMapper.map(each, PostDTO.class));
        }
        return postDtos;
    }

    /*
    get posts by user
     */
    @Override
    public List<PostDTO> getPostByUser(Integer userId) {
        User user = userRepo.findById(userId).get();
        if(user == null)
            throw new ResourceNotFoundException("User with id: "+userId+" not found");
        List<Post> posts = postRepo.findByUser(user); //NOTE: we are using findByUser here, not find by id
        List<PostDTO> postDtos = new ArrayList<>();
        for (Post each: posts) {
            postDtos.add(modelMapper.map(each, PostDTO.class));
        }
        return postDtos;
    }
}

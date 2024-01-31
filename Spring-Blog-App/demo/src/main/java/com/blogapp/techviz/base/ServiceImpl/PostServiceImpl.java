package com.blogapp.techviz.base.ServiceImpl;

import com.blogapp.techviz.base.DTO.PostDTO;
import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.Pojo.Post;
import com.blogapp.techviz.base.Pojo.User;
import com.blogapp.techviz.base.repositories.CategoryRepo;
import com.blogapp.techviz.base.repositories.PostRepo;
import com.blogapp.techviz.base.repositories.UserRepo;
import com.blogapp.techviz.base.services.PostService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
        return null;
    }

    @Override
    public void deletePost(Integer postId) {

    }

    @Override
    public List<Post> getAllPost() {
        return null;
    }

    @Override
    public List<Post> getPostsByCategory() {
        return null;
    }

    @Override
    public List<Post> getPostByUser() {
        return null;
    }
}

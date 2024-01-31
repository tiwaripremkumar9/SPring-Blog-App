package com.blogapp.techviz.base.repositories;

import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.Pojo.Post;
import com.blogapp.techviz.base.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostRepo extends JpaRepository<Post, Integer> {

    List<Post> findByUser(User user);
    List<Post> findByCategory(Category category);
}

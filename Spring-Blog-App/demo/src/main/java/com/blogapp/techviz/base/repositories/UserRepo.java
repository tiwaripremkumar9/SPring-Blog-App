package com.blogapp.techviz.base.repositories;

import com.blogapp.techviz.base.Pojo.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
}

package com.blogapp.techviz.base.repositories;

import com.blogapp.techviz.base.Pojo.Category;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoryRepo  extends JpaRepository<Category, Integer> {
}

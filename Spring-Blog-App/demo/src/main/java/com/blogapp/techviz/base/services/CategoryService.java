package com.blogapp.techviz.base.services;

import com.blogapp.techviz.base.DTO.CategoryDTO;

import java.util.List;

public interface CategoryService {

    //create
    CategoryDTO createCategory(CategoryDTO categoryDTO);
    CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId);

    CategoryDTO getCategory(Integer categoryId);

    void deleteCategory(Integer categoryId);

    List<CategoryDTO> getAllCategories();


}

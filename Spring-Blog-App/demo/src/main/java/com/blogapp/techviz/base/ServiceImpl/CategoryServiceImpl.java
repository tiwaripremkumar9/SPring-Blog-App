package com.blogapp.techviz.base.ServiceImpl;

import com.blogapp.techviz.base.DTO.CategoryDTO;
import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.repositories.CategoryRepo;
import com.blogapp.techviz.base.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {
    @Autowired
    private ModelMapper modelMapper;
    @Autowired
    private CategoryRepo categoryRepo;
    @Override
    public CategoryDTO createCategory(CategoryDTO categoryDTO) {
        Category category = modelMapper.map(categoryDTO, Category.class);
        Category savedCategory = categoryRepo.save(category);
        CategoryDTO savedCategoryDTO =  modelMapper.map(savedCategory, CategoryDTO.class);
        return savedCategoryDTO;
    }

    @Override
    public CategoryDTO updateCategory(CategoryDTO categoryDTO, Integer categoryId) {
        Optional<Category> category = categoryRepo.findById(categoryId);
        Category categoryObj = category.orElse(null);
        if(categoryObj == null)
            return new CategoryNotFoundException("Category with category id: "+categoryId+" doesn't exist");
        categoryObj.setCategoryType(categoryDTO.getCategoryType());
        categoryObj.setCategoryDescription(categoryObj.getCategoryDescription());
        Category updatedCategory = categoryRepo.save(categoryObj);
        CategoryDTO updatedCategoryDTO  = modelMapper.map(updatedCategory, CategoryDTO.class);
        return updatedCategoryDTO;
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        return null;
    }

    @Override
    public void deleteCategory(Integer categoryId) {

    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        return null;
    }
}

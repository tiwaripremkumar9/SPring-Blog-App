package com.blogapp.techviz.base.ServiceImpl;

import com.blogapp.techviz.base.DTO.CategoryDTO;
import com.blogapp.techviz.base.ExceptionHandling.ResourceNotFoundException;
import com.blogapp.techviz.base.Pojo.Category;
import com.blogapp.techviz.base.repositories.CategoryRepo;
import com.blogapp.techviz.base.services.CategoryService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ModelAttribute;

import java.util.ArrayList;
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
        Category categoryObj = category.get();
        if(categoryObj == null)
            throw new ResourceNotFoundException("Category with category id: "+categoryId+" doesn't exist", categoryId);
        categoryObj.setCategoryType(categoryDTO.getCategoryType());
        categoryObj.setCategoryDescription(categoryObj.getCategoryDescription());
        Category updatedCategory = categoryRepo.save(categoryObj);
        CategoryDTO updatedCategoryDTO  = modelMapper.map(updatedCategory, CategoryDTO.class);
        return updatedCategoryDTO;
    }

    @Override
    public CategoryDTO getCategory(Integer categoryId) {
        Optional<Category> categoryObj = categoryRepo.findById(categoryId);
        /*
        In Java, get() is a method of the Optional class that returns the actual object type if it is present. If the Optional object is empty, get() throws a NoSuchElementException 1.
           On the other hand, orElse() is another method of the Optional class that returns the specified default value if the Optional object is empty. Otherwise, it returns the actual object type
         */
        if(!categoryObj.isPresent())
             throw new ResourceNotFoundException("Category with id: "+categoryId+" not found", categoryId);
        Category category = categoryObj.get();
        CategoryDTO categoryDTO = modelMapper.map(category, CategoryDTO.class);
        return categoryDTO;
    }

    @Override
    public void deleteCategory(Integer categoryId) {
        Optional<Category> categoryObj = categoryRepo.findById(categoryId);
        if(!categoryObj.isPresent())
            throw new ResourceNotFoundException("Category with id: "+categoryId+" not found", categoryId);
        Category category = categoryObj.get();
        categoryRepo.delete(category);
    }

    @Override
    public List<CategoryDTO> getAllCategories() {
        List<Category> categoryList = categoryRepo.findAll();
        if(categoryList.isEmpty())
            throw new ResourceNotFoundException("Category list is empty");
        List<CategoryDTO> dtoList = new ArrayList<>();
        for (Category anObj:
            categoryList ) {
            dtoList.add(modelMapper.map(anObj, CategoryDTO.class));
        }
        return dtoList;
    }
}

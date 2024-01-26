package com.blogapp.techviz.base.controllers;

import com.blogapp.techviz.base.DTO.CategoryDTO;
import com.blogapp.techviz.base.Response.DeleteResponse;
import com.blogapp.techviz.base.services.CategoryService;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;
    @PostMapping("/create")
    public ResponseEntity<CategoryDTO> createCategory(@RequestBody CategoryDTO dtoObj){
      CategoryDTO createdCategoryDTO =  categoryService.createCategory(dtoObj);
      return new ResponseEntity<>(createdCategoryDTO, HttpStatus.CREATED);
    }

    @PostMapping("/update/{catgId}")
    public ResponseEntity<CategoryDTO> updateCategory(@RequestBody CategoryDTO dtoObj,@PathVariable("catgId") Integer categoryId){
        CategoryDTO updatedCategoryDTO =  categoryService.updateCategory(dtoObj, categoryId);
        return new ResponseEntity<>(updatedCategoryDTO, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{categoryId}")
    public ResponseEntity<DeleteResponse> deleteCategory(@PathVariable Integer categoryId){
        DeleteResponse resp = new DeleteResponse();
        resp.setMessage("category with Id: "+categoryId+" Deleted");
        resp.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(resp, HttpStatus.OK);
    }

    @GetMapping("/get/{catgId}")
    public ResponseEntity<CategoryDTO> getCategory(@PathVariable("catgId") Integer categoryId){
        CategoryDTO categoryDTO =  categoryService.getCategory( categoryId);
        return new ResponseEntity<>(categoryDTO, HttpStatus.FOUND);
    }

    @GetMapping("/")
    public ResponseEntity<List<CategoryDTO>> getAllCategory(){
        List<CategoryDTO> categoryDTOList =  categoryService.getAllCategories();
        return new ResponseEntity<>(categoryDTOList, HttpStatus.FOUND);
    }






}

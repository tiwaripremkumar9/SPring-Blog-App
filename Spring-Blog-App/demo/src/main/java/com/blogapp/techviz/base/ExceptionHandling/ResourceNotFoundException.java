package com.blogapp.techviz.base.ExceptionHandling;

public class ResourceNotFoundException extends RuntimeException{

    private Integer id;


    public ResourceNotFoundException(String message, Integer fieldValue) {
        super(message);
        this.id = fieldValue;
    }
}

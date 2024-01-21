package com.blogapp.techviz.base.ExceptionHandling;

public class ResourceEmptyException extends RuntimeException{
    public ResourceEmptyException(String message) {
        super(message);
    }
}

package com.blogapp.techviz.base.ExceptionHandling;

import com.blogapp.techviz.base.Pojo.User;
import org.apache.coyote.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

/*
sending the customised error response by setting the error response object
 */

@ControllerAdvice
public class UserExceptionHandler {
    public UserExceptionHandler() {
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(ResourceNotFoundException ex){
        UserErrorResponse resp = new UserErrorResponse();
        resp.setMessage(ex.getMessage());
        resp.setStatus(HttpStatus.NOT_FOUND.value()); //.Value returns integer value of status i.e status code
        resp.setTimestamp(System.currentTimeMillis());
        return new ResponseEntity<>(resp,HttpStatus.NOT_FOUND);
    }
}

package com.blogapp.techviz.base.ExceptionHandling;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler
    public ResponseEntity<Map<String, String>> handleInvalidArgsException(MethodArgumentNotValidException ex){
        //create a new hashmap of the fields of error, and the error message,
        //we will send this map as the response to error
        Map<String,String> errorRespMap = new HashMap<>();
        /*
        [BindingResult] is Spring’s object that holds the result of the validation and binding and contains errors that may have occurred.
        The BindingResult must come right after the model object that is validated or else Spring will fail to validate the object and throw an exception.
        When Spring sees @Valid, it tries to find the validator for the object being validated.
        Spring automatically picks up validation annotations if you have “annotation-driven” enabled.
        Spring then invokes the validator and puts any errors in the BindingResult and adds the BindingResult to the view model.
         */
        BindingResult bindingResult = ex.getBindingResult();
        //returns a list of errors, where each error is of ObjectError type.
        List<ObjectError> errorList = bindingResult.getAllErrors();
        /*
        case each Object error to FieldError type and put the error field and its message in the map.
         */
        for (ObjectError err:
             errorList) {
            String fieldName = ((FieldError) err).getField();
            String message = ((FieldError) err).getDefaultMessage();
            errorRespMap.put(fieldName,message);
        }
        // return the error response map
        return new ResponseEntity<>(errorRespMap, HttpStatus.BAD_REQUEST);

    }
}

package com.blogapp.techviz.base.controllers;

import com.blogapp.techviz.base.DTO.UserDTO;
import com.blogapp.techviz.base.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
public class UserController {

    @Autowired
    private UserService userService;

    //GET a user
    @GetMapping("/get-user/{id}")
    public ResponseEntity<UserDTO> getUserById(@PathVariable int id){
         UserDTO aUserDTO = userService.getUserById(id);
         return new ResponseEntity<>(aUserDTO, HttpStatus.FOUND);
    }
    //PUT a User
    //POST a User
    @PostMapping("/create")
    public ResponseEntity<UserDTO> createAUser(@RequestBody UserDTO aUserdto){
        UserDTO newUserDTO = userService.createUser(aUserdto);
        return new ResponseEntity<>(newUserDTO, HttpStatus.CREATED);
    }
    //DELETE a User

    //GET all Users
    @GetMapping("/get-all")
    public ResponseEntity<List<UserDTO>> getAll(){
        List<UserDTO> aList = userService.getAllUsers();
        return new ResponseEntity<>(aList, HttpStatus.FOUND);
    }
}

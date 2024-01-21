package com.blogapp.techviz.base.services;

import com.blogapp.techviz.base.DTO.UserDTO;
import com.blogapp.techviz.base.Pojo.User;

import java.util.List;

public interface UserService {

    UserDTO createUser(UserDTO user);
    UserDTO updateUser(UserDTO user, Integer id);
    UserDTO getUserById(Integer id);

    List<UserDTO> getAllUsers();

    void deleteAUserById(Integer id);



}

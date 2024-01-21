package com.blogapp.techviz.base.ServiceImpl;

import com.blogapp.techviz.base.DTO.UserDTO;
import com.blogapp.techviz.base.ExceptionHandling.ResourceEmptyException;
import com.blogapp.techviz.base.Pojo.User;
import com.blogapp.techviz.base.repositories.UserRepo;
import com.blogapp.techviz.base.services.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import com.blogapp.techviz.base.ExceptionHandling.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;
    @Autowired
    private ModelMapper modelMapper;

    @Override
    public UserDTO createUser(UserDTO userDTO) {
        User user =this.dtoToUser(userDTO);
        User savedUSer = userRepo.save(user);
        return this.userToDTO(savedUSer);
    }

    @Override
    public UserDTO updateUser(UserDTO userDTO, Integer id) {
        //User aUser = this.dtoToUser(userDTO);
        User aUser = userRepo.findById(id).orElse(null);
        if(aUser == null)
            throw new ResourceNotFoundException("User with id: "+id+" doesn't exist ", id);
        User updatedUser =  userRepo.save(aUser);
        return this.userToDTO(updatedUser);
    }

    @Override
    public UserDTO getUserById(Integer id) {
        User foundUser = userRepo.findById(id).orElse(null);
        if(foundUser == null)
            throw new ResourceNotFoundException("User with id: "+id+" is not found", id);
        return this.userToDTO(foundUser);
    }

    @Override
    public List<UserDTO> getAllUsers() {
         List<User> userLists = userRepo.findAll();
         if(userLists.isEmpty())
             throw new ResourceEmptyException("We don't have any user existing as of now !!!");
         List<UserDTO> userDTOList = new ArrayList<>();
        for (User each:
             userLists) {
            userDTOList.add(this.userToDTO(each));
        }
        return userDTOList;
    }

    @Override
    public void deleteAUserById(Integer id) {
        User aUser = userRepo.findById(id).orElse(null);
        if(aUser == null)
            throw new ResourceNotFoundException("User with id: "+id+" doesn't exist ", id);
        userRepo.delete(aUser);
    }

    /*
    Use the ModelMapper instance to map your entity objects to DTOs and vice versa. Here’s an example:
     */
    private User dtoToUser(UserDTO dtoObj){
          User user = modelMapper.map(dtoObj, User.class); //map method takes source object and destination object.
//        User user = new User();
//        user.setId(dtoObj.getId());
//        user.setName(dtoObj.getName());
//        user.setEmail(dtoObj.getEmail());
//        user.setAbout(dtoObj.getAbout());
//        user.setPassword(dtoObj.getPassword());
        return user;
    }

    private UserDTO userToDTO(User aUser){
        UserDTO aDTO = modelMapper.map(aUser, UserDTO.class);
        return aDTO;
    }
}

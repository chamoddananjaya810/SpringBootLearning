package com.example01.Test01.service;

import com.example01.Test01.dto.UserDTO;
import com.example01.Test01.entity.User;
import com.example01.Test01.repo.userRepo;
import jakarta.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {


    @Autowired
    private userRepo userRepo;

    @Autowired
    private ModelMapper modelMapper;

    public UserDTO saveUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    @Autowired
    public void setUserRepo(userRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<UserDTO> getAllUser() {
        List<User> userList = userRepo.findAll();
        return modelMapper.map(userList, new TypeToken<>() {
        }.getType());
    }

    public UserDTO updateUser(UserDTO userDTO) {
        userRepo.save(modelMapper.map(userDTO, User.class));
        return userDTO;
    }

    public boolean deleteUser(UserDTO userDTO) {
        userRepo.delete(modelMapper.map(userDTO, User.class));
        return true;
    }

    //user id> user details

    public UserDTO getUserByUserID(String userId) {
        User user = userRepo.getUserByUserID(userId);
        return modelMapper.map(user, UserDTO.class);
    }

    public  UserDTO getUserByUserAndAddress(String userId,String address){
       User user= userRepo.getUserByIdAndAddress(userId,address);
       return modelMapper.map(user,UserDTO.class);
    }
}

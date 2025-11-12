package com.example01.Test01.controller;

import com.example01.Test01.dto.UserDTO;
import com.example01.Test01.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "api/v1/user")
@CrossOrigin
public class userController {
    @Autowired
    private UserService userService;


    @GetMapping("/getusers")

    public List<UserDTO> getUser() {
        return userService.getAllUser();
    }

    @PostMapping("/saveUser")
    public UserDTO saveUse(@RequestBody UserDTO userDTO) {
        return userService.saveUser(userDTO);
    }

    @PutMapping("/updateUser")
    public UserDTO updateUse(@RequestBody UserDTO userDTO) {
        return userService.updateUser(userDTO);
    }

    @DeleteMapping("/deleteUser")
    public boolean deleteUse(@RequestBody UserDTO userDTO) {
        return userService.deleteUser(userDTO);
    }
}

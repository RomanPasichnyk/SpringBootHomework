package ua.logos.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ua.logos.domain.UserDTO;
import ua.logos.entity.UserEntity;
import ua.logos.service.UserService;

import java.util.List;

@RestController
@RequestMapping("users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    public ResponseEntity<?> createUser(@RequestBody UserDTO userDTO) {
        userService.saveUser(userDTO);
        return new ResponseEntity<Void>(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<?> findAllUser(){
        List<UserDTO> userDTOS = userService.findAllUser();
        return new ResponseEntity<List<UserDTO>>(userDTOS, HttpStatus.OK);
    }

    @GetMapping("{userId}")
    public ResponseEntity<?> findUserById(@PathVariable("userId") Long id) {
        UserDTO userDTO = userService.findUserById(id);
        return new ResponseEntity<UserDTO>(userDTO, HttpStatus.OK);
    }

}

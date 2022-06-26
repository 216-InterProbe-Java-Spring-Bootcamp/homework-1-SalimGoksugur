package com.patika.odev_1.api.controllers;

import com.patika.odev_1.entities.User;
import com.patika.odev_1.service.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "api/v1/users")
@RequiredArgsConstructor
public class UserController {
    private final IUserService userService;


    @GetMapping
    public ResponseEntity<List<User>> getAllUsers(){
        return new ResponseEntity<>(userService.getAllUsers(), HttpStatus.OK);
    }

    @GetMapping(path = "{userId}")
    public ResponseEntity<User> getUserByID(@PathVariable long userId){
        return new ResponseEntity<>(userService.findById(userId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
        return new ResponseEntity<>(userService.addUser(user), HttpStatus.CREATED);
    }

    @PutMapping
    public ResponseEntity<User> updateUSer( @RequestBody User user){
        return new ResponseEntity<>(userService.updateUser(user), HttpStatus.NO_CONTENT);
    }

    @DeleteMapping(path = "{userId}")
    public ResponseEntity<Void> deleteUser(@PathVariable long userId){
        userService.removeUser(userId);
        return ResponseEntity.noContent().build();
    }
}
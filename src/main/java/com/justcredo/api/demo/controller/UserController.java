package com.justcredo.api.demo.controller;

import com.justcredo.api.demo.model.User;
import com.justcredo.api.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserService userService;

    @RequestMapping(value="/user", method = RequestMethod.GET)
    public ResponseEntity<Collection<User>> listUser(){
        return new ResponseEntity<>(userService.findAll(), HttpStatus.OK);
    }

    @RequestMapping(value = "/user", method = RequestMethod.POST)
    public ResponseEntity<User> create(@RequestBody User user){
        return new ResponseEntity<>(userService.save(user),HttpStatus.OK);
    }

    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(value = "id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}

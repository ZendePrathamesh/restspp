package com.fq.restspp.controller;

import com.fq.restspp.enitity.User;
import com.fq.restspp.service.UserService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping("/{id}")
    public ResponseEntity<User> getUser(@PathVariable @Positive Long id) {
        log.info("get user");

        User newUser = userService.getUser(id);

        log.info("get user completed");
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @PostMapping("/")
    public ResponseEntity<User> addUser(@RequestBody @Valid User user) {
        log.info("adding user");

        User newUser = userService.add(user);

        log.info("adding user completed");
        return new ResponseEntity<>(newUser, HttpStatus.CREATED);
    }


    @PutMapping("/")
    public ResponseEntity<User> updateUser(@RequestBody @Valid  User user) {
        log.info("update user");

        User newUser = userService.updateUser(user);

        log.info("update user completed");
        return new ResponseEntity<>(newUser, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteUser(@PathVariable @Positive Long id) {
        log.info("delete user");

        String message = userService.deleteUser(id);

        log.info("delete user completed");
        return new ResponseEntity<>(message, HttpStatus.NO_CONTENT);
    }
}

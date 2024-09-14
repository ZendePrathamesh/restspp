package com.fq.restspp.service;

import com.fq.restspp.enitity.User;
import com.fq.restspp.exception.UserNotFound;
import com.fq.restspp.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
@Slf4j
public class UserService {
    @Autowired
    UserRepository userRepository;

    public User add(User user) {
        log.info("adding user");

        User addedUser = userRepository.save(user);

        log.info("adding user completed");
        return addedUser;
    }

    public User getUser(Long id) {
        log.info("fetch user");

        Optional<User> addedUser = userRepository.findById(id);

        log.info("fetch user completed");
        return addedUser.orElseGet(User::new);
    }

    public User updateUser(User user) {
        log.info("update user");

        User updatedUser = null;

        Optional<User> existUser = userRepository.findById(user.getId());
        if(existUser.isPresent()) {
            updatedUser = userRepository.save(user);
        } else {
            throw new UserNotFound("User with id = " + user.getId() +" is not found");
        }

        log.info("update user completed");
        return updatedUser;
    }

    public String  deleteUser(Long id) {
        log.info("delete user");

        userRepository.deleteById(id);

        log.info("delete user completed");
        return "User deleted";
    }

}

package com.example.contact.service.impl;

import com.example.contact.entity.User;
import com.example.contact.exception.ResourceNotFoundException;
import com.example.contact.repository.UserRepository;
import com.example.contact.response.UserResponse;
import com.example.contact.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Slf4j
@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getUsers() {
        return userRepository.findAll();
    }

    @Override
    public User getById(Integer id) {

        User user = userRepository.getUserById(id);
        if (user == null) {
            log.error(">>>> User not found for id : {}", id);
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "User not found");
        }
        log.info("User : {}", user);
        return user;
    }

    @Override
    public User createUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public User updateUser(User user, Integer id) {

        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isEmpty()) {
            log.error(">>>> User not fount for id : {}", id);
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "User is not present");
        }
        User getUser = optionalUser.get();
        if (user.getName() != null) getUser.setName(user.getName());
        if (user.getPhoneNo() != null) getUser.setPhoneNo(user.getPhoneNo());
        if (user.getEmailId() != null) getUser.setEmailId(user.getEmailId());
        if (user.getImage() != null) getUser.setImage(user.getImage());
        return userRepository.save(getUser);
    }

    @Override
    public UserResponse deleteUser(Integer id) {
        int deleted = userRepository.deleteUserById(id);
        log.info("deleted : {}", deleted);
        if (deleted == 0) {
            log.error(">>>> User couldn't delete for id : {}", id);
            throw new ResourceNotFoundException(HttpStatus.NOT_FOUND, "User couldn't delete");
        }
        return UserResponse.builder().message("Deleted Successfully").date(LocalDateTime.now()).build();
    }
}

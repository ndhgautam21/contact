package com.example.contact.service;

import com.example.contact.entity.User;
import com.example.contact.response.UserResponse;

import java.util.List;

public interface UserService {

    List<User> getUsers();

    User getById(Integer id);

    User createUser(User user);

    User updateUser(User user, Integer id);

    UserResponse deleteUser(Integer id);

}

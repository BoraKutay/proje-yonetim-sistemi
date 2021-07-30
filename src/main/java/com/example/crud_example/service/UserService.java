package com.example.crud_example.service;

import com.example.crud_example.model.User;

import java.util.List;

public interface UserService {

    List<User> getAllUsers();
    void saveUser(User user);
    User getUserById(int id);
    void deleteUserById(int id);

}

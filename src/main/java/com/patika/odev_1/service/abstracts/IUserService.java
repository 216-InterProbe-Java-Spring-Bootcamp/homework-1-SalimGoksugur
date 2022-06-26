package com.patika.odev_1.service.abstracts;

import com.patika.odev_1.entities.User;

import java.util.List;

public interface IUserService {
    User addUser(User user);
    List<User> getAllUsers();
    void removeUser(long id);
    User updateUser(User user);
    User findById(long id);
}

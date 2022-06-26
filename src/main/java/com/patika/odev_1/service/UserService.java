package com.patika.odev_1.service;

import com.patika.odev_1.entities.User;
import com.patika.odev_1.repository.abstracts.IUserRepository;
import com.patika.odev_1.service.abstracts.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserService implements IUserService {

    private final IUserRepository userRepository;

    @Override
    public User addUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();

    }

    @Override
    public void removeUser(long id) {
        userRepository.deleteById(id);
    }

    @Override
    public User updateUser(User user) {
       return  userRepository.save(user);
    }

    @Override
    public User findById(long id) {
        return userRepository.findById(id).orElseThrow(()->new RuntimeException("Kayıt bulunamadı"));
    }
}

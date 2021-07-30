package com.example.crud_example.service;

import com.example.crud_example.model.User;
import com.example.crud_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;


    //Tüm kullanıcıları çağırma
    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    //Kullanıcı kaydı
    @Override
    public void saveUser(User user) {
        this.userRepository.save(user);
    }

    //ID ile kullanıcıya erişme
    @Override
    public User getUserById(int id) {
        Optional<User> optional = userRepository.findById(id);
        User user = null;
        if(optional.isPresent()){
            user = optional.get();
        }else{
            throw new RuntimeException("User not found for id:: "+id);
        }
        return user;
    }

    //Kullanıcı sil
    @Override
    public void deleteUserById(int id) {
        this.userRepository.deleteById(id);
    }




}

package com.example.crud_example.service;

import com.example.crud_example.model.MyUserDetails;
import com.example.crud_example.model.User;
import com.example.crud_example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    UserRepository userRepository;


    @Override
    public UserDetails loadUserByUsername(String mail) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUserMail(mail);
        boolean enable = !user.get().isAccountVerified();
        user.orElseThrow(()-> new UsernameNotFoundException("Not found: " + mail));
        return user.map(MyUserDetails::new).get();
    }
}

package com.example.crud_example.repository;

import com.example.crud_example.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    Optional<User> findByUserMail(String userMail);
    Optional<User> findByUserName(String userName);
}

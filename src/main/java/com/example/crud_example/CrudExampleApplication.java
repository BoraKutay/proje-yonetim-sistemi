package com.example.crud_example;

import com.example.crud_example.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@EnableJpaRepositories(basePackageClasses = UserRepository.class)
@SpringBootApplication
public class CrudExampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(CrudExampleApplication.class, args);
    }

}

package com.example.demosercurity.service;

import com.example.demosercurity.model.Users;
import com.example.demosercurity.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {
    @Autowired
    private UsersRepository usersRepository;

    public Optional<Users> findByUserName(String name){
        return usersRepository.findByUsername(name);
    }

    public Boolean existsByUsername(String username){
        return usersRepository.existsByUsername(username);


    }

    public Boolean existsByEmail(String email){
        return usersRepository.existsByEmail(email);

    }

    public Users save(Users users){
        return usersRepository.save(users);
    }
}

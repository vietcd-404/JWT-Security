package com.example.demosercurity.service;

import com.example.demosercurity.model.Role;
import com.example.demosercurity.model.RoleName;
import com.example.demosercurity.model.Users;
import com.example.demosercurity.repository.RoleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class RoleService {
    @Autowired
    private RoleRepository roleRepository;

    public Optional<Role> findByName(RoleName name){
        return roleRepository.findByName(name);
    }
}

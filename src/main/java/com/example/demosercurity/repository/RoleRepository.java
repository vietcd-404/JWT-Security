package com.example.demosercurity.repository;

import com.example.demosercurity.model.Role;
import com.example.demosercurity.model.RoleName;
import com.example.demosercurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {
    Optional<Role> findByName(RoleName name);

}

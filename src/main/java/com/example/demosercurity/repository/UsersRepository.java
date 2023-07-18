package com.example.demosercurity.repository;

import com.example.demosercurity.model.Users;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsersRepository extends JpaRepository<Users, Long> {
    Optional<Users> findByUsername(String name); //Tìm kiếm user có trong db

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}

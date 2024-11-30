package com.example.Academia.repository;

import com.example.Academia.entity.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface AdminRepository extends JpaRepository<Admin, String> {
    Optional<Admin> findByEmailAndSenha(String email, String senha);
}

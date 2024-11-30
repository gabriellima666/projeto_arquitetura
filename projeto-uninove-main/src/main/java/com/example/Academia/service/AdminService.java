package com.example.Academia.service;

import com.example.Academia.entity.Admin;
import com.example.Academia.repository.AdminRepository;

import java.util.List;

public class AdminService {
    private final AdminRepository adminRepository;

    public AdminService(AdminRepository adminRepository) {
        this.adminRepository = adminRepository;
    }

    public void adminSave(Admin admin){adminRepository.save(admin);}

    public List<Admin> listarAdmin() {return adminRepository.findAll();
    }
}

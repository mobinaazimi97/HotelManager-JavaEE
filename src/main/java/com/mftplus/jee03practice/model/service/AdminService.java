package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Admin;
import com.mftplus.jee03practice.model.repository.AdminRepository;

public class AdminService {

    public static void save(Admin admin) throws Exception {

        try (AdminRepository adminRepository = new AdminRepository()) {
            adminRepository.save(admin);
        }
    }

    public static void edit(Admin admin) throws Exception {

        try (AdminRepository adminRepository = new AdminRepository()) {
            adminRepository.edit(admin);
        }
    }
}

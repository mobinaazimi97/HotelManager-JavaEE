package com.mftplus.jee03practice.model.service;


import com.mftplus.jee03practice.model.entity.Admin;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;

public class AdminService implements Service<Admin , Long> {
    @Getter
    private static AdminService adminService = new AdminService();

    private AdminService() {}

    @Override
    public void save(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(admin);

        }
    }

    @Override
    public void edit(Admin admin) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(admin);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Admin.class);
        }
    }

    @Override
    public Admin findById(Long id) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Admin.class);

        }
    }

    @Override
    public List<Admin> findAll() throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Admin.class);
        }
    }
    public List<Admin> findByFamily(String family)throws Exception{
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String , Object> params = new HashMap<>();
            params.put("family",family);
            return crudRepository.findBy("Admin.findByFamily",params, Admin.class);
        }
    }
    public Admin findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String , Object>params = new HashMap<>();
            params.put("username",username);
            params.put("password",password);
            List<Admin>admins=crudRepository.findBy("Admin.findByUsernameAndPassword",params, Admin.class);
            return (admins.isEmpty())? null:admins.get(0);
        }
    }

    public Admin findByAdminContactNum(String contactNum) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String , Object>params = new HashMap<>();
            params.put("contactNum",contactNum);
            List<Admin>admins=crudRepository.findBy("Admin.findByAdminContactNum",params, Admin.class);
            return (admins.isEmpty())? null:admins.get(0);
        }
    }
    public Admin findByTransactionHistory(LocalDateTime transactionDateTime) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String , Object>params = new HashMap<>();
            params.put("transactionDateTime",transactionDateTime);
            List<Admin>admins=crudRepository.findBy("Admin.findByTransactionHistory",params, Admin.class);
            if (admins.isEmpty()){
                return null;
            }else {
                return admins.get(0);
            }
        }
    }
    public Admin findByTransactionNum(Long transactionNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String , Object>params = new HashMap<>();
            params.put("transactionNumber",transactionNumber);
            List<Admin>admins=crudRepository.findBy("Admin.findByTransactionNum",params, Admin.class);
            if (admins.isEmpty()){
                return null;
            }else {
                return admins.get(0);
            }
        }
    }

}

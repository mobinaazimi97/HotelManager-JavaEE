package com.mftplus.jee03practice.model.service;


import com.mftplus.jee03practice.model.entity.Admin;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.List;

public class AdminService implements Service<Admin, Long> {
    @Getter
    private static AdminService adminService = new AdminService();

    private AdminService() {
    }

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

    public List<Admin> findByFamily(String family) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("family", family);
            return crudRepository.findBy("Admin.findByFamily", params, Admin.class);
        }
    }

    public Admin findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Admin> admins = crudRepository.findBy("Admin.findByUsernameAndPassword", params, Admin.class);
            return (admins.isEmpty()) ? null : admins.get(0);
        }
    }

    public Admin findByAdminContactNum(String contactNum) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("contactNum", contactNum);
            List<Admin> admins = crudRepository.findBy("Admin.findByAdminContactNum", params, Admin.class);
            return (admins.isEmpty()) ? null : admins.get(0);
        }
    }

    public List<Admin> findByTransactionDate(LocalDate transactionDate) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionDate", transactionDate);
            List<Admin> admins = crudRepository.findBy("Admin.findByTransactionDate", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public Admin findByTransactionTime(LocalTime transactionTime) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionTime", transactionTime);
            List<Admin> admins = crudRepository.findBy("Admin.findByTransactionTime", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByTransactionNum(Long transactionNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("transactionNumber", transactionNumber);
            List<Admin> admins = crudRepository.findBy("Admin.findByTransactionNum", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByCusEmail(String email) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            List<Admin> admins = crudRepository.findBy("Admin.findByCusEmail", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByCusEmailTrans(String email) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("email", email);
            List<Admin> admins = crudRepository.findBy("Admin.findByCusEmailTrans", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByCustomerUsername(String username) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            List<Admin> admins = crudRepository.findBy("Admin.findByCusUsername", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByCustomUserAndPass(String username, String password) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Admin> admins = crudRepository.findBy("Admin.findByCusUserAndPass", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public List<Admin> findByPayType(String payType) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("payType", payType);
            List<Admin> admins = crudRepository.findBy("Admin.findByPayType", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public Admin findByPayId(Long id) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", id);
            List<Admin> admins = crudRepository.findBy("Admin.findByPayId", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByReservationId(Long id) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", id);
            List<Admin> admins = crudRepository.findBy("Admin.findByReserveId", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public List<Admin> findByReserveDate(LocalDate reservationDate) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", reservationDate);
            List<Admin> admins = crudRepository.findBy("Admin.findByReserveDate", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByReserveTime(LocalTime reservationTime) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("reservation", reservationTime);
            List<Admin> admins = crudRepository.findBy("Admin.findByReserveTime", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public Admin findByRoomId(Long id) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", id);
            List<Admin> admins = crudRepository.findBy("Admin.findByRoomId", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public Admin findByRoomNum(String roomNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomsAdmin", roomNumber);
            List<Admin> admins = crudRepository.findBy("Admin.findByRoomNum", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins.get(0);
            }
        }
    }

    public List<Admin> findByReservedRoom(String roomNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomNumber", roomNumber);
            List<Admin> admins = crudRepository.findBy("Admin.findByRoomReserved", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByTotalReserves(String roomNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomNumber", roomNumber);
            List<Admin> admins = crudRepository.findBy("Admin.findByTotalReserves", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }


    public List<Admin> findByRoomReservedDate(LocalDate reservationDate) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomsAdmin", reservationDate);
            List<Admin> admins = crudRepository.findBy("Admin.findByRoomReservedDate", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByRoomReservedTime(LocalTime reservationTime) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomsAdmin", reservationTime);
            List<Admin> admins = crudRepository.findBy("Admin.findByRoomReservedTime", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByEmpRoomReq(String requirement) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("requirement", requirement);
            List<Admin> admins = crudRepository.findBy("Admin.findByEmpRoomReq", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByEmployeeNumber(String empContactNum) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("empContactNum", empContactNum);
            List<Admin> admins = crudRepository.findBy("Admin.findByEmpNumber", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByEmployeeRoomNum(String roomNumber) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("roomNumber", roomNumber);
            List<Admin> admins = crudRepository.findBy("Admin.findByEmployeeRoomNumber", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByEmpJob(String jobTitle) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("jobTitle", jobTitle);
            List<Admin> admins = crudRepository.findBy("Admin.findByEmpJob", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }

    public List<Admin> findByEmpNameAndFamily(String name, String family) throws Exception {
        try (CrudRepository<Admin, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("name", name);
            params.put("family", family);
            List<Admin> admins = crudRepository.findBy("Admin.findByEmpNameAndFamily", params, Admin.class);
            if (admins.isEmpty()) {
                return null;
            } else {
                return admins;
            }
        }
    }
}

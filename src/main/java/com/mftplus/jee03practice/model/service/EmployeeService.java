package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Admin;
import com.mftplus.jee03practice.model.entity.Employee;
import com.mftplus.jee03practice.model.repository.CrudRepository;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;

public class EmployeeService implements Service<Employee, Long> {
    @Getter
    private static EmployeeService employeeService = new EmployeeService();

    private EmployeeService() {
    }

    @Override
    public void save(Employee employee) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.save(employee);

        }
    }

    @Override
    public void edit(Employee employee) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.edit(employee);
        }
    }

    @Override
    public void remove(Long id) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            crudRepository.remove(id, Employee.class);
        }
    }

    @Override
    public Employee findById(Long id) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findById(id, Employee.class);

        }
    }

    @Override
    public List<Employee> findAll() throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            return crudRepository.findAll(Employee.class);
        }
    }

    public List<Employee> findByFamily(String family) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("family", family);
            return crudRepository.findBy("Employee.findByFamily", params, Employee.class);

        }
    }

    public Employee findByUsernameAndPassword(String username, String password) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("username", username);
            params.put("password", password);
            List<Employee> employeeList = crudRepository.findBy("Employee.findByUsernameAndPassword", params, Employee.class);
            return (employeeList.isEmpty()) ? null : employeeList.get(0);
        }
    }

    public Employee findByEmpContactNum(String empContactNum) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("empContactNum", empContactNum);
            List<Employee> employees = crudRepository.findBy("Employee.findByEmpContactNum", params, Employee.class);
            return (employees.isEmpty()) ? null : employees.get(0);
        }
    }

    public Employee findByRoomId(Long id) throws Exception {
        try (CrudRepository<Employee, Long> crudRepository = new CrudRepository<>()) {
            HashMap<String, Object> params = new HashMap<>();
            params.put("id", id);
            List<Employee> employeeList = crudRepository.findBy("Employee.findByRoomId", params, Employee.class);
            if (employeeList.isEmpty()) {
                return null;
            } else {
                return employeeList.get(0);
            }
        }
    }
}

package com.mftplus.jee03practice.model.service;

import com.mftplus.jee03practice.model.entity.Employee;
import com.mftplus.jee03practice.model.repository.EmployeeRepository;

public class EmployeeService {

    public static void save(Employee employee) throws Exception {

        try (EmployeeRepository employeeRepository = new EmployeeRepository()) {
            employeeRepository.save(employee);
        }
    }

    public static void edit(Employee employee) throws Exception {

        try (EmployeeRepository employeeRepository = new EmployeeRepository()) {
            employeeRepository.edit(employee);
        }
    }



}

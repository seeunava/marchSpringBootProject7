package com.service;

import com.dto.EmployeeDTO;

import java.util.List;

public interface EmployeeService {

    void registerEmp(EmployeeDTO employeeDTO);

    EmployeeDTO authenticate(String emailId, String password);

    List<EmployeeDTO> findAllEmployees();

    EmployeeDTO searchEmployee(String keyword);

    EmployeeDTO retrieveRecord(int employeeId);

    void deleteEmp(int employeeId);

    void updateKaro(EmployeeDTO employeeDTO);
}

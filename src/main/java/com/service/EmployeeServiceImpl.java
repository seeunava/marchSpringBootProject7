package com.service;

import com.dao.EmployeeDao;
import com.dto.EmployeeDTO;
import com.entity.EmployeeEntity;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Transactional
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    EmployeeDao employeeDao;

    @Override
    public void registerEmp(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeDao.save(employeeEntity);
    }

    @Override
    public EmployeeDTO authenticate(String emailId, String password) {
        Optional<EmployeeEntity> optional = employeeDao.findByEmailIdAndPassword(emailId, password);
        EmployeeDTO employeeDTO = null;
        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }
        return employeeDTO;
    }

    @Override
    public List<EmployeeDTO> findAllEmployees() {
        List<EmployeeEntity> employeeEntityList = employeeDao.findAll();
        List<EmployeeDTO> employeeDtoList = new ArrayList<>();
        for (EmployeeEntity entity : employeeEntityList) {
            EmployeeDTO employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(entity, employeeDTO);
            employeeDtoList.add(employeeDTO);
        }
        return employeeDtoList;
    }

    @Override
    public void deleteEmp(int employeeId) {
        employeeDao.deleteById(employeeId);
    }

    @Override
    public EmployeeDTO retrieveRecord(int employeeId) {
        Optional<EmployeeEntity> optional = employeeDao.findById(employeeId);
        EmployeeDTO employeeDTO = null;
        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }
        return employeeDTO;
    }

    @Override
    public void updateKaro(EmployeeDTO employeeDTO) {
        EmployeeEntity employeeEntity = new EmployeeEntity();
        BeanUtils.copyProperties(employeeDTO, employeeEntity);
        employeeDao.save(employeeEntity);
    }

    @Override
    public EmployeeDTO searchEmployee(String searchTerm) {
        Optional<EmployeeEntity> optional = employeeDao.searchEmployee(searchTerm);
        EmployeeDTO employeeDTO = null;
        if (optional.isPresent()) {
            EmployeeEntity employeeEntity = optional.get();
            employeeDTO = new EmployeeDTO();
            BeanUtils.copyProperties(employeeEntity, employeeDTO);
        }
        return employeeDTO;
    }
}

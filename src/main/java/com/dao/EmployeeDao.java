package com.dao;

import com.entity.EmployeeEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface EmployeeDao extends JpaRepository<EmployeeEntity, Integer> {

    Optional<EmployeeEntity> findByEmailIdAndPassword(String emailId, String password);

    @Query("SELECT e FROM EmployeeEntity e WHERE e.employeeName LIKE %:searchTerm%")
    Optional<EmployeeEntity> searchEmployee(@Param("searchTerm") String searchTerm);
}

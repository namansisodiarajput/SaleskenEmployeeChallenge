package com.example.salesken.repository;

import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.example.salesken.model.Employee;

@Repository
@Transactional
@EntityScan("com.example.salesken.model")
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
	
	Employee findByEmailId(String emailId);

}

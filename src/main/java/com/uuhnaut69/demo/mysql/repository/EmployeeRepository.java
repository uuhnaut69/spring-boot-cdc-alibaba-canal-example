package com.uuhnaut69.demo.repository;

import com.uuhnaut69.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author uuhnaut
 * @project canal
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

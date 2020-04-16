package com.uuhnaut69.demo.mysql.repository;

import com.uuhnaut69.demo.mysql.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author uuhnaut
 * @project canal
 */
@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

package com.uuhnaut69.demo.mysql.service;

import com.uuhnaut69.demo.mysql.model.Employee;
import com.uuhnaut69.demo.mysql.payload.request.EmployeeRequest;

import java.util.List;

/**
 * @author uuhnaut
 * @project canal
 */
public interface EmployeeService {

    List<Employee> dummyData();

    Employee update(Long id, EmployeeRequest employeeRequest);

    void delete(Long id);

}

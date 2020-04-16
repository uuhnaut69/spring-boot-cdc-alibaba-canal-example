package com.uuhnaut69.demo.service;

import com.uuhnaut69.demo.model.Employee;
import com.uuhnaut69.demo.payload.request.EmployeeRequest;

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

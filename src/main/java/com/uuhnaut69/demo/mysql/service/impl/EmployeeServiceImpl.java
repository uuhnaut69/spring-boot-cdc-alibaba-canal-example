package com.uuhnaut69.demo.mysql.service.impl;

import com.github.javafaker.Faker;
import com.uuhnaut69.demo.exception.NotFoundException;
import com.uuhnaut69.demo.mysql.model.Employee;
import com.uuhnaut69.demo.mysql.payload.request.EmployeeRequest;
import com.uuhnaut69.demo.mysql.repository.EmployeeRepository;
import com.uuhnaut69.demo.mysql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

/**
 * @author uuhnaut
 * @project canal
 */
@Service
@Transactional
@RequiredArgsConstructor
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    @Override
    public List<Employee> dummyData() {
        Faker faker = new Faker();
        List<Employee> employees = new ArrayList<>();
        IntStream.range(0, 10).forEach(i -> employees.add(Employee.builder()
                .firstName(faker.name().firstName())
                .lastName(faker.name().lastName())
                .address(faker.address().fullAddress())
                .job(faker.job().title())
                .jobPosition(faker.job().position())
                .build()));
        return employeeRepository.saveAll(employees);
    }

    @Override
    public Employee update(Long id, EmployeeRequest employeeRequest) {
        Employee employee = employeeRepository.findById(id).orElseThrow(() -> new NotFoundException("Not found!!!"));
        employee.setFirstName(employeeRequest.getFirstName());
        employee.setLastName(employeeRequest.getLastName());
        employee.setAddress(employeeRequest.getAddress());
        employee.setJob(employeeRequest.getJob());
        employee.setJobPosition(employeeRequest.getJobPosition());
        return employeeRepository.save(employee);
    }

    @Override
    public void delete(Long id) {
        employeeRepository.deleteById(id);
    }
}

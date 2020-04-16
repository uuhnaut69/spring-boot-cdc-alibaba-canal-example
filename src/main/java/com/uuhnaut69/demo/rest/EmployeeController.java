package com.uuhnaut69.demo.rest;

import com.uuhnaut69.demo.mysql.model.Employee;
import com.uuhnaut69.demo.mysql.payload.request.EmployeeRequest;
import com.uuhnaut69.demo.mysql.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author uuhnaut
 * @project canal
 */
@RestController
@RequiredArgsConstructor
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public List<Employee> dummyData() {
        return employeeService.dummyData();
    }

    @PutMapping("/{id}")
    public Employee update(@PathVariable Long id, @RequestBody EmployeeRequest employeeRequest) {
        return employeeService.update(id, employeeRequest);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        employeeService.delete(id);
    }
}

package com.uuhnaut69.demo.canal;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.uuhnaut69.demo.elasticsearch.document.EmployeeEs;
import com.uuhnaut69.demo.elasticsearch.service.EmployeeEsService;
import com.uuhnaut69.demo.mysql.model.Employee;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import top.javatool.canal.client.annotation.CanalTable;
import top.javatool.canal.client.handler.EntryHandler;

/**
 * @author uuhnaut
 * @project canal
 */
@Slf4j
@Component
@RequiredArgsConstructor
@CanalTable(value = "employee")
public class EmployeeHandler implements EntryHandler<Employee> {

    private final EmployeeEsService employeeEsService;

    @Override
    public void insert(Employee employee) {
        EmployeeEs employeeEs = convertToDoc(employee);
        employeeEsService.upsert(employeeEs);
    }

    @Override
    public void update(Employee before, Employee after) {
        EmployeeEs employeeEs = convertToDoc(after);
        employeeEsService.upsert(employeeEs);
    }

    @Override
    public void delete(Employee employee) {
        EmployeeEs employeeEs = convertToDoc(employee);
        employeeEsService.delete(employeeEs.getId());
    }

    private EmployeeEs convertToDoc(Employee employee) {
        final ObjectMapper objectMapper = new ObjectMapper().configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        return objectMapper.convertValue(employee, EmployeeEs.class);
    }
}

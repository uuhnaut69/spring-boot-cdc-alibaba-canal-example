package com.uuhnaut69.demo.elasticsearch.service.impl;

import com.uuhnaut69.demo.elasticsearch.document.EmployeeEs;
import com.uuhnaut69.demo.elasticsearch.repository.EmployeeEsRepository;
import com.uuhnaut69.demo.elasticsearch.service.EmployeeEsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

/**
 * @author uuhnaut
 * @project canal
 */
@Service
@RequiredArgsConstructor
public class EmployeeEsServiceImpl implements EmployeeEsService {

    private final EmployeeEsRepository employeeEsRepository;

    @Override
    public void upsert(EmployeeEs employeeEs) {
        employeeEsRepository.save(employeeEs);
    }

    @Override
    public void delete(String id) {
        employeeEsRepository.deleteById(id);
    }
}

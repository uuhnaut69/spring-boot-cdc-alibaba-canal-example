package com.uuhnaut69.demo.elasticsearch.service;

import com.uuhnaut69.demo.elasticsearch.document.EmployeeEs;

/**
 * @author uuhnaut
 * @project canal
 */
public interface EmployeeEsService {

    void upsert(EmployeeEs employeeEs);

    void delete(String id);

}

package com.uuhnaut69.demo.elasticsearch.repository;

import com.uuhnaut69.demo.elasticsearch.document.EmployeeEs;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

/**
 * @author uuhnaut
 * @project canal
 */
@Repository
public interface EmployeeEsRepository extends ElasticsearchRepository<EmployeeEs, String> {
}

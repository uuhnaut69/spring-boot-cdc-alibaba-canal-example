package com.uuhnaut69.demo.elasticsearch.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * @author uuhnaut
 * @project canal
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(indexName = "employee-index", type = "employee")
public class EmployeeEs {

    @Id
    private String id;

    @Field(type = FieldType.Text)
    private String firstName;

    @Field(type = FieldType.Text)
    private String lastName;

    @Field(type = FieldType.Text)
    private String address;

    @Field(type = FieldType.Text)
    private String job;

    @Field(type = FieldType.Text)
    private String jobPosition;
}

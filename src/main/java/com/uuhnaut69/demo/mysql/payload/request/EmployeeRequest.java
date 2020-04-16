package com.uuhnaut69.demo.mysql.payload.request;

import lombok.Data;

/**
 * @author uuhnaut
 * @project canal
 */
@Data
public class EmployeeRequest {

    private String firstName;

    private String lastName;

    private String address;

    private String job;

    private String jobPosition;
}

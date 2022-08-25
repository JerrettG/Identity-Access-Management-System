package com.kenzie.unit.two.employee.service;

import com.kenzie.ata.ExcludeFromJacocoGeneratedReport;
import com.kenzie.unit.two.iam.models.User;

@ExcludeFromJacocoGeneratedReport
public class UserOrRoleNotFoundException extends RuntimeException {
    // TODO fill out this exception
    public UserOrRoleNotFoundException(String message) {
        super(message);
    }
}

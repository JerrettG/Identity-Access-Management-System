package com.kenzie.unit.two.iam.service;

import com.kenzie.unit.two.employee.lambda.models.ViewEmployeePayCheckRequest;
import com.kenzie.unit.two.employee.service.EmployeeService;
import com.kenzie.unit.two.employee.service.models.Employee;
import com.kenzie.unit.two.iam.entities.Roles;
import com.kenzie.unit.two.iam.lambda.models.AssignUserToRoleRequest;
import com.kenzie.unit.two.iam.lambda.models.CreateUserRequest;
import com.kenzie.unit.two.iam.models.Department;
import com.kenzie.unit.two.iam.models.Role;
import com.kenzie.unit.two.iam.models.User;
import com.kenzie.unit.two.iam.models.UserRoles;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;

public class EmployeeServiceTest {
    @InjectMocks
    private EmployeeService employeeService;
    @Mock
    private UserService userService;
    @Mock
    private RoleService roleService;
    @Mock
    private UserRoleService userRoleService;
    @BeforeEach
    public void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void getEmployeePayCheck_userWithRole_returnsEmployee() {
        Department department = new Department(UUID.randomUUID(), "Marketing");
        User validUser = new User(UUID.randomUUID(), "margaretparis", department);
        Role validRole = new Role(UUID.randomUUID(), "view-paycheck");

        when(this.userService.getUserByUserName(any())).thenReturn(validUser);
        when(this.roleService.getRoleByRoleName(any())).thenReturn(validRole);
        when(this.userRoleService.doesUserHaveRole(any(), any())).thenReturn(true);

        EmployeeService spy = Mockito.spy(this.employeeService);

        ViewEmployeePayCheckRequest request = new ViewEmployeePayCheckRequest();
        request.setEmployeeUserName("margaretparis");
        request.setRequesterUserName("margaretparis");

        Employee employee = spy.getEmployeePayCheck(request);

        assertEquals(employee.getUserName(), "margaretparis");
        assertEquals(employee.getDepartment(), department);
    }
}

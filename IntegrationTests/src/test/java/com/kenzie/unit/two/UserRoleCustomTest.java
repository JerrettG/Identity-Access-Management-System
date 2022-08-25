package com.kenzie.unit.two;


import com.kenzie.unit.two.employee.service.UserOrRoleNotFoundException;

import com.kenzie.unit.two.iam.service.UserRoleService;
import com.kenzie.unit.two.iam.storage.Storage;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;


public class UserRoleCustomTest {
    @InjectMocks
    private UserRoleService userRoleService;

    @Mock
    private Storage storage;

    @BeforeEach
    void beforeEach() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    void missingUserRoleThrowsException_TASK_6() {
        // TODO - write this test
        // Hint - Look at the test in missingUserRoleThrowsException_TASK_2.
        // This will demonstrate how to assert an exception has been thrown

        assertThrows(UserOrRoleNotFoundException.class, () -> userRoleService.doesUserHaveRole(null, null));
    }
}

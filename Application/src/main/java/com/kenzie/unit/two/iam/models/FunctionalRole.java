package com.kenzie.unit.two.iam.models;

import com.kenzie.unit.two.iam.entities.Roles;

import com.kenzie.ata.ExcludeFromJacocoGeneratedReport;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@ExcludeFromJacocoGeneratedReport
public class FunctionalRole {

    // Roles required to do this action
    private List<Roles> roles;
    private List<String> roleNames;

    public FunctionalRole(List<Roles> roles) {
        this.roles = roles;
        this.roleNames = new ArrayList<>();
        for (Roles role : roles){
                roleNames.add(role.getRoleName());
        }
    }

    // Compare incoming list to the ones required for this class.
    public Boolean matches(List<Role> roleList) {
        // TODO Task 5 - Write your code here ...
        boolean result = true;
        for (Role role: roleList) {
            if (!roleNames.contains(role.getRoleName())) result = false;
        }
        return result;
    }
}

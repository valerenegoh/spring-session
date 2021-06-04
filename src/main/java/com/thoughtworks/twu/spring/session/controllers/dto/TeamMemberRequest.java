package com.thoughtworks.twu.spring.session.controllers.dto;

public class TeamMemberRequest {
    public String firstName;
    public String lastName;
    public String role;

    public TeamMemberRequest(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role = role;
    }
}


package com.twu.spring.framework.session.model;

public class TeamMember {

    private String firstName;
    private String lastName;
    private String role;

    public TeamMember(String firstName, String lastName, String role) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.role= role;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getRole() {
        return role;
    }

    @Override
    public boolean equals(Object objectToBeCompared) {
        if (objectToBeCompared == null) {
            return false;
        }

        TeamMember teamMemberToBeCompared = (TeamMember) objectToBeCompared;

        return teamMemberToBeCompared.getFirstName().equals(this.firstName) &&
               teamMemberToBeCompared.getLastName().equals(this.lastName) &&
               teamMemberToBeCompared.getRole().equals(this.role);
    }

}

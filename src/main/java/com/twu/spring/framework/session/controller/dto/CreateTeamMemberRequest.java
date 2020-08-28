package com.twu.spring.framework.session.controller.dto;

import com.twu.spring.framework.session.model.TeamMember;

public class CreateTeamMemberRequest {

    public String firstName;
    public String lastName;
    public String role;

    public TeamMember toTeamMember() {
        TeamMember teamMember = new TeamMember(this.firstName, this.lastName, this.role);
        return teamMember;
    }

}

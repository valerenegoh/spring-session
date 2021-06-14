package com.thoughtworks.twu.spring.session.controllers.dto;

import com.thoughtworks.twu.spring.session.models.TeamMember;

import java.util.Set;

public class TeamMembersResponse {
    Set<TeamMember> teamMembers;

    public TeamMembersResponse(Set<TeamMember> teamMembers) {
        this.teamMembers = teamMembers;
    }

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }
}
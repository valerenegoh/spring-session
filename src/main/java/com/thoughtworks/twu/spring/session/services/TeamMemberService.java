package com.thoughtworks.twu.spring.session.services;

import com.thoughtworks.twu.spring.session.models.TeamMember;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TeamMemberService {
    Set<TeamMember> teamMembers = new HashSet<>();

    public void save(TeamMember teamMember) {
        teamMembers.add(teamMember);
    }

    public Set<TeamMember> getTeamMembers() {
        return teamMembers;
    }
}

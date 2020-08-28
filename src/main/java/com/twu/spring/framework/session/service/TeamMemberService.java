package com.twu.spring.framework.session.service;

import com.twu.spring.framework.session.model.TeamMember;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

@Service
public class TeamMemberService {

    private Set<TeamMember> teamMembers = new HashSet<>();

    public void save(TeamMember teamMember) {
        this.teamMembers.add(teamMember);
    }
}

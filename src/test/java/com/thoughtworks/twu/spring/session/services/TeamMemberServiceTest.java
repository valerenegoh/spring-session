package com.thoughtworks.twu.spring.session.services;

import com.thoughtworks.twu.spring.session.models.TeamMember;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.contains;

@SpringBootTest
class TeamMemberServiceTest {

    @Autowired
    private TeamMemberService teamMemberService;

    @Test
    public void shouldSaveTeamMember() {
        TeamMember teamMember = new TeamMember("Rebecca", "Parsons", "Dev");

        teamMemberService.save(teamMember);

        assertThat(teamMemberService.getTeamMembers(), contains(teamMember));
    }
}
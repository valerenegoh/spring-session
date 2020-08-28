package com.twu.spring.framework.session.controller;

import com.twu.spring.framework.session.controller.dto.CreateTeamMemberRequest;
import com.twu.spring.framework.session.model.TeamMember;
import com.twu.spring.framework.session.service.TeamMemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TeamMemberResource {

    private TeamMemberService teamMemberService;

    public TeamMemberResource(TeamMemberService teamMemberService) {
        this.teamMemberService = teamMemberService;
    }

    @PostMapping("/team-members")
    public ResponseEntity<Void> createTeamMember(@RequestBody CreateTeamMemberRequest createTeamMemberRequest) {
        TeamMember teamMember = createTeamMemberRequest.toTeamMember();

        teamMemberService.save(teamMember);
        return ResponseEntity.status(HttpStatus.CREATED).build();

    }

}

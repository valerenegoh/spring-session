package com.thoughtworks.twu.spring.session.controllers;

import com.thoughtworks.twu.spring.session.models.TeamMember;
import com.thoughtworks.twu.spring.session.models.TeamMemberRequest;
import com.thoughtworks.twu.spring.session.services.TeamMemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/team-members")
public class TeamMemberResource {

    @Autowired
    private TeamMemberService teamMemberService;

    @PostMapping
    public ResponseEntity addNewTeamMembers(@RequestBody TeamMemberRequest teamMemberRequest) {
        TeamMember teamMember =
                new TeamMember(teamMemberRequest.firstName, teamMemberRequest.lastName, teamMemberRequest.role);

        teamMemberService.save(teamMember);

        return new ResponseEntity(HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity getTeamMembers() {

        return new ResponseEntity(HttpStatus.OK);
    }

}

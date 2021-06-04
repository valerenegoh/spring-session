package com.thoughtworks.twu.spring.session.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.thoughtworks.twu.spring.session.models.TeamMember;
import com.thoughtworks.twu.spring.session.services.TeamMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest
public class TeamMemberResourceTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private TeamMemberService teamMemberService;

    @Test
    public void shouldReturn201WhenTeamMemberResourceIsCreated() throws Exception {
        ObjectMapper objectMapper = new ObjectMapper();

        String firstName = "Rebecca";
        String lastName = "Parsons";
        String role = "Developer";

        TeamMember teamMember = new TeamMember(firstName, lastName, role);
        String teamMemberRequest = objectMapper.writeValueAsString(teamMember);

        mockMvc.perform(post("/team-members")
                .content(teamMemberRequest)
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());

        verify(teamMemberService).save(teamMember);
    }

    @Test
    public void shouldReturn200WhenTeamMemberResourceIsRequested() throws Exception {

        mockMvc.perform(get("/team-members")
                .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }
}

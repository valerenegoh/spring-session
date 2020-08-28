package com.twu.spring.framework.session.controller;

import com.twu.spring.framework.session.controller.TeamMemberResource;
import com.twu.spring.framework.session.model.TeamMember;
import com.twu.spring.framework.session.service.TeamMemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(TeamMemberResource.class)
public class TeamMemberResourceTest {

    @Autowired
    private MockMvc mockService;

    @MockBean
    private TeamMemberService mockTeamMemberService;

    @Test
    void shouldCreateTeamMember() throws Exception {
        String firstName = "Ruixing";
        String lastName = "Gao";
        String role = "developer";

        String teamMemberAsJson = "{" +
                "\"firstName\": \""+firstName+"\","+
                "\"lastName\": \""+lastName+"\","+
                "\"role\": \""+role+"\""+
                "}";

        mockService.perform(
                post("/team-members")
                .contentType(MediaType.APPLICATION_JSON)
                .content(teamMemberAsJson))
                .andExpect(status().isCreated());

        TeamMember createdTeamMember = new TeamMember(firstName, lastName, role);

        verify(mockTeamMemberService).save(createdTeamMember);

    }

}

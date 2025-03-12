package com.example.structure.service.team;

import com.example.structure.service.team.dto.request.TeamSaveRequest;
import com.example.structure.service.team.dto.response.TeamResponse;

import java.util.List;

public interface TeamService {
    void create(TeamSaveRequest request);

    List<TeamResponse> getTeams();

    TeamResponse getTeam(Long id);
}

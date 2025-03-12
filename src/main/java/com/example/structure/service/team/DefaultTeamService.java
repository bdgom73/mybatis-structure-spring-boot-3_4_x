package com.example.structure.service.team;

import com.example.structure.domain.Team;
import com.example.structure.mapper.TeamMapper;
import com.example.structure.service.team.dto.request.TeamSaveRequest;
import com.example.structure.service.team.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultTeamService implements TeamService {

    private final TeamMapper teamMapper;

    @Override
    public void create(TeamSaveRequest request) {
        Team team = request.toEntity();
        teamMapper.save(team);
    }

    @Override
    public List<TeamResponse> getTeams() {
        List<Team> teams = teamMapper.findAll();
        return teams.stream()
                .map(TeamResponse::create)
                .toList();
    }

    @Override
    public TeamResponse getTeam(Long id) {
        Team team = teamMapper.findById(id);
        return TeamResponse.create(team);
    }
}

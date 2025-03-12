package com.example.structure.controller;

import com.example.structure.global.api.ApiResponse;
import com.example.structure.global.api.DataResponse;
import com.example.structure.service.team.TeamService;
import com.example.structure.service.team.dto.request.TeamSaveRequest;
import com.example.structure.service.team.dto.response.TeamResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class TeamApiController {

    private final TeamService teamService;

    @PostMapping("/api/v1/teams")
    public ResponseEntity<ApiResponse> save(@RequestBody TeamSaveRequest request) {
        teamService.create(request);
        return ResponseEntity.ok(ApiResponse.ok());
    }

    @GetMapping("/api/v1/teams")
    public ResponseEntity<DataResponse<List<TeamResponse>>> getTeams() {
        List<TeamResponse> teams = teamService.getTeams();
        return ResponseEntity.ok(DataResponse.send(teams));
    }

    @GetMapping("/api/v1/teams/{id}")
    public ResponseEntity<TeamResponse> getTeam(@PathVariable Long id) {
        TeamResponse team = teamService.getTeam(id);
        return ResponseEntity.ok(team);
    }
}

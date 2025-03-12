package com.example.structure.service.team.dto.request;

import com.example.structure.domain.Team;

public record TeamSaveRequest(String name) {
    public Team toEntity() {
        return Team.builder()
                .name(name)
                .build();
    }
}

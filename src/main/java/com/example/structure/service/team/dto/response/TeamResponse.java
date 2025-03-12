package com.example.structure.service.team.dto.response;

import com.example.structure.domain.Team;

import java.time.LocalDateTime;

public record TeamResponse(
        Long id,
        String name,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {
    public static TeamResponse create(Team team) {
        return new TeamResponse(
                team.getId(),
                team.getName(),
                team.getCreatedAt(),
                team.getUpdatedAt()
        );
    }
}

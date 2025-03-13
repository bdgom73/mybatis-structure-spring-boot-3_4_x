package com.example.structure.service.member.dto.response;

import com.example.structure.domain.Member;
import com.example.structure.service.team.dto.response.TeamResponse;
import org.springframework.util.ObjectUtils;

import java.time.LocalDateTime;

public record MemberWithTeamResponse(
        Long id,
        String name,
        String nickname,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt,
        TeamResponse team
) {

    public static MemberWithTeamResponse create(final Member member) {

        return new MemberWithTeamResponse(
                member.getId(),
                member.getName(),
                member.getNickname(),
                member.getEmail(),
                member.getCreatedAt(),
                member.getUpdatedAt(),
                !ObjectUtils.isEmpty(member.getTeam()) ? TeamResponse.create(member.getTeam()) : null
        );
    }
}

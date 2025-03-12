package com.example.structure.service.member.dto.response;

import com.example.structure.domain.Member;

import java.time.LocalDateTime;

public record MemberResponse(
        Long id,
        String name,
        String nickname,
        String email,
        LocalDateTime createdAt,
        LocalDateTime updatedAt
) {

    public static MemberResponse create(Member member) {
        return new MemberResponse(
                member.getId(),
                member.getName(),
                member.getNickname(),
                member.getEmail(),
                member.getCreatedAt(),
                member.getUpdatedAt()
        );
    }
}

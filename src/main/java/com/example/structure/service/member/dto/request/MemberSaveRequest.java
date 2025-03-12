package com.example.structure.service.member.dto.request;

import com.example.structure.domain.Member;

public record MemberSaveRequest(
        String name,
        String nickname,
        String email,
        String password
) {

    public Member toEntity(String encodedPassword) {
        return Member.builder()
                .name(name)
                .nickname(nickname)
                .email(email)
                .password(encodedPassword)
                .build();
    }
}

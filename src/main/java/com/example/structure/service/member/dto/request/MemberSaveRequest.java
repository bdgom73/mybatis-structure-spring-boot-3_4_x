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
                .name(this.name)
                .nickname(this.nickname)
                .email(this.email)
                .password(encodedPassword)
                .build();
    }
}

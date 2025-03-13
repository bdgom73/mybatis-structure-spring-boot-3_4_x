package com.example.structure.service.member;

import com.example.structure.service.member.dto.request.MemberSaveRequest;
import com.example.structure.service.member.dto.response.MemberResponse;
import com.example.structure.service.member.dto.response.MemberWithTeamResponse;

import java.util.List;

public interface MemberService {
    void save(MemberSaveRequest request);

    List<MemberResponse> getMembers();

    MemberResponse getMember(Long id);

    MemberWithTeamResponse getMemberWithTeam(Long id);

    void join(Long teamId, Long memberId);
}

package com.example.structure.service.member;


import com.example.structure.domain.Member;
import com.example.structure.domain.Team;
import com.example.structure.mapper.MemberMapper;
import com.example.structure.mapper.TeamMapper;
import com.example.structure.service.member.dto.request.MemberSaveRequest;
import com.example.structure.service.member.dto.response.MemberResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class DefaultMemberService implements MemberService {

    private final MemberMapper memberMapper;
    private final TeamMapper teamMapper;
    private final PasswordEncoder passwordEncoder;

    @Override
    @Transactional
    public void save(MemberSaveRequest request) {
        Member member = request.toEntity(passwordEncoder.encode(request.password()));
        memberMapper.save(member);
    }

    @Override
    public List<MemberResponse> getMembers() {
        List<Member> members = memberMapper.findAll();
        return members.stream()
                .map(MemberResponse::create)
                .toList();
    }

    @Override
    public MemberResponse getMember(Long id) {
        Member member = Optional.ofNullable(memberMapper.findById(id))
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 회원 입니다"));
        return MemberResponse.create(member);
    }

    @Override
    @Transactional
    public void join(Long teamId, Long memberId) {
        // 팀 검증
        Team team = Optional.ofNullable(teamMapper.findById(teamId))
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 팀 입니다"));

        // 회원 검증
        Member member = Optional.ofNullable(memberMapper.findById(memberId))
                .orElseThrow(() -> new IllegalArgumentException("찾을 수 없는 회원 입니다"));

        memberMapper.updateTeam(team, member);
    }
}

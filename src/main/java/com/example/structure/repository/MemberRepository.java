package com.example.structure.repository;

import com.example.structure.domain.Member;
import com.example.structure.mapper.MemberMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
@RequiredArgsConstructor
public class MemberRepository {

    private final MemberMapper memberMapper;

    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(memberMapper.findById(id));
    }

    public Optional<Member> findByIdWithTeam(Long id) {
        return Optional.ofNullable(memberMapper.findByIdWithTeam(id));
    }

    public List<Member> findAll() {
        return memberMapper.findAll();
    }

    public void save(Member member) {
        memberMapper.save(member);
    }
}

package com.example.structure.mapper;

import com.example.structure.domain.Member;
import com.example.structure.domain.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface MemberMapper {
    Member findById(Long id);
    Member findByIdWithTeam(Long id);
    List<Member> findAll();
    void save(Member member);
    void updateTeam(Team team, Member member);
}

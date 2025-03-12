package com.example.structure.mapper;

import com.example.structure.domain.Team;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface TeamMapper {
    Team findById(Long id);
    List<Team> findAll();
    void save(Team team);
}

package com.app.teams.domain;

import java.util.List;

public interface ITeamService {
    
    List<Team> findAll();

    Team findById(Long id);

    Team save(Team team);

    Team update(Team team, Long id);

    void deleteById(Long id);
    
}

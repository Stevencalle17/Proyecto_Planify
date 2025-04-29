package com.app.teams.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.teams.domain.ITeamRepository;
import com.app.teams.domain.Team;

@Component
public class TeamDatasource {

    private final ITeamRepository teamRepository;

    public TeamDatasource(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    public Optional<Team> findById(Long id) {
        return teamRepository.findById(id);
    }

    public Team save(Team team) {
        return teamRepository.save(team);
    }

    public Optional<Team> update(Team team, Long id) {
        return teamRepository.findById(id).map(existingTeam -> {
            existingTeam.setName(team.getName());
            return teamRepository.save(existingTeam);
        });
    }

    public boolean deleteById(Long id) {
        if (teamRepository.existsById(id)) {
            teamRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

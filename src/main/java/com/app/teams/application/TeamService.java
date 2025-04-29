package com.app.teams.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.teams.domain.ITeamRepository;
import com.app.teams.domain.ITeamService;
import com.app.teams.domain.Team;

@Service
public class TeamService implements ITeamService {

    private final ITeamRepository teamRepository;

    public TeamService(ITeamRepository teamRepository) {
        this.teamRepository = teamRepository;
    }

    @Override
    public List<Team> findAll() {
        return teamRepository.findAll();
    }

    @Override
    public Team findById(Long id) {
        return teamRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Team not found with ID: " + id));
    }

    @Override
    @Transactional
    public Team save(Team team) {
        if (teamRepository.existsByName(team.getName())) {
            throw new IllegalArgumentException("Team name already exists: " + team.getName());
        }
        return teamRepository.save(team);
    }

    @Override
    @Transactional
    public Team update(Team team, Long id) {
        Team existingTeam = findById(id);
        existingTeam.setName(team.getName());
        return teamRepository.save(existingTeam);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Team team = findById(id);
        teamRepository.delete(team);
    }
}
package com.app.teams.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeamRepository extends JpaRepository<Team, Long> {

    @Override
    @NonNull
    List<Team> findAll();

    @Override
    @NonNull
    Optional<Team> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Team> S save(@NonNull S team);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<Team> findByName(String name);

    boolean existsByName(String name);
}
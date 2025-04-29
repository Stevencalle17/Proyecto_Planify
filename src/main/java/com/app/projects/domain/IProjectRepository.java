package com.app.projects.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IProjectRepository extends JpaRepository<Project, Long> {

    @Override
    @NonNull
    List<Project> findAll();

    @Override
    @NonNull
    Optional<Project> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Project> S save(@NonNull S project);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<Project> findByName(String name);

    boolean existsByName(String name);
}
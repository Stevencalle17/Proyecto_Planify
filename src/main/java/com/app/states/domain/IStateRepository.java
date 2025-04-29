package com.app.states.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IStateRepository extends JpaRepository<State, Long> {

    @Override
    @NonNull
    List<State> findAll();

    @Override
    @NonNull
    Optional<State> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends State> S save(@NonNull S state);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<State> findByName(String name);

    boolean existsByName(String name);
}
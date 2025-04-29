package com.app.tasks.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface ITaskRepository extends JpaRepository<Task, Long> {

    @Override
    @NonNull
    List<Task> findAll();

    @Override
    @NonNull
    Optional<Task> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Task> S save(@NonNull S task);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<Task> findByTitle(String title);

    boolean existsByTitle(String title);
}
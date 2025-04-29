package com.app.plans.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IPlanRepository extends JpaRepository<Plan, Long> {

    @Override
    @NonNull
    List<Plan> findAll();

    @Override
    @NonNull
    Optional<Plan> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends Plan> S save(@NonNull S plan);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<Plan> findByName(String name);

    boolean existsByName(String name);
}


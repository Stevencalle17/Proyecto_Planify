package com.app.users.domain;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.stereotype.Repository;

@Repository
public interface IUserRepository extends JpaRepository<User, Long> {

    @Override
    @NonNull
    List<User> findAll();

    @Override
    @NonNull
    Optional<User> findById(@NonNull Long id);

    @Override
    @NonNull
    <S extends User> S save(@NonNull S user);

    @Override
    boolean existsById(@NonNull Long id);

    @Override
    void deleteById(@NonNull Long id);

    Optional<User> findByEmail(String email);

    boolean existsByEmail(String email);

    // Método para buscar usuarios por plan_id
    List<User> findByPlanId(Long planId);
}
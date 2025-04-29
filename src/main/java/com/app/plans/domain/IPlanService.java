package com.app.plans.domain;

import java.util.List;

public interface IPlanService {
    
    List<Plan> findAll();

    Plan findById(Long id);

    Plan save(Plan plan);

    Plan update(Plan plan, Long id);

    void deleteById(Long id);
}

package com.app.plans.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.plans.domain.IPlanRepository;
import com.app.plans.domain.Plan;

@Component
public class PlanDatasource {

    private final IPlanRepository planRepository;

    public PlanDatasource(IPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    public List<Plan> findAll() {
        return planRepository.findAll();
    }
    public Optional<Plan> findById(Long id) {
        return planRepository.findById(id);
    }

    public Plan save(Plan plan) {
        return planRepository.save(plan);
    }

    public Optional<Plan> update(Plan plan, Long id) {
        return planRepository.findById(id).map(existingPlan -> {
            existingPlan.setName(plan.getName());
            existingPlan.setPrice(plan.getPrice());
            return planRepository.save(existingPlan);
        });
    }

    public boolean deleteById(Long id) {
        if (planRepository.existsById(id)) {
            planRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.app.plans.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.plans.domain.IPlanRepository;
import com.app.plans.domain.IPlanService;
import com.app.plans.domain.Plan;

@Service
public class PlanService implements IPlanService {

    private final IPlanRepository planRepository;

    public PlanService(IPlanRepository planRepository) {
        this.planRepository = planRepository;
    }

    @Override
    public List<Plan> findAll() {
        return planRepository.findAll();
    }

    @Override
    public Plan findById(Long id) {
        return planRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Plan not found with ID: " + id));
    }

    @Override
    @Transactional
    public Plan save(Plan plan) {
        if (planRepository.existsByName(plan.getName())) {
            throw new IllegalArgumentException("Plan name already registered: " + plan.getName());
        }
        return planRepository.save(plan);
    }

    @Override
    @Transactional
    public Plan update(Plan plan, Long id) {
        Plan existingPlan = findById(id);
        existingPlan.setName(plan.getName());
        return planRepository.save(existingPlan);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        Plan plan = findById(id);
        planRepository.delete(plan);
    }
}
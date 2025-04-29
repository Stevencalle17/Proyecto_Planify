package com.app.plans.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.plans.domain.IPlanService;
import com.app.plans.domain.Plan;

@RestController
@RequestMapping("/plans")
public class PlanController {

    private final IPlanService planService;

    public PlanController(IPlanService planService) {
        this.planService = planService;
    }

    @GetMapping
    public ResponseEntity<List<Plan>> findAll() {
        return ResponseEntity.ok(planService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Plan> findById(@PathVariable Long id) {
        return ResponseEntity.ok(planService.findById(id));
    }

    @PostMapping
    public ResponseEntity<Plan> save(@RequestBody Plan plan) {
        return ResponseEntity.ok(planService.save(plan));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Plan> update(@RequestBody Plan plan, @PathVariable Long id) {
        return ResponseEntity.ok(planService.update(plan, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        planService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}
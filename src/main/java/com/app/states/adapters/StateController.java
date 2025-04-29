package com.app.states.adapters;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.app.states.domain.IStateService;
import com.app.states.domain.State;

@RestController
@RequestMapping("/states")
public class StateController {
    private final IStateService stateService;

    public StateController(IStateService stateService) {
        this.stateService = stateService;
    }

    @GetMapping
    public List<State> findAll() {
        return stateService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<State> findById(@PathVariable Long id) {
        return ResponseEntity.ok(stateService.findById(id));
    }

    @PostMapping
    public ResponseEntity<State> save(@RequestBody State state) {
        return ResponseEntity.ok(stateService.save(state));
    }

    @PutMapping("/{id}")
    public ResponseEntity<State> update(@RequestBody State state, @PathVariable Long id) {
        return ResponseEntity.ok(stateService.update(state, id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        stateService.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

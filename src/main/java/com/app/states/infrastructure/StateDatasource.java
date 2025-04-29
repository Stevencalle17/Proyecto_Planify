package com.app.states.infrastructure;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.app.states.domain.IStateRepository;
import com.app.states.domain.State;

@Component
public class StateDatasource {

    private final IStateRepository stateRepository;

    public StateDatasource(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    public List<State> findAll() {
        return stateRepository.findAll();
    }
    public Optional<State> findById(Long id) {
        return stateRepository.findById(id);
    }

    public State save(State state) {
        return stateRepository.save(state);
    }

    public Optional<State> update(State state, Long id) {
        return stateRepository.findById(id).map(existingState -> {
            existingState.setName(state.getName());
            return stateRepository.save(existingState);
        });
    }

    public boolean deleteById(Long id) {
        if (stateRepository.existsById(id)) {
            stateRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

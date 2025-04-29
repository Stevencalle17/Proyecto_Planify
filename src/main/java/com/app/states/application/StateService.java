package com.app.states.application;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.app.shared.adapters.exception.ResourceNotFoundException;

import com.app.states.domain.IStateRepository;
import com.app.states.domain.IStateService;
import com.app.states.domain.State;

@Service
public class StateService implements IStateService {

    private final IStateRepository stateRepository;

    public StateService(IStateRepository stateRepository) {
        this.stateRepository = stateRepository;
    }

    @Override
    public List<State> findAll() {
        return stateRepository.findAll();
    }

    @Override
    public State findById(Long id) {
        return stateRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("State not found with ID: " + id));
    }

    @Override
    @Transactional
    public State save(State state) {
        if (stateRepository.existsByName(state.getName())) {
            throw new IllegalArgumentException("State name already exists: " + state.getName());
        }
        return stateRepository.save(state);
    }

    @Override
    @Transactional
    public State update(State state, Long id) {
        State existingState = findById(id);
        existingState.setName(state.getName());
        return stateRepository.save(existingState);
    }

    @Override
    @Transactional
    public void deleteById(Long id) {
        State state = findById(id);
        stateRepository.delete(state);
    }
}

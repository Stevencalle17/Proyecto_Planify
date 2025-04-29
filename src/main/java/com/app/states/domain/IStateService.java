package com.app.states.domain;

import java.util.List;

public interface IStateService {
    
    List<State> findAll();

    State findById(Long id);

    State save(State state);

    State update(State state, Long id);

    void deleteById(Long id);
}

package com.app.states.domain;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "states")
@Data
public class State {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    public State() {
    }

    public State(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    public Long setId() {
        return id;
    }

    public void getId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void getName(String name) {
        this.name = name;
    }
}

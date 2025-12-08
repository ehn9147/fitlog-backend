package com.fitlog.workout_backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "users")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    @Transient
    private List<Workout> workouts = new ArrayList<>();

    public User() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public List<Workout> getWorkouts() { return workouts; }
    public void setWorkouts(List<Workout> workouts) { this.workouts = workouts; }
}

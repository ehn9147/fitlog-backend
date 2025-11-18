package com.fitlog.workout_backend.model;

import jakarta.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String userId;

    private String name;

    private String type; // Strength | Cardio | Flexibility | Other

    private String date;

    private Integer duration;

    private String notes;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "workout_id")
    private List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    // =======================
    // Getters and setters
    // =======================

    public String getId() {
        return id;
    }

    public void setId(String id) { this.id = id; }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) { this.userId = userId; }

    public String getName() {
        return name;
    }

    public void setName(String name) { this.name = name; }

    public String getType() {
        return type;
    }

    public void setType(String type) { this.type = type; }

    public String getDate() {
        return date;
    }

    public void setDate(String date) { this.date = date; }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) { this.duration = duration; }

    public String getNotes() {
        return notes;
    }

    public void setNotes(String notes) { this.notes = notes; }

    public List<Exercise> getExercises() {
        return exercises;
    }

    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }
}

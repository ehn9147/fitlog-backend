package com.fitlog.workout_backend.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;


import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "workouts")
public class Workout {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    @Column(name = "user_id")
    private String userId;

    private String name;
    private String type;
    private String date;
    private Integer duration;

    @OneToMany(mappedBy = "workout", cascade = CascadeType.ALL, orphanRemoval = true)
    @JsonManagedReference
    private List<Exercise> exercises = new ArrayList<>();

    public Workout() {}

    public String getId() { return id; }
    public void setId(String id) { this.id = id; }

    public String getUserId() { return userId; }
    public void setUserId(String userId) { this.userId = userId; }

    public String getName() { return name; }
    public void setName(String name) { this.name = name; }

    public String getType() { return type; }
    public void setType(String type) { this.type = type; }

    public String getDate() { return date; }
    public void setDate(String date) { this.date = date; }

    public Integer getDuration() { return duration; }
    public void setDuration(Integer duration) { this.duration = duration; }

    public List<Exercise> getExercises() { return exercises; }
    public void setExercises(List<Exercise> exercises) { this.exercises = exercises; }
}

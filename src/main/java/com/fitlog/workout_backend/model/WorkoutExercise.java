package com.fitlog.workout_backend.model;

import jakarta.persistence.*;

@Entity
@Table(name = "workout_exercise")
public class WorkoutExercise {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;


    @Column(name = "workout_id")
    private Long workoutId;

    @Column(name = "exercise_id")
    private Long exerciseId;

    private Integer sets;
    private Integer reps;
    private Double weight;

    public WorkoutExercise() {}

    public Long getId() { return id; }

    public Long getWorkoutId() { return workoutId; }
    public void setWorkoutId(Long workoutId) { this.workoutId = workoutId; }

    public Long getExerciseId() { return exerciseId; }
    public void setExerciseId(Long exerciseId) { this.exerciseId = exerciseId; }

    public Integer getSets() { return sets; }
    public void setSets(Integer sets) { this.sets = sets; }

    public Integer getReps() { return reps; }
    public void setReps(Integer reps) { this.reps = reps; }

    public Double getWeight() { return weight; }
    public void setWeight(Double weight) { this.weight = weight; }
}


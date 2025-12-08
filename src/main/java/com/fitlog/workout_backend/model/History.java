package com.fitlog.workout_backend.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "history")
public class History {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // optional simple link to a workout, not used anywhere else
    @ManyToOne(optional = true)
    @JoinColumn(name = "workout_id")
    private Workout workout;

    private LocalDateTime completedAt;
    private String notes;

    public History() {}

    public Long getId() { return id; }

    public Workout getWorkout() { return workout; }
    public void setWorkout(Workout workout) { this.workout = workout; }

    public LocalDateTime getCompletedAt() { return completedAt; }
    public void setCompletedAt(LocalDateTime completedAt) { this.completedAt = completedAt; }

    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}

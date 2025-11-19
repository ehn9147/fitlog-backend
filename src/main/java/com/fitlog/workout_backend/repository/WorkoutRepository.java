package com.fitlog.workout_backend.repository;

import com.fitlog.workout_backend.model.Workout;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WorkoutRepository extends JpaRepository<Workout, String> {
}

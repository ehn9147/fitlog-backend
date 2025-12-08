package com.fitlog.workout_backend.controller;

import com.fitlog.workout_backend.model.Exercise;
import com.fitlog.workout_backend.model.Workout;
import com.fitlog.workout_backend.repository.WorkoutRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/workouts")
@CrossOrigin(origins = "*") // allow all origins; tighten later if needed
public class WorkoutController {

    private final WorkoutRepository workoutRepository;

    public WorkoutController(WorkoutRepository workoutRepository) {
        this.workoutRepository = workoutRepository;
    }

    // GET /api/workouts
    @GetMapping
    public ResponseEntity<List<Workout>> getAllWorkouts(
            @RequestParam(value = "userId", required = false) String userId
    ) {
        List<Workout> workouts;

        if (userId != null && !userId.isBlank()) {
            // 👇 now actually filter by userId
            workouts = workoutRepository.findByUserId(userId);
        } else {
            workouts = workoutRepository.findAll();
        }

        return ResponseEntity.ok(workouts);
    }

    // GET /api/workouts/{id}
    @GetMapping("/{id}")
    public ResponseEntity<Workout> getWorkoutById(@PathVariable String id) {
        Optional<Workout> workoutOpt = workoutRepository.findById(id);
        return workoutOpt.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    // POST /api/workouts
    @PostMapping
    public ResponseEntity<Workout> createWorkout(@RequestBody Workout payload) {

        Workout workout = new Workout();


        workout.setUserId(payload.getUserId());

        workout.setName(payload.getName());
        workout.setType(payload.getType());
        workout.setDate(payload.getDate());
        workout.setDuration(payload.getDuration());

        // Handle exercises, set back-reference
        if (payload.getExercises() != null) {
            for (Exercise exPayload : payload.getExercises()) {
                Exercise ex = new Exercise();
                ex.setName(exPayload.getName());
                ex.setSets(exPayload.getSets());
                ex.setReps(exPayload.getReps());
                ex.setWeight(exPayload.getWeight());
                ex.setWorkout(workout);       // 👈 link child to parent
                workout.getExercises().add(ex);
            }
        }

        Workout saved = workoutRepository.save(workout);
        return ResponseEntity.ok(saved);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Workout> updateWorkout(
            @PathVariable String id,
            @RequestBody Workout payload
    ) {
        Optional<Workout> workoutOpt = workoutRepository.findById(id);
        if (workoutOpt.isEmpty()) {
            return ResponseEntity.notFound().build();
        }

        Workout existing = workoutOpt.get();

        // Update basic fields
        existing.setUserId(payload.getUserId()); // optional: or keep existing.getUserId()
        existing.setName(payload.getName());
        existing.setType(payload.getType());
        existing.setDate(payload.getDate());
        existing.setDuration(payload.getDuration());

        // Clear existing exercises (orphanRemoval should delete them)
        existing.getExercises().clear();

        // Add new exercises from payload
        if (payload.getExercises() != null) {
            for (Exercise exPayload : payload.getExercises()) {
                Exercise ex = new Exercise();
                ex.setName(exPayload.getName());
                ex.setSets(exPayload.getSets());
                ex.setReps(exPayload.getReps());
                ex.setWeight(exPayload.getWeight());
                ex.setWorkout(existing);
                existing.getExercises().add(ex);
            }
        }

        Workout saved = workoutRepository.save(existing);
        return ResponseEntity.ok(saved);
    }

    // DELETE /api/workouts/{id}
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteWorkout(@PathVariable String id) {
        if (!workoutRepository.existsById(id)) {
            return ResponseEntity.notFound().build();
        }

        workoutRepository.deleteById(id);
        return ResponseEntity.noContent().build();
    }
}

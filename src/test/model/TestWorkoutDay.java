package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import model.enums.SplitType;

public class TestWorkoutDay {
    private WorkoutDay workoutDay;
    private Exercise exercise1;
    private Exercise exercise2;
    private Exercise exercise3;

    @BeforeEach
    void setUp() {
        workoutDay = new WorkoutDay("Workout1");

        exercise1 = new Exercise("Barbell Bench Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
                Equipment.BARBELL,
                135, 2, 6, 10, 1, 1);

        exercise2 = new Exercise("Lat Pulldown",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BACK, MuscleGroup.ARMS)),
                Equipment.MACHINE,
                120, 2, 6, 10, 1, 1);

        exercise3 = new Exercise("Cable Tricep Pushdown",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.TRICEPS)),
                Equipment.CABLE,
                100, 2, 6, 10, 1, 1);
    }

    @Test
    void testConstructor() {
        assertEquals("Workout1", workoutDay.getName());
        assertEquals(0, workoutDay.getExercises().size());
    }

    @Test
    void testAddOneExercise() {
        workoutDay.addExercise(exercise1);
        assertEquals(1, workoutDay.getExercises().size());
        assertEquals(exercise1, workoutDay.getExercises().get(0));
    }

    @Test
    void testAddMultipleExercises() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);
        workoutDay.addExercise(exercise3);

        assertEquals(3, workoutDay.getExercises().size());
        assertEquals(exercise1, workoutDay.getExercises().get(0));
        assertEquals(exercise2, workoutDay.getExercises().get(1));
        assertEquals(exercise3, workoutDay.getExercises().get(2));
    }

    @Test
    void testRemoveExercise() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);

        assertTrue(workoutDay.removeExercise("Barbell Bench Press"));
        assertEquals(1, workoutDay.getExercises().size());
        assertEquals(exercise2, workoutDay.getExercises().get(0));
    }

    @Test
    void testRemoveExerciseNotFound() {
        workoutDay.addExercise(exercise1);

        assertFalse(workoutDay.removeExercise("zzz"));
        assertEquals(1, workoutDay.getExercises().size());
    }

    @Test
    void testRemoveExerciseFromEmptyDay() {
        assertFalse(workoutDay.removeExercise("Barbell Bench Press"));
        assertEquals(0, workoutDay.getExercises().size());
    }

    @Test
    void testRemoveExerciseFirstMatch() {
        workoutDay.addExercise(exercise1);
        Exercise duplicateExercise = new Exercise("Barbell Bench Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
                Equipment.BARBELL,
                155, 2, 6, 10, 1, 1);

        workoutDay.addExercise(duplicateExercise);
        workoutDay.addExercise(exercise2);

        assertTrue(workoutDay.removeExercise("Barbell Bench Press"));
        assertEquals(2, workoutDay.getExercises().size());
        assertEquals("Barbell Bench Press", workoutDay.getExercises().get(0).getName());
        assertEquals(155, workoutDay.getExercises().get(0).getWeight());
    }

    @Test
    void testGetTotalExercises() {
        assertEquals(0, workoutDay.getTotalExercises());

        workoutDay.addExercise(exercise1);
        assertEquals(1, workoutDay.getTotalExercises());

        workoutDay.addExercise(exercise2);
        workoutDay.addExercise(exercise3);
        assertEquals(3, workoutDay.getTotalExercises());
    }

    @Test
    void testCalculateSessionLengthSingleExercise() {
        workoutDay.addExercise(exercise1);

        assertEquals(3, workoutDay.calculateSessionLength());
    }

    @Test
    void testCalculateSessionLengthMultipleExercises() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);
        workoutDay.addExercise(exercise3);

        assertEquals(15, workoutDay.calculateSessionLength());
    }

    @Test
    void testCalculateSessionLengthEmptyDay() {
        assertEquals(0, workoutDay.calculateSessionLength());
    }

    @Test
    void testCalculateCaloriesBurnt() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);

        assertEquals(45, workoutDay.calculateCaloriesBurnt());
    }

    @Test
    void testToJsonName() {
        JSONObject json = workoutDay.toJson();
        assertEquals("Workout1", json.getString("name"));
    }

    @Test
    void testToJsonEmptyDay() {
        JSONObject json = workoutDay.toJson();
        assertTrue(json.has("exercises"));
    }

    @Test
    void testToJsonEmpty() {
        JSONObject json = workoutDay.toJson();
        assertEquals(0, json.getJSONArray("exercises").length());
    }

    @Test
    void testToJsonExerciseCount() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);
        JSONArray exercises = workoutDay.toJson().getJSONArray("exercises");
        assertEquals(2, exercises.length());
    }

    @Test
    void testToJsonExercise() {
        workoutDay.addExercise(exercise1);
        workoutDay.addExercise(exercise2);
        JSONArray exercises = workoutDay.toJson().getJSONArray("exercises");
        assertEquals(2, exercises.length());
    }
}

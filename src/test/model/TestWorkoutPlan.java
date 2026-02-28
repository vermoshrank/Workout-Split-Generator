package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import model.enums.SplitType;

public class TestWorkoutPlan {
    private WorkoutPlan workoutPlan;
    private WorkoutDay pushDay;
    private WorkoutDay pullDay;
    private WorkoutDay legDay;
    private Exercise benchPress;

    @BeforeEach
    void setUp() {
        workoutPlan = new WorkoutPlan("PPL Split");

        pushDay = new WorkoutDay("Push");
        pullDay = new WorkoutDay("Pull");
        legDay = new WorkoutDay("Legs");

        benchPress = new Exercise("Bench Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
                Equipment.BARBELL,
                new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 1);
    }

    @Test
    void testConstructor() {
        assertEquals("PPL Split", workoutPlan.getName());
        assertEquals(0, workoutPlan.getWorkoutDays().size());
    }

    @Test
    void testAddDay() {
        workoutPlan.addDay(pushDay);
        assertEquals(1, workoutPlan.getWorkoutDays().size());
        assertEquals(pushDay, workoutPlan.getWorkoutDays().get(0));
    }

    @Test
    void testAddMultipleDays() {
        workoutPlan.addDay(pushDay);
        workoutPlan.addDay(pullDay);
        workoutPlan.addDay(legDay);

        assertEquals(3, workoutPlan.getWorkoutDays().size());
        assertEquals("Push", workoutPlan.getWorkoutDays().get(0).getName());
        assertEquals("Pull", workoutPlan.getWorkoutDays().get(1).getName());
        assertEquals("Legs", workoutPlan.getWorkoutDays().get(2).getName());
    }

    @Test
    void testAddOneExerciseToDay() {
        workoutPlan.addDay(pushDay);
        workoutPlan.addExerciseToDay("Push", benchPress);

        assertEquals(1, pushDay.getExercises().size());
        assertEquals(benchPress, pushDay.getExercises().get(0));
    }

    @Test
    void testAddMultipleExercisesToSameDay() {
        workoutPlan.addDay(pushDay);

        Exercise shoulderPress = new Exercise("Shoulder Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.FRONT_DELTS)),
                Equipment.DUMBBELL,
                new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 1);

        workoutPlan.addExerciseToDay("Push", benchPress);
        workoutPlan.addExerciseToDay("Push", shoulderPress);

        assertEquals(2, pushDay.getExercises().size());
        assertEquals("Bench Press", pushDay.getExercises().get(0).getName());
        assertEquals("Shoulder Press", pushDay.getExercises().get(1).getName());
    }

    @Test
    void testRemoveExercise() {
        workoutPlan.addDay(pushDay);
        pushDay.addExercise(benchPress);

        assertTrue(workoutPlan.removeExerciseFromDay("Push", "Bench Press"));
        assertEquals(0, pushDay.getExercises().size());
    }

    @Test
    void testGetTotalExercises() {
        assertEquals(0, workoutPlan.getTotalExercises(workoutPlan));
        workoutPlan.addDay(pushDay);
        pushDay.addExercise(benchPress);

        assertEquals(1, workoutPlan.getTotalExercises(workoutPlan));
    }
}

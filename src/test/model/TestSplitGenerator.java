package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.GymType;
import model.enums.MuscleGroup;
import model.enums.SplitType;
import model.generator.ExerciseFilter;
import model.generator.SplitGenerator;

public class TestSplitGenerator {
    private SplitGenerator generator;
    private ExerciseFilter filter;

    @BeforeEach
    void setUp() {
        filter = new ExerciseFilter();
        for (Exercise i : ExerciseDatabase.ALL) {
            filter.addExercise(i);
        }

        generator = new SplitGenerator(filter);
    }

    @Test
    void testConstructor() {
        ExerciseFilter newFilter = new ExerciseFilter();
        SplitGenerator newGenerator = new SplitGenerator(newFilter);

        assertEquals(newFilter, newGenerator.getExerciseFilter());
    }

    @Test
    void testPickSplitTypeFullBodyOneDay() {
        assertEquals(SplitType.FULL_BODY, generator.pickSplitType(1));
    }

    @Test
    void testPickSplitTypeFullBodyThreeDays() {
        assertEquals(SplitType.FULL_BODY, generator.pickSplitType(3));
    }

    @Test
    void testPickSplitTypeUpperLower() {
        assertEquals(SplitType.UPPER_LOWER, generator.pickSplitType(4));
    }

    @Test
    void testPickSplitTypePplUl() {
        assertEquals(SplitType.PPL_UL, generator.pickSplitType(5));
    }

    @Test
    void testPickSplitTypePpl() {
        assertEquals(SplitType.PUSH_PULL_LEGS, generator.pickSplitType(6));
    }

    @Test
    void testGetTargetMusclesPush() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("push");

        assertEquals(5, targets.size());
        assertTrue(targets.contains(MuscleGroup.CHEST));
        assertTrue(targets.contains(MuscleGroup.UPPER_CHEST));
        assertTrue(targets.contains(MuscleGroup.FRONT_DELTS));
        assertTrue(targets.contains(MuscleGroup.SIDE_DELTS));
        assertTrue(targets.contains(MuscleGroup.TRICEPS));
    }

    @Test
    void testGetTargetMusclesPull() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("pull");

        assertEquals(6, targets.size());
        assertTrue(targets.contains(MuscleGroup.LATS));
        assertTrue(targets.contains(MuscleGroup.TRAPS));
        assertTrue(targets.contains(MuscleGroup.REAR_DELTS));
        assertTrue(targets.contains(MuscleGroup.BICEPS));
    }

    @Test
    void testGetTargetMusclesLegs() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("legs");

        assertEquals(5, targets.size());
        assertTrue(targets.contains(MuscleGroup.QUADS));
        assertTrue(targets.contains(MuscleGroup.HAMSTRINGS));
        assertTrue(targets.contains(MuscleGroup.GLUTES));
        assertTrue(targets.contains(MuscleGroup.CALVES));
    }

    @Test
    void testGetTargetMusclesUpper() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("upper");

        assertEquals(12, targets.size());
        assertTrue(targets.contains(MuscleGroup.CHEST));
        assertTrue(targets.contains(MuscleGroup.LATS));
        assertTrue(targets.contains(MuscleGroup.TRICEPS));
        assertTrue(targets.contains(MuscleGroup.BICEPS));
    }

    @Test
    void testGetTargetMusclesLower() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("lower");

        assertEquals(5, targets.size());
        assertTrue(targets.contains(MuscleGroup.QUADS));
        assertTrue(targets.contains(MuscleGroup.HAMSTRINGS));
        assertTrue(targets.contains(MuscleGroup.GLUTES));
        assertTrue(targets.contains(MuscleGroup.CALVES));
    }

    @Test
    void testGetTargetMusclesForFullBody() {
        ArrayList<MuscleGroup> targets = generator.getTargetMusclesForDay("full body");

        assertEquals(16, targets.size());
        assertTrue(targets.contains(MuscleGroup.CHEST));
        assertTrue(targets.contains(MuscleGroup.LATS));
        assertTrue(targets.contains(MuscleGroup.QUADS));
        assertTrue(targets.contains(MuscleGroup.HAMSTRINGS));
    }

    @Test
    void testPickExercise() {
        WorkoutDay day = new WorkoutDay("Push");
        Exercise result = generator.pickRandomExerciseForMuscle(
                MuscleGroup.CHEST,
                ExerciseDatabase.ALL,
                day);

        assertTrue(result.getTargetMuscles().contains(MuscleGroup.CHEST));
    }

    @Test
    void testPopulate() {
        WorkoutDay day = new WorkoutDay("Push");
        generator.populateDay(day, "push", ExerciseDatabase.ALL);

        assertTrue(day.getTotalExercises() > 0);
    }

    @Test
    void testSuggestFullBody() {
        GeneratorArguments args = new GeneratorArguments(3, GymType.EVERYTHING);
        WorkoutPlan plan = generator.suggestSplit(args);

        assertEquals("Full Body", plan.getName());
        assertEquals(1, plan.getWorkoutDays().size());
        assertEquals("Full Body", plan.getWorkoutDays().get(0).getName());
    }

    @Test
    void testSuggestUl() {
        GeneratorArguments args = new GeneratorArguments(4, GymType.EVERYTHING);
        WorkoutPlan plan = generator.suggestSplit(args);

        assertEquals("Upper Lower 4x a week", plan.getName());
        assertEquals(2, plan.getWorkoutDays().size());
    }

    @Test
    void testSuggestPplUl() {
        GeneratorArguments args = new GeneratorArguments(5, GymType.EVERYTHING);
        WorkoutPlan plan = generator.suggestSplit(args);

        assertEquals("Push Pull Legs x Upper Lower", plan.getName());
        assertEquals(5, plan.getWorkoutDays().size());
    }

    @Test
    void testSuggestPpl() {
        GeneratorArguments args = new GeneratorArguments(6, GymType.EVERYTHING);
        WorkoutPlan plan = generator.suggestSplit(args);

        assertEquals("Push Pull Legs", plan.getName());
        assertEquals(3, plan.getWorkoutDays().size());
    }
}

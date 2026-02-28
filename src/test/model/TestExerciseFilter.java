package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import model.enums.SplitType;
import model.generator.ExerciseFilter;

public class TestExerciseFilter {
    private ExerciseFilter filter;
    private Exercise benchPress;
    private Exercise dumbbellCurl;
    private Exercise latPulldown;
    private Exercise legPress;

    @BeforeEach
    void setUp() {
        filter = new ExerciseFilter();

        benchPress = new Exercise("Barbell Bench Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
                Equipment.BARBELL,
                new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 2);

        dumbbellCurl = new Exercise("Dumbell Curl",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BICEPS)),
                Equipment.DUMBBELL,
                new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PULL, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 1);

        latPulldown = new Exercise("Lat Pulldown",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BACK, MuscleGroup.ARMS)),
                Equipment.MACHINE,
                new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PULL, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 1);

        legPress = new Exercise("Leg Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.LEGS)),
                Equipment.MACHINE,
                new ArrayList<SplitType>(Arrays.asList(SplitType.LOWER, SplitType.PUSH, SplitType.FULL_BODY)),
                0, 2, 6, 10, 1, 1);
    }

    @Test
    void testConstructor() {
        ExerciseFilter newFilter = new ExerciseFilter();
        assertTrue(newFilter.getExercises().isEmpty());
    }

    @Test
    void testAddExercise() {
        filter.addExercise(benchPress);

        assertEquals(1, filter.getExercises().size());
        assertTrue(filter.getExercises().contains(benchPress));
    }

    @Test
    void testAddMultipleExercises() {
        filter.addExercise(benchPress);
        filter.addExercise(dumbbellCurl);

        assertEquals(2, filter.getExercises().size());
        assertTrue(filter.getExercises().contains(benchPress));
        assertTrue(filter.getExercises().contains(dumbbellCurl));
    }

    @Test
    void testRemoveExercise() {
        filter.addExercise(benchPress);
        assertTrue(filter.removeExercise("Barbell Bench Press"));
    }

    @Test
    void testRemoveNoExercise() {
        assertFalse(filter.removeExercise("zzz"));
    }

    @Test
    void testFindByBarbellEquipment() {
        ArrayList<Exercise> result = filter.findByEquipment(Equipment.BARBELL);
        assertEquals(2, result.size());
    }

    @Test
    void testGetAvailableWithOneEquipment() {
        ArrayList<Equipment> available = new ArrayList<>(Arrays.asList(Equipment.BARBELL));
        List<Exercise> result = filter.getAllAvailableExercises(available);
        assertEquals(2, result.size());
    }

    @Test
    void testGetAvailableWithMultipleEquipment() {
        ArrayList<Equipment> available = new ArrayList<>(Arrays.asList(
                Equipment.BARBELL,
                Equipment.DUMBBELL));
        ArrayList<Exercise> result = filter.getAllAvailableExercises(available);

        assertEquals(6, result.size());
    }
}

package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import enums.Equipment;
import enums.MuscleGroup;
import enums.SplitType;

public class TestExercise {
    private Exercise exercise;
    private ArrayList<MuscleGroup> targetMuscles;
    private ArrayList<SplitType> splits;

    @BeforeEach
    void setUp() {
        targetMuscles = new ArrayList<>();
        targetMuscles.add(MuscleGroup.CHEST);
        targetMuscles.add(MuscleGroup.TRICEPS);

        splits = new ArrayList<>();
        splits.add(SplitType.PUSH);

        exercise = new Exercise(
                "Bench Press",
                targetMuscles,
                Equipment.BARBELL,
                splits,
                135,
                2,
                6,
                10,
                1,
            1);
    }

    @Test
    void testConstructor() {
        assertEquals("Bench Press", exercise.getName());
        assertEquals(targetMuscles, exercise.getTargetMuscles());
        assertEquals(Equipment.BARBELL, exercise.getEquipmentType());
        assertEquals(splits, exercise.getSplitTypes());
        assertEquals(135, exercise.getWeight());
        assertEquals(2, exercise.getSets());
        assertEquals(6, exercise.getMinReps());
        assertEquals(10, exercise.getMaxReps());
        assertEquals(1, exercise.getMaxRir());
    }
}

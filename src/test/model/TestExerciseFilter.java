package model;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import model.generator.ExerciseFilter;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestExerciseFilter {
    private ExerciseFilter filter;
    private Exercise benchPress;
    private Exercise dumbbellCurl;
    
    @BeforeEach
    void setUp() {
        filter = new ExerciseFilter();

        benchPress = new Exercise("Barbell Bench Press",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
                Equipment.BARBELL,
                0, 2, 6, 10, 1, 2);

        dumbbellCurl = new Exercise("Dumbell Curl",
                new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BICEPS)),
                Equipment.DUMBBELL,
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
        assertEquals(17, result.size());
    }

    @Test
    void testGetAvailableWithOneEquipment() {
        ArrayList<Equipment> available = new ArrayList<>(Arrays.asList(Equipment.BARBELL));
        List<Exercise> result = filter.getAllAvailableExercises(available);
        assertEquals(17, result.size());
    }

    @Test
    void testGetAvailableWithMultipleEquipment() {
        ArrayList<Equipment> available = new ArrayList<>(Arrays.asList(
                Equipment.BARBELL,
                Equipment.DUMBBELL));
        ArrayList<Exercise> result = filter.getAllAvailableExercises(available);

        assertEquals(41, result.size());
    }
}

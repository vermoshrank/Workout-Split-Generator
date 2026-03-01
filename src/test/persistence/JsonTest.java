package persistence;

import model.Exercise;
import model.enums.Equipment;
import model.enums.MuscleGroup;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class JsonTest {

    // EFFECTS: asserts all fields of exercise match the expected values
    protected void checkExercise(String name, Equipment equipment, int weight,
                                  int sets, int minReps, int maxReps, int rir,
                                  int priority, ArrayList<MuscleGroup> targetMuscles,
                                  Exercise exercise) {
        assertEquals(name, exercise.getName());
        assertEquals(equipment, exercise.getEquipmentType());
        assertEquals(weight, exercise.getWeight());
        assertEquals(sets, exercise.getSets());
        assertEquals(minReps, exercise.getMinReps());
        assertEquals(maxReps, exercise.getMaxReps());
        assertEquals(rir, exercise.getRir());
        assertEquals(priority, exercise.getPriority());
        assertEquals(targetMuscles.size(), exercise.getTargetMuscles().size());
        for (MuscleGroup mg : targetMuscles) {
            assertTrue(exercise.getTargetMuscles().contains(mg));
        }
    }
}
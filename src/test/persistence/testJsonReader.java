package persistence;

import org.junit.jupiter.api.Test;

import model.Exercise;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.Equipment;
import model.enums.MuscleGroup;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
// based off WorkRoom app
public class TestJsonReader {
    @Test
    void testReaderNonExistentFile() {
        try {
            JsonReader reader = new JsonReader("./data/noFile.json");
            reader.read();
            fail("IOException expected");
        } catch (IOException e) {
            // pass
        }
    }

    @Test
    void testReaderEmptyPlan() {
        try {
            JsonReader reader = new JsonReader("./data/testReaderEmptyPlan.json");
            WorkoutPlan plan = reader.read();
            assertEquals("Empty Plan", plan.getName());
            assertEquals(0, plan.getWorkoutDays().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    @Test
    void testReaderGeneralPlan() {
        try {
            JsonReader reader = new JsonReader("./data/testReaderGeneralPlan.json");
            WorkoutPlan plan = reader.read();
            assertEquals("Push Pull Legs", plan.getName());

            List<WorkoutDay> days = plan.getWorkoutDays();
            assertEquals(2, days.size());
            assertEquals("Push", days.get(0).getName());
            assertEquals("Pull", days.get(1).getName());

            ArrayList<MuscleGroup> chestMuscles = new ArrayList<>();
            chestMuscles.add(MuscleGroup.CHEST);
            chestMuscles.add(MuscleGroup.FRONT_DELTS);
            chestMuscles.add(MuscleGroup.TRICEPS);

            ArrayList<MuscleGroup> latMuscles = new ArrayList<>();
            latMuscles.add(MuscleGroup.LATS);
            latMuscles.add(MuscleGroup.BICEPS);

            List<Exercise> pushExercises = days.get(0).getExercises();
            assertEquals(1, pushExercises.size());

            List<Exercise> pullExercises = days.get(1).getExercises();
            assertEquals(1, pullExercises.size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

}

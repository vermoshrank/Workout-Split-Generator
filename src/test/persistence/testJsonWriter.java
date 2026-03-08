package persistence;

import model.Exercise;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.Equipment;
import model.enums.MuscleGroup;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class TestJsonWriter {

    // From WorkRoom app
    @Test
    void testWriterInvalidFile() {
        try {
            JsonWriter writer = new JsonWriter("./data/my\0illegal:fileName.json");
            writer.open();
            fail("IOException was expected");
        } catch (IOException e) {
            // pass
        }
    }

    // Based off WorkRoom app
    @Test
    void testWriterEmptyPlan() {
        try {
            WorkoutPlan plan = new WorkoutPlan("My workout plan");
            JsonWriter writer = new JsonWriter("./data/testWriterEmptyPlan.json");
            writer.open();
            writer.write(plan);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterEmptyPlan.json");
            plan = reader.read();
            assertEquals("My workout plan", plan.getName());
            assertEquals(0, plan.getWorkoutDays().size());
        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }

    // Based off WorkRoom app
    @Test
    void testWriterGeneralPlan() {
        try {
            WorkoutPlan plan = new WorkoutPlan("Push Pull Legs");

            Exercise benchPress = new Exercise("Barbell Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

            Exercise latPulldown = new Exercise("Lat Pulldown",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.BICEPS)),
            Equipment.LAT_PULLDOWN_MACHINE,
            60, 2, 6, 10, 1, 1);

            WorkoutDay pushDay = new WorkoutDay("Push");
            pushDay.addExercise(benchPress);

            WorkoutDay pullDay = new WorkoutDay("Pull");
            pullDay.addExercise(latPulldown);

            plan.addDay(pushDay);
            plan.addDay(pullDay);

            JsonWriter writer = new JsonWriter("./data/testWriterGeneralPlan.json");
            writer.open();
            writer.write(plan);
            writer.close();

            JsonReader reader = new JsonReader("./data/testWriterGeneralPlan.json");
            plan = reader.read();
            assertEquals("Push Pull Legs", plan.getName());

            List<WorkoutDay> days = plan.getWorkoutDays();
            assertEquals(2, days.size());
            assertEquals("Push", days.get(0).getName());
            assertEquals("Pull", days.get(1).getName());

            List<Exercise> pushExercises = days.get(0).getExercises();
            assertEquals(1, pushExercises.size());

            List<Exercise> pullExercises = days.get(1).getExercises();
            assertEquals(1, pullExercises.size());

        } catch (IOException e) {
            fail("Couldn't read from file");
        }
    }
}

package persistence;

import model.WorkoutDay;
import model.WorkoutPlan;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.stream.Stream;

import org.json.*;

// Based off of WorkRoom app
// Represents a reader that reads workroom from JSON data stored in file
public class JsonReader {
    private String source;

    // EFFECTS: constructs reader to read from source file
    public JsonReader(String source) {
        this.source = source;
    }

    // EFFECTS: reads workroom from file and returns it;
    // throws IOException if an error occurs reading data from file
    public WorkoutPlan read() throws IOException {
        return null;
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        return null;
    }

        // EFFECTS: parses workroom from JSON object and returns it
    private WorkoutPlan parseWorkoutPlan(JSONObject jsonObject) {
        return null;
    }

    // MODIFIES: WorkoutPlan
    // EFFECTS: parses each WorkoutDay from JSON array and adds it to plan
    private void addDays(WorkoutPlan plan, JSONObject jsonObject) {
    }

    // MODIFIES: WorkoutPlan
    // EFFECTS: parses a single WorkoutDay from JSON object and adds it to plan
    private void addDay(WorkoutPlan plan, JSONObject jsonObject) {
    }

    // MODIFIES: WorkoutDay
    // EFFECTS: parses each Exercise from JSON array and adds it to day
    private void addExercises(WorkoutDay day, JSONObject jsonObject) {
    }

    // MODIFIES: WorkoutDay
    // EFFECTS: parses a single Exercise from JSON object and adds it to day
    private void addExercise(WorkoutDay day, JSONObject jsonObject) {
    }
}

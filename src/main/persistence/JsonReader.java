package persistence;

import model.Exercise;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.Equipment;
import model.enums.MuscleGroup;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
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
        String jsonData = readFile(source);
        JSONObject jsonObject = new JSONObject(jsonData);
        return parseWorkoutPlan(jsonObject);
    }

    // EFFECTS: reads source file as string and returns it
    private String readFile(String source) throws IOException {
        StringBuilder contentBuilder = new StringBuilder();

        try (Stream<String> stream = Files.lines(Paths.get(source), StandardCharsets.UTF_8)) {
            stream.forEach(s -> contentBuilder.append(s));
        }

        return contentBuilder.toString();
    }

    // EFFECTS: parses workroom from JSON object and returns it
    private WorkoutPlan parseWorkoutPlan(JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkoutPlan workoutPlan = new WorkoutPlan(name);
        addDays(workoutPlan, jsonObject);
        return workoutPlan;
    }

    // MODIFIES: WorkoutPlan
    // EFFECTS: parses each WorkoutDay from JSON array and adds it to WorkoutPlan
    private void addDays(WorkoutPlan plan, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("days");
        
        for (Object json : jsonArray) {
            JSONObject nextDay = (JSONObject) json;
            addDay(plan, nextDay);
        }
    }

    // MODIFIES: WorkoutPlan
    // EFFECTS: parses a single WorkoutDay from JSON object and adds it to
    // WorkoutPlan
    private void addDay(WorkoutPlan plan, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        WorkoutDay workoutDay = new WorkoutDay(name);
        addExercises(workoutDay, jsonObject);
        plan.addDay(workoutDay);
    }

    // MODIFIES: WorkoutDay
    // EFFECTS: parses each Exercise from JSON array and adds it to WorkoutDay
    private void addExercises(WorkoutDay day, JSONObject jsonObject) {
        JSONArray jsonArray = jsonObject.getJSONArray("exercises");

        for (Object json : jsonArray) {
            JSONObject nextExercise = (JSONObject) json;
            addExercise(day, nextExercise);
        }
    }

    // MODIFIES: WorkoutDay
    // EFFECTS: parses a single Exercise from JSON object and adds it to WorkoutDay
    private void addExercise(WorkoutDay day, JSONObject jsonObject) {
        String name = jsonObject.getString("name");
        Equipment equipment = Equipment.valueOf(jsonObject.getString("equipmentType"));
        int weight = jsonObject.getInt("weight");
        int sets = jsonObject.getInt("sets");
        int minReps = jsonObject.getInt("minReps");
        int maxReps = jsonObject.getInt("maxReps");
        int rir = jsonObject.getInt("rir");
        int priority = jsonObject.getInt("priority");

        ArrayList<MuscleGroup> targetMuscles = new ArrayList<>();
        JSONArray musclesArray = jsonObject.getJSONArray("targetMuscles");
        for (int i = 0; i < musclesArray.length(); i++) {
            targetMuscles.add(MuscleGroup.valueOf(musclesArray.getString(i)));
        }

        Exercise exercise = new Exercise(name, targetMuscles, equipment,
                weight, sets, minReps, maxReps, rir, priority);
        day.addExercise(exercise);
    }
}

package model;

import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import persistence.Writable;

import java.util.ArrayList;

/**
 * Represents a full workout plan composed of one or more WorkoutDays.
 * A WorkoutPlan acts as the highest level object of a workout returned by the
 * split generator
 * and edited by the user. It provides methods to add and remove days and
 * exercises, and to return the total exercise count across all days in the
 * plan.
 */
public class WorkoutPlan implements Writable {
    private String name;
    private ArrayList<WorkoutDay> workoutDays;

    // MODIFIES: this
    // EFFECTS: constructs new plan with empty days
    public WorkoutPlan(String name) {
        this.name = name;
        this.workoutDays = new ArrayList<WorkoutDay>();
    }

    // MODIFIES: this
    // EFFECTS: adds a WorkoutDay for day if not already present
    public void addDay(WorkoutDay day) {
        this.workoutDays.add(day);
    }

    // MODIFIES: this
    // EFFECTS: appends Exercise e to the WorkoutDay of given name
    public void addExerciseToDay(String name, Exercise e) {
        for (WorkoutDay i : this.getWorkoutDays()) {
            if (i.getName().equals(name)) {
                i.addExercise(e);
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: removes Exercise e from the WorkoutDay of given name.
    // return true if successful, false otherwise
    public boolean removeExerciseFromDay(String name, String exerciseName) {
        for (WorkoutDay i : this.getWorkoutDays()) {
            if (i.getName().equals(name)) {
                i.removeExercise(exerciseName);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<WorkoutDay> getWorkoutDays() {
        return this.workoutDays;
    }

    public void setName(String name) {
        this.name = name;
    }

    // EFFECTS: get total exercises in given WorkoutPlan
    public int getTotalExercises(WorkoutPlan plan) {
        int count = 0;
        for (WorkoutDay i : this.getWorkoutDays()) {
            count += i.getTotalExercises();
        }
        return count;
    }

    // EFFECTS: returns this plan as a JSON object
    @Override
    public JSONObject toJson() {
        return null;
    }
}


package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import model.logging.Event;
import model.logging.EventLog;
import persistence.Writable;

/**
 * Represents a single training day within a workout plan. A WorkoutDay has a
 * descriptive name (ex. "Push", "Upper") and an ordered list of exercises to
 * be performed that day. It also provides methods for estimating the
 * total session duration in minutes and the approximate calorie expenditure,
 * based on the volume of the exercises it contains.
 */
public class WorkoutDay implements Writable {
    private String name;
    private List<Exercise> exercises;

    // MODIFIES: this
    // EFFECTS: constructs WorkoutDay for given day
    public WorkoutDay(String name) {
        this.name = name;
        this.exercises = new ArrayList<Exercise>();
    }

    // MODIFIES: this
    // EFFECTS: appends Exercise e to this day's exercises
    public void addExercise(Exercise e) {
        this.exercises.add(e);
    }

    // MODIFIES: this
    // EFFECTS: removes first exercise that matches name; returns true if removed
    public boolean removeExercise(String name) {
        for (int i = 0; i < this.getExercises().size(); i++) {
            if (this.getExercises().get(i).getName().equals(name)) {
                this.getExercises().remove(i);
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }

    public List<Exercise> getExercises() {
        return this.exercises;
    }

    // EFFECTS: returns total number of exercises in given day
    public int getTotalExercises() {
        return this.getExercises().size();
    }

    // EFFECTS: returns estimated session duration based on number of sets of every
    // exercise
    public int calculateSessionLength() {
        int length = 0;
        if (this.getTotalExercises() == 0) {
            return 0;
        } else {
            for (Exercise i : this.getExercises()) {
                length += i.getSets() * 3;
            }
            length -= 3;
            return length;
        }
    }

    // EFFECTS: returns estimated WorkoutDay calorie expenditure
    public double calculateCaloriesBurnt() {
        return 300 * (this.calculateSessionLength() / 60.0);
    }

    // MODIFIES: this
    // EFFECTS: adds exercise and logs the user action
    public void userAddExercise(Exercise e) {
        addExercise(e);
        EventLog.getInstance().logEvent(
                new Event("User added exercise: " + e.getName() + " to " + this.name));
    }

    // MODIFIES: this
    // EFFECTS: removes exercise and logs the user action
    public boolean userRemoveExercise(String name) {
        boolean removed = removeExercise(name);
        if (removed) {
            EventLog.getInstance().logEvent(
                    new Event("User removed exercise: " + name + " from " + this.name));
        }
        return removed;
    }

    // EFFECTS: returns this day as a JSON object
    @Override
    public JSONObject toJson() {
        JSONObject json = new JSONObject();
        json.put("name", name);

        JSONArray exerciseArray = new JSONArray();
        for (Exercise i : exercises) {
            exerciseArray.put(i.toJson());
        }
        json.put("exercises", exerciseArray);

        return json;
    }
}

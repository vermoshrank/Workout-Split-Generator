package model;

import java.util.List;

public class WorkoutDay {

    // MODIFIES: this
    // EFFECTS: constructs WorkoutDay for given day
    public WorkoutDay(String day) {

    }

    
    // MODIFIES: this
    // EFFECTS: appends Exercise e to this day's exercises
    public void addExercise(Exercise e) {

    }

    // MODIFIES: this
    // EFFECTS: removes first exercise that matches name; returns true if removed
    public boolean removeExercise(String name) {
        return true;
    }

    // EFFECTS: returns list of exercises
    public List<Exercise> getExercises() {
        return null;
    }
}

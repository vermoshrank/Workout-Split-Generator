package model;

import java.time.DayOfWeek;
import java.util.ArrayList;
import java.util.List;

public class WorkoutDay {

    private DayOfWeek day;
    private List<Exercise> exercises;
    // MODIFIES: this
    // EFFECTS: constructs WorkoutDay for given day
    public WorkoutDay(DayOfWeek day) {
        this.day = day;
        this.exercises = new ArrayList<Exercise>();
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

    // EFFECTS: returns total number of exercises in given day
    public int getTotalExercises(WorkoutDay day) {
        return 0;
    }
}

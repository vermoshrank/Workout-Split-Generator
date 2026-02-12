package model;

import java.time.DayOfWeek;

public class WorkoutPlan {

    // MODIFIES: this
    // EFFECTS: constructs new plan with empty days
    public WorkoutPlan(String name) {

    }

    // MODIFIES: this
    // EFFECTS: adds a WorkoutDay for day if not already present
    public void addDay(DayOfWeek day) {
        
    }

    // MODIFIES: this
    // EFFECTS: appends Exercise e to that day
    public void addExerciseToDay(DayOfWeek day, Exercise e) {

    }

    // MODIFIES: this
    // EFFECTS: removes Exercise e to that day
    public boolean removeExerciseFromDay(DayOfWeek day, String exerciseName) {
        return true;
    }   

    public String getName() {
        return null;
    }

    public String setName() {
        return null;
    }
}

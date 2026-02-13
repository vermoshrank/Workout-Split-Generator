package model;

import java.time.DayOfWeek;
import java.util.List;
import java.util.ArrayList;

public class WorkoutPlan {

    private String name;
    private List<WorkoutDay> workoutDays;
    // MODIFIES: this
    // EFFECTS: constructs new plan with empty days
    public WorkoutPlan(String name) {
        this.name = name;
        this.workoutDays = new ArrayList<WorkoutDay>();
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

    // EFFECTS: get total exercises in given WorkoutPlan
    public int getTotalExercises(WorkoutPlan plan) {
        return 0;
    }
}

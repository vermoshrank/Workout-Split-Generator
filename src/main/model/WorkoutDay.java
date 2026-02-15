package model;

import java.util.ArrayList;
import java.util.List;

public class WorkoutDay {

    private String name;
    private List<Exercise> exercises;
    private int sessionLength;
    private double calorieExpenditure;

    // MODIFIES: this
    // EFFECTS: constructs WorkoutDay for given day
    public WorkoutDay(String name) {
        this.name = name;
        this.exercises = new ArrayList<Exercise>();
        this.sessionLength = 0;
        this.calorieExpenditure = 0;
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

    public int getSessionLength() {
        return this.sessionLength;
    }

    public double getCalorieExpenditure() {
        return this.calorieExpenditure;
    }

    // EFFECTS: returns total number of exercises in given day
    public int getTotalExercises() {
        return this.getExercises().size();
    }

    // EFFECTS: returns estimated session duration based on number of sets of every
    // exercise
    public void calculateSessionLength() {
        int length = 0;
        if (this.getTotalExercises() == 0) {
            this.sessionLength = length;
        } else {
            for (Exercise i : this.getExercises()) {
                length += i.getSets() * 3;
            }
            length -= 3;
            this.sessionLength = length;
        }
    }

    public void calculateCaloriesBurnt() {
        this.calorieExpenditure = 300 * (this.getSessionLength() / 60.0);
    }
}

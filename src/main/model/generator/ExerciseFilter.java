package model.generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import model.Exercise;
import model.ExerciseDatabase;
import model.enums.Equipment;

/**
 * Manages the pool of exercises that are eligible in a generated
 * workout plan. ExerciseFilter parses through the ExerciseDatabase and filters
 * the
 * full exercise list down to only those that can be performed with the
 * equipment available at the user's gym. The filtered list is passed to the
 * SplitGenerator.
 */
public class ExerciseFilter {
    private ArrayList<Exercise> exercises;

    public ExerciseFilter() {
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds exercise to exercises
    public void addExercise(Exercise e) {
        this.getExercises().add(e);
    }

    // MODIFIES: this
    // EFFECTS: removes first exercise with matching name
    // returns true if removed, false otherwise
    public boolean removeExercise(String name) {
        for (int i = 0; i < this.getExercises().size(); i++) {
            if (this.getExercises().get(i).getName().equals(name)) {
                this.getExercises().remove(i);
                return true;
            }
        }
        return false;
    }

    // EFFECTS: returns current list of exercises
    public ArrayList<Exercise> getExercises() {
        return this.exercises;
    }

    // EFFECTS: returns exercises that require exactly the one, given equipment
    public ArrayList<Exercise> findByEquipment(Equipment equipment) {
        ArrayList<Exercise> availableExercises = new ArrayList<Exercise>();
        for (Exercise i : ExerciseDatabase.getAll()) {
            if (i.getEquipmentType().equals(equipment)) {
                availableExercises.add(i);
            }
        }
        return availableExercises;
    }

    // EFFECTS: returns all exercises available with given pieces of equipment
    public ArrayList<Exercise> getAllAvailableExercises(ArrayList<Equipment> available) {
        ArrayList<Exercise> availableExercises = new ArrayList<Exercise>();
        for (Equipment i : available) {
            for (Exercise j : ExerciseDatabase.getAll()) {
                if (j.getEquipmentType().equals(i)) {
                    availableExercises.add(j);
                }
            }
        }

        this.getExercises().clear();

        for (Exercise i : availableExercises) {
            this.getExercises().add(i);
        }
        return availableExercises;
    }
}

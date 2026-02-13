package generator;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import enums.Equipment;
import model.Exercise;

public class ExerciseFilter {
    private List<Exercise> exercises;

    public ExerciseFilter() {
        exercises = new ArrayList<>();
    }

    // MODIFIES: this
    // EFFECTS: adds exercise to exercises
    public void addExercise(Exercise e) {
        
    }

    // MODIFIES: this
    // EFFECTS: removes first exercise with matching name
    // returns true if removed, false otherwise
    public boolean removeExercise(String name) {
        return true;
    }

    // EFFECTS: returns current list of exercises
    public List<Exercise> getExercises() {
        return null;
    }

    // EFFECTS: returns exercises that require exactly the one, given equipment
    public List<Exercise> findByEquipment (Equipment equipment) {
        return null;
    }

    // EFFECTS: returns all exercises available with given pieces of equipment
    public List<Exercise> getAllAvailableExercises (Set<Equipment> available) {
        return null;
    }
}

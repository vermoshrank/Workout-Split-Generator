package model;

import java.util.ArrayList;
import java.util.List;

import org.json.JSONObject;

import model.enums.Equipment;
import model.enums.MuscleGroup;
import persistence.Writable;

/**
 * Represents a single exercise with all parameters needed
 * in a workout. Each exercise tracks the target muscle groups
 * it stimulates, the equipment it requires, the load (weight), volume
 * (sets and rep range), proximity to failure (reps in reserve), and a priority
 * rating used by the split generator when selecting exercises for a plan.
 */
public class Exercise implements Writable {
    private String name;
    private ArrayList<MuscleGroup> targetMuscles;
    private Equipment equipmentType;
    private int weight;
    private int sets;
    private int minReps;
    private int maxReps;
    private int rir;
    private int priority;

    // REQUIRES: sets > 0; 0 < minReps <= maxReps; rir >= 0
    // MODIFIES: this
    // EFFECTS: constructs an Exercise with the provided parameters
    public Exercise(String name, ArrayList<MuscleGroup> targetMuscles, Equipment equipmentType, int weight, int sets,
            int minReps, int maxReps, int rir, int priority) {
        this.name = name;
        this.targetMuscles = targetMuscles;
        this.equipmentType = equipmentType;
        this.weight = weight;
        this.sets = sets;
        this.minReps = minReps;
        this.maxReps = maxReps;
        this.rir = rir;
        this.priority = priority;
    }

    public String getName() {
        return this.name;
    }

    public ArrayList<MuscleGroup> getTargetMuscles() {
        return this.targetMuscles;
    }

    public Equipment getEquipmentType() {
        return this.equipmentType;
    }

    public int getWeight() {
        return this.weight;
    }

    public int getSets() {
        return this.sets;
    }

    public int getMinReps() {
        return this.minReps;
    }

    public int getMaxReps() {
        return this.maxReps;
    }

    public int getRir() {
        return this.rir;
    }

    public int getPriority() {
        return this.priority;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setTargetMuscles(ArrayList<MuscleGroup> targetMuscles) {
        this.targetMuscles = targetMuscles;
    }

    public void setEquipmentType(Equipment equipmentType) {
        this.equipmentType = equipmentType;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    public void setSets(int sets) {
        this.sets = sets;
    }

    public void setMinReps(int minReps) {
        this.minReps = minReps;
    }

    public void setMaxReps(int maxReps) {
        this.maxReps = maxReps;
    }

    public void setRir(int rir) {
        this.rir = rir;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    // EFFECTS: returns this exercise as a JSON object
    @Override
    public JSONObject toJson() {
        return null;
    }
}

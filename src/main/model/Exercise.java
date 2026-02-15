package model;

import enums.Equipment;
import enums.MuscleGroup;
import enums.SplitType;

import java.util.ArrayList;
import java.util.List;

public class Exercise {

    private String name;
    private ArrayList<MuscleGroup> targetMuscles;
    private Equipment equipmentType;
    private ArrayList<SplitType> splits;
    private int weight;
    private int sets;
    private int minReps;
    private int maxReps;
    private int rir;

    // REQUIRES: sets > 0; 0 < minReps <= maxReps; rir >= 0
    // MODIFIES: this
    // EFFECTS: constructs an Exercise with the provided parameters
    public Exercise(String name, ArrayList<MuscleGroup> targetMuscles, Equipment equipmentType, ArrayList<SplitType> splits, int weight, int sets, int minReps, int maxReps, int rir) {
        this.name = name;
        this.targetMuscles = targetMuscles;
        this.equipmentType = equipmentType;
        this.splits = splits;
        this.weight = weight;
        this.sets = sets;
        this.minReps = minReps;
        this.maxReps = maxReps;
        this.rir = rir;
    }
    public String getName() {
        return null;
    }

    public ArrayList<MuscleGroup> getTargetMuscles() {
        return null;
    }

    public Equipment getEquipmentType() {
        return null;
    }

    public ArrayList<SplitType> getSplitTypes() {
        return null;
    }

    public int getWeight() {
        return 0;
    }

    public int getSets() {
        return 0;
    }

    public int getMinReps() {
        return 0;
    }

    public int getMaxReps() {
        return 0;
    }

    public void setTargetMuscles(ArrayList<MuscleGroup> targetMuscles) {
        // stub
    }

    public void setWeight(int sets) {
        // stub
    }

    public void setSets(int sets) {
        // stub
    }

    public void setMinReps(int minReps) {
        // stub
    }

    public void setMaxReps(int maxReps) {
        // stub
    }

    public void setName(String name) {
        // stub
    }
}

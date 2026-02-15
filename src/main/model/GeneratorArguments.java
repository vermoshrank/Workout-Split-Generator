package model;

import java.util.Set;

import enums.Equipment;
import enums.GymType;

public class GeneratorArguments {
    private int trainingDays;
    private GymType gymType;

    // EFFECTS: constructs an GeneratorArguments with the provided parameters
    public GeneratorArguments(int trainingDays, GymType gymType) {
        this.trainingDays = trainingDays;
        this.gymType = gymType;
    }

    public int getTrainingDays() {
        return this.trainingDays;
    }

    public void setTrainingDays(int trainingDays) {
        this.trainingDays = trainingDays;
    }

    public GymType getGymType() {
        return gymType;
    }

    public void setGymType(GymType gymType) {
        this.gymType = gymType;
    }
}

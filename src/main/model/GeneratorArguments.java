package model;

import java.time.DayOfWeek;
import java.util.Set;

import enums.Equipment;
import enums.GymType;

public class GeneratorArguments {
    private Set<DayOfWeek> trainingDays;
    private GymType gymType;

    // EFFECTS: constructs an GeneratorArguments with the provided parameters
    public GeneratorArguments(Set<DayOfWeek> trainingDays, GymType gymType) {
        this.trainingDays = trainingDays;
        this.gymType = gymType;
    }

    public Set<DayOfWeek> getTrainingDays() {
        return trainingDays;
    }

    public void setTrainingDays(Set<DayOfWeek> trainingDays) {
        this.trainingDays = trainingDays;
    }

    public GymType getGymType() {
        return gymType;
    }

    public void setGymType(GymType gymType) {
        this.gymType = gymType;
    }

}

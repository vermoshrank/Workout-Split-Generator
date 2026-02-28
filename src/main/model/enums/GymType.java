package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

public enum GymType {
    EVERYTHING(Equipment.values()),
    COMMERCIAL(Equipment.values()),
    LOCAL(Equipment.values()),
    HOME(Equipment.values());

    private final ArrayList<Equipment> availableEquipment;

    // EFFECTS: constructs GymType enum with variable number of equipment
    GymType(Equipment... equipment) {
        this.availableEquipment = new ArrayList<>(Arrays.asList(equipment));
    }

    public ArrayList<Equipment> getAvailableEquipment() {
        return this.availableEquipment;
    }

}

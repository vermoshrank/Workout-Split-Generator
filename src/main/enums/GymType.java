package enums;

import java.util.ArrayList;
import java.util.Arrays;

import enums.Equipment;

public enum GymType {
    EVERYTHING_GYM(Equipment.values()),
    COMMERCIAL_GYM,
    LOCAL_GYM,
    HOME_GYM;

    private final ArrayList<Equipment> availableEquipment;

    // EFFECTS: constructs GymType enum with variable number of equipment
    GymType(Equipment... equipment) {
        this.availableEquipment = new ArrayList<>(Arrays.asList(equipment));
    }

    public ArrayList<Equipment> getAvailableEquipment() {
        return this.availableEquipment;
    }

}

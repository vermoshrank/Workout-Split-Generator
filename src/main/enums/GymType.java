package enums;

import java.util.ArrayList;
import java.util.Arrays;

import enums.Equipment;

public enum GymType {
    EVERYTHING(Equipment.values()),
    COMMERCIAL,
    LOCAL,
    HOME;

    private final ArrayList<Equipment> availableEquipment;

    // EFFECTS: constructs GymType enum with variable number of equipment
    GymType(Equipment... equipment) {
        this.availableEquipment = new ArrayList<>(Arrays.asList(equipment));
    }

    public ArrayList<Equipment> getAvailableEquipment() {
        return this.availableEquipment;
    }

}

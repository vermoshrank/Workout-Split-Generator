package model.enums;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Contains the types of gyms available, each with the set of equipment
 * available in that
 * setting. EVERYTHING includes all defined equipment, COMMERCIAL
 * covers a fully-equipped commercial gym with all major machines, LOCAL
 * represents a smaller gym with a reduced machine selection, and HOME
 * covers a home gym with free weights and a cable setup but no
 * dedicated machines. The available equipment list for each variant is used by
 * ExerciseFilter to determine which exercises can be included in a generated
 * plan.
 */
public enum GymType {
    EVERYTHING(Equipment.values()),

    COMMERCIAL(// Free weights
            Equipment.BARBELL,
            Equipment.EZ_BAR,
            Equipment.DUMBBELL,
            Equipment.KETTLEBELL,

            // Bodyweight / stations
            Equipment.BODYWEIGHT,
            Equipment.PULL_UP_BAR,
            Equipment.DIP_STATION,

            // Benches / racks
            Equipment.SQUAT_RACK,
            Equipment.SMITH_MACHINE,
            Equipment.FLAT_BENCH,
            Equipment.INCLINE_BENCH,
            Equipment.DECLINE_BENCH,
            Equipment.PREACHER_BENCH,
            Equipment.HYPEREXTENSION_BENCH,

            // Cable
            Equipment.CABLE,
            Equipment.CABLE_MACHINE,

            // Chest machines
            Equipment.PEC_DECK_MACHINE,
            Equipment.CHEST_PRESS_MACHINE,
            Equipment.INCLINE_CHEST_PRESS_MACHINE,

            // Back machines
            Equipment.LAT_PULLDOWN_MACHINE,
            Equipment.ROW_MACHINE,
            Equipment.SEATED_ROW_MACHINE,
            Equipment.CHEST_SUPPORTED_ROW_MACHINE,
            Equipment.T_BAR_ROW,

            // Shoulder machines
            Equipment.SHOULDER_PRESS_MACHINE,
            Equipment.LATERAL_RAISE_MACHINE,
            Equipment.REAR_DELT_FLY_MACHINE,

            // Arm machines
            Equipment.MACHINE_PREACHER_CURL,
            Equipment.MACHINE_BICEP_CURL,
            Equipment.MACHINE_TRICEP_EXTENSION,
            Equipment.MACHINE_DIP,

            // Leg machines
            Equipment.LEG_PRESS_MACHINE,
            Equipment.LEG_EXTENSION_MACHINE,
            Equipment.LEG_CURL_MACHINE,
            Equipment.SEATED_LEG_CURL_MACHINE,
            Equipment.LYING_LEG_CURL_MACHINE,
            Equipment.CALF_RAISE_MACHINE,
            Equipment.SEATED_CALF_RAISE_MACHINE,
            Equipment.HACK_SQUAT_MACHINE,
            Equipment.HIP_THRUST_MACHINE,
            Equipment.HIP_ABDUCTION_MACHINE,
            Equipment.HIP_ADDUCTION_MACHINE,
            Equipment.GLUTE_KICKBACK_MACHINE,

            // Core machines
            Equipment.AB_CRUNCH_MACHINE),

    LOCAL(// Free weights
            Equipment.BARBELL,
            Equipment.EZ_BAR,
            Equipment.DUMBBELL,
            Equipment.KETTLEBELL,

            // Bodyweight / stations
            Equipment.BODYWEIGHT,
            Equipment.DIP_STATION,

            // Benches / racks
            Equipment.SQUAT_RACK,
            Equipment.SMITH_MACHINE,
            Equipment.FLAT_BENCH,
            Equipment.INCLINE_BENCH,
            Equipment.DECLINE_BENCH,
            Equipment.PREACHER_BENCH,
            Equipment.HYPEREXTENSION_BENCH,

            // Cable
            Equipment.CABLE,
            Equipment.CABLE_MACHINE,

            // Chest machines
            Equipment.PEC_DECK_MACHINE,
            Equipment.CHEST_PRESS_MACHINE,

            // Back machines
            Equipment.LAT_PULLDOWN_MACHINE,
            Equipment.ROW_MACHINE,
            Equipment.SEATED_ROW_MACHINE,

            // Shoulder machines
            Equipment.SHOULDER_PRESS_MACHINE,
            Equipment.REAR_DELT_FLY_MACHINE,

            // Arm machines
            Equipment.MACHINE_PREACHER_CURL,
            Equipment.MACHINE_TRICEP_EXTENSION,

            // Leg machines
            Equipment.LEG_PRESS_MACHINE,
            Equipment.LEG_EXTENSION_MACHINE,
            Equipment.SEATED_LEG_CURL_MACHINE,
            Equipment.LYING_LEG_CURL_MACHINE,
            Equipment.CALF_RAISE_MACHINE,
            Equipment.HIP_ABDUCTION_MACHINE,
            Equipment.HIP_ADDUCTION_MACHINE,

            // Core machines
            Equipment.AB_CRUNCH_MACHINE),

    HOME(// Free weights
            Equipment.BARBELL,
            Equipment.EZ_BAR,
            Equipment.DUMBBELL,
            Equipment.KETTLEBELL,

            // Bodyweight / stations
            Equipment.BODYWEIGHT,
            Equipment.DIP_STATION,

            // Benches / racks
            Equipment.SQUAT_RACK,
            Equipment.FLAT_BENCH,
            Equipment.INCLINE_BENCH,
            Equipment.DECLINE_BENCH,
            Equipment.PREACHER_BENCH,
            Equipment.HYPEREXTENSION_BENCH,

            // Cable
            Equipment.CABLE,
            Equipment.CABLE_MACHINE);

    private final ArrayList<Equipment> availableEquipment;

    // EFFECTS: constructs GymType enum with variable number of equipment
    GymType(Equipment... equipment) {
        this.availableEquipment = new ArrayList<>(Arrays.asList(equipment));
    }

    public ArrayList<Equipment> getAvailableEquipment() {
        return this.availableEquipment;
    }
}

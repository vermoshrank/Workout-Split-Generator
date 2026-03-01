package model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import model.enums.Equipment;
import model.enums.MuscleGroup;

public class ExerciseDatabase {
    private ExerciseDatabase() {
    }

    
    // CHEST
    

    // Barbell
    public static Exercise BARBELL_BENCH_PRESS = new Exercise("Barbell Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

    public static Exercise INCLINE_BARBELL_BENCH_PRESS = new Exercise("Incline Barbell Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.BARBELL,
            75, 2, 6, 10, 1, 2);

    public static Exercise DECLINE_BARBELL_BENCH_PRESS = new Exercise("Decline Barbell Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.BARBELL,
            85, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise DUMBBELL_BENCH_PRESS = new Exercise("Dumbbell Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.DUMBBELL,
            30, 2, 6, 10, 1, 2);

    public static Exercise INCLINE_DUMBBELL_PRESS = new Exercise("Incline Dumbbell Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_CHEST, MuscleGroup.FRONT_DELTS)),
            Equipment.DUMBBELL,
            25, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_FLYE = new Exercise("Dumbbell Flye",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST)),
            Equipment.DUMBBELL,
            15, 2, 6, 10, 1, 2);

    public static Exercise INCLINE_DUMBBELL_FLYE = new Exercise("Incline Dumbbell Flye",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_CHEST)),
            Equipment.DUMBBELL,
            12, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise CABLE_CROSSOVER = new Exercise("Cable Crossover",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST)),
            Equipment.CABLE,
            20, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise PEC_DECK = new Exercise("Pec Deck",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST)),
            Equipment.PEC_DECK_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise CHEST_PRESS_MACHINE = new Exercise("Chest Press Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.CHEST_PRESS_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise INCLINE_CHEST_PRESS_MACHINE = new Exercise("Incline Chest Press Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.INCLINE_CHEST_PRESS_MACHINE,
            40, 2, 6, 10, 1, 1);

    // Bodyweight
    public static Exercise PUSH_UP = new Exercise("Push-Up",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.BODYWEIGHT,
            0, 2, 6, 10, 1, 3);

    public static Exercise CHEST_DIP = new Exercise("Chest Dip",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.TRICEPS, MuscleGroup.FRONT_DELTS)),
            Equipment.DIP_STATION,
            0, 2, 6, 10, 1, 2);

    // Smith Machine
    public static Exercise SMITH_MACHINE_BENCH_PRESS = new Exercise("Smith Machine Bench Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.SMITH_MACHINE,
            75, 2, 6, 10, 1, 2);

    public static Exercise SMITH_MACHINE_INCLINE_PRESS = new Exercise("Smith Machine Incline Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_CHEST, MuscleGroup.FRONT_DELTS, MuscleGroup.TRICEPS)),
            Equipment.SMITH_MACHINE,
            65, 2, 6, 10, 1, 2);

    
    // BACK
    

    // Barbell
    public static Exercise BARBELL_ROW = new Exercise("Barbell Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.BICEPS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

    public static Exercise DEADLIFT = new Exercise("Deadlift",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES, MuscleGroup.ERECTORS, MuscleGroup.TRAPS)),
            Equipment.BARBELL,
            135, 2, 6, 10, 1, 2);

    public static Exercise RACK_PULL = new Exercise("Rack Pull",
            new ArrayList<>(Arrays.asList(MuscleGroup.ERECTORS, MuscleGroup.TRAPS, MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES)),
            Equipment.BARBELL,
            155, 2, 6, 10, 1, 2);

    public static Exercise ROMANIAN_DEADLIFT = new Exercise("Romanian Deadlift",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES, MuscleGroup.ERECTORS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

    public static Exercise PENDLAY_ROW = new Exercise("Pendlay Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.BICEPS)),
            Equipment.BARBELL,
            85, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise SINGLE_ARM_DUMBBELL_ROW = new Exercise("Single-Arm Dumbbell Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.BICEPS)),
            Equipment.DUMBBELL,
            30, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_ROMANIAN_DEADLIFT = new Exercise("Dumbbell Romanian Deadlift",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES, MuscleGroup.ERECTORS)),
            Equipment.DUMBBELL,
            30, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_PULLOVER = new Exercise("Dumbbell Pullover",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.CHEST)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise LAT_PULLDOWN = new Exercise("Lat Pulldown",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.BICEPS)),
            Equipment.LAT_PULLDOWN_MACHINE,
            60, 2, 6, 10, 1, 1);

    public static Exercise CLOSE_GRIP_LAT_PULLDOWN = new Exercise("Close Grip Lat Pulldown",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.BICEPS)),
            Equipment.LAT_PULLDOWN_MACHINE,
            55, 2, 6, 10, 1, 1);

    public static Exercise SEATED_CABLE_ROW = new Exercise("Seated Cable Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.BICEPS)),
            Equipment.SEATED_ROW_MACHINE,
            60, 2, 6, 10, 1, 1);

    public static Exercise WIDE_GRIP_SEATED_CABLE_ROW = new Exercise("Wide Grip Seated Cable Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.REAR_DELTS)),
            Equipment.SEATED_ROW_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise CABLE_PULLOVER = new Exercise("Cable Pullover",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS)),
            Equipment.CABLE,
            25, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise UPPER_BACK_ROW = new Exercise("Upper Back Row Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRAPS, MuscleGroup.RHOMBOIDS, MuscleGroup.REAR_DELTS)),
            Equipment.ROW_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise CHEST_SUPPORTED_ROW = new Exercise("Chest Supported Row Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.BICEPS)),
            Equipment.CHEST_SUPPORTED_ROW_MACHINE,
            45, 2, 6, 10, 1, 1);

    // T-Bar
    public static Exercise T_BAR_ROW = new Exercise("T-Bar Row",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.RHOMBOIDS, MuscleGroup.TRAPS, MuscleGroup.BICEPS)),
            Equipment.T_BAR_ROW,
            45, 2, 6, 10, 1, 2);

    // Bodyweight
    public static Exercise PULL_UP = new Exercise("Pull-Up",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.BICEPS)),
            Equipment.PULL_UP_BAR,
            0, 2, 6, 10, 1, 3);

    public static Exercise CHIN_UP = new Exercise("Chin-Up",
            new ArrayList<>(Arrays.asList(MuscleGroup.LATS, MuscleGroup.BICEPS)),
            Equipment.PULL_UP_BAR,
            0, 2, 6, 10, 1, 3);

    public static Exercise BACK_EXTENSION = new Exercise("Back Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.ERECTORS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.HYPEREXTENSION_BENCH,
            0, 2, 6, 10, 1, 2);

    public static Exercise WEIGHTED_BACK_EXTENSION = new Exercise("Weighted Back Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.ERECTORS, MuscleGroup.GLUTES)),
            Equipment.HYPEREXTENSION_BENCH,
            25, 2, 6, 10, 1, 2);


    
    // LEGS
    

    // Barbell
    public static Exercise BARBELL_BACK_SQUAT = new Exercise("Barbell Back Squat",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS, MuscleGroup.ERECTORS)),
            Equipment.SQUAT_RACK,
            115, 2, 6, 10, 1, 2);

    public static Exercise BARBELL_FRONT_SQUAT = new Exercise("Barbell Front Squat",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.ERECTORS)),
            Equipment.SQUAT_RACK,
            85, 2, 6, 10, 1, 2);

    public static Exercise BARBELL_HIP_THRUST = new Exercise("Barbell Hip Thrust",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

    public static Exercise BARBELL_LUNGE = new Exercise("Barbell Lunge",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.BARBELL,
            65, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise DUMBBELL_LUNGE = new Exercise("Dumbbell Lunge",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_HIP_THRUST = new Exercise("Dumbbell Hip Thrust",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.DUMBBELL,
            30, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_STEP_UP = new Exercise("Dumbbell Step Up",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_STANDING_CALF_RAISE = new Exercise("Dumbbell Standing Calf Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.CALVES)),
            Equipment.DUMBBELL,
            25, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise LEG_PRESS = new Exercise("Leg Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.LEG_PRESS_MACHINE,
            90, 2, 6, 10, 1, 1);

    public static Exercise LEG_EXTENSION = new Exercise("Leg Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS)),
            Equipment.LEG_EXTENSION_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise SEATED_LEG_CURL = new Exercise("Seated Leg Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS)),
            Equipment.SEATED_LEG_CURL_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise LYING_LEG_CURL = new Exercise("Lying Leg Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS)),
            Equipment.LYING_LEG_CURL_MACHINE,
            45, 2, 6, 10, 1, 1);

    public static Exercise STANDING_CALF_RAISE = new Exercise("Standing Calf Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.CALVES)),
            Equipment.CALF_RAISE_MACHINE,
            60, 2, 6, 10, 1, 1);

    public static Exercise SEATED_CALF_RAISE = new Exercise("Seated Calf Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.CALVES)),
            Equipment.SEATED_CALF_RAISE_MACHINE,
            45, 2, 6, 10, 1, 1);

    public static Exercise HACK_SQUAT = new Exercise("Hack Squat",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES)),
            Equipment.HACK_SQUAT_MACHINE,
            70, 2, 6, 10, 1, 1);

    public static Exercise MACHINE_HIP_THRUST = new Exercise("Machine Hip Thrust",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.HIP_THRUST_MACHINE,
            70, 2, 6, 10, 1, 1);

    public static Exercise HIP_ABDUCTION_MACHINE = new Exercise("Hip Abduction Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.HIP_ABDUCTORS, MuscleGroup.GLUTES)),
            Equipment.HIP_ABDUCTION_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise HIP_ADDUCTION_MACHINE = new Exercise("Hip Adduction Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.HIP_ADDUCTORS)),
            Equipment.HIP_ADDUCTION_MACHINE,
            50, 2, 6, 10, 1, 1);

    public static Exercise GLUTE_KICKBACK_MACHINE = new Exercise("Glute Kickback Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES)),
            Equipment.GLUTE_KICKBACK_MACHINE,
            30, 2, 6, 10, 1, 1);

    // Smith Machine
    public static Exercise SMITH_MACHINE_SQUAT = new Exercise("Smith Machine Squat",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.SMITH_MACHINE,
            85, 2, 6, 10, 1, 2);

    public static Exercise SMITH_MACHINE_BULGARIAN_SPLIT_SQUAT = new Exercise("Smith Machine Bulgarian Split Squat",
            new ArrayList<>(Arrays.asList(MuscleGroup.QUADS, MuscleGroup.GLUTES)),
            Equipment.SMITH_MACHINE,
            65, 2, 6, 10, 1, 2);

    public static Exercise SMITH_MACHINE_HIP_THRUST = new Exercise("Smith Machine Hip Thrust",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS)),
            Equipment.SMITH_MACHINE,
            75, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise CABLE_PULL_THROUGH = new Exercise("Cable Pull Through",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES, MuscleGroup.HAMSTRINGS, MuscleGroup.ERECTORS)),
            Equipment.CABLE,
            40, 2, 6, 10, 1, 2);

    public static Exercise CABLE_KICKBACK = new Exercise("Cable Kickback",
            new ArrayList<>(Arrays.asList(MuscleGroup.GLUTES)),
            Equipment.CABLE,
            15, 2, 6, 10, 1, 2);

    public static Exercise CABLE_LEG_CURL = new Exercise("Cable Leg Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS)),
            Equipment.CABLE,
            20, 2, 6, 10, 1, 2);

    public static Exercise NORDIC_CURL = new Exercise("Nordic Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.HAMSTRINGS)),
            Equipment.BODYWEIGHT,
            0, 2, 6, 10, 1, 3);


    
    // SHOULDERS
    

    // Barbell
    public static Exercise BARBELL_OVERHEAD_PRESS = new Exercise("Barbell Overhead Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS)),
            Equipment.BARBELL,
            65, 2, 6, 10, 1, 2);


    public static Exercise BARBELL_SHRUG = new Exercise("Barbell Shrug",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_TRAPS, MuscleGroup.TRAPS)),
            Equipment.BARBELL,
            95, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise DUMBBELL_SHOULDER_PRESS = new Exercise("Dumbbell Shoulder Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise LATERAL_RAISE = new Exercise("Dumbbell Lateral Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.SIDE_DELTS)),
            Equipment.DUMBBELL,
            10, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_FRONT_RAISE = new Exercise("Dumbbell Front Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS)),
            Equipment.DUMBBELL,
            10, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_REAR_DELT_FLY = new Exercise("Dumbbell Rear Delt Fly",
            new ArrayList<>(Arrays.asList(MuscleGroup.REAR_DELTS, MuscleGroup.RHOMBOIDS)),
            Equipment.DUMBBELL,
            10, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_SHRUG = new Exercise("Dumbbell Shrug",
            new ArrayList<>(Arrays.asList(MuscleGroup.UPPER_TRAPS, MuscleGroup.TRAPS)),
            Equipment.DUMBBELL,
            30, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise REAR_DELT_FLY = new Exercise("Cable Rear Delt Fly",
            new ArrayList<>(Arrays.asList(MuscleGroup.REAR_DELTS, MuscleGroup.RHOMBOIDS)),
            Equipment.CABLE,
            10, 2, 6, 10, 1, 2);

    public static Exercise CABLE_LATERAL_RAISE = new Exercise("Cable Lateral Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.SIDE_DELTS)),
            Equipment.CABLE,
            10, 2, 6, 10, 1, 2);

    public static Exercise CABLE_FRONT_RAISE = new Exercise("Cable Front Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS)),
            Equipment.CABLE,
            10, 2, 6, 10, 1, 2);

    public static Exercise FACE_PULL = new Exercise("Face Pull",
            new ArrayList<>(Arrays.asList(MuscleGroup.REAR_DELTS, MuscleGroup.RHOMBOIDS)),
            Equipment.CABLE,
            30, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise MACHINE_SHOULDER_PRESS = new Exercise("Machine Shoulder Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS)),
            Equipment.SHOULDER_PRESS_MACHINE,
            40, 2, 6, 10, 1, 1);

    public static Exercise MACHINE_LATERAL_RAISE = new Exercise("Machine Lateral Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.SIDE_DELTS)),
            Equipment.LATERAL_RAISE_MACHINE,
            20, 2, 6, 10, 1, 1);

    public static Exercise MACHINE_REAR_DELT_FLY = new Exercise("Machine Rear Delt Fly",
            new ArrayList<>(Arrays.asList(MuscleGroup.REAR_DELTS, MuscleGroup.RHOMBOIDS)),
            Equipment.REAR_DELT_FLY_MACHINE,
            20, 2, 6, 10, 1, 1);

    // Smith Machine
    public static Exercise SMITH_MACHINE_OVERHEAD_PRESS = new Exercise("Smith Machine Overhead Press",
            new ArrayList<>(Arrays.asList(MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS)),
            Equipment.SMITH_MACHINE,
            55, 2, 6, 10, 1, 2);


    
    // BICEPS
    

    // Barbell
    public static Exercise BARBELL_CURL = new Exercise("Barbell Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS, MuscleGroup.BRACHIALIS)),
            Equipment.BARBELL,
            55, 2, 6, 10, 1, 2);

    public static Exercise EZ_BAR_CURL = new Exercise("EZ Bar Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS, MuscleGroup.BRACHIALIS)),
            Equipment.EZ_BAR,
            50, 2, 6, 10, 1, 2);

    public static Exercise EZ_BAR_PREACHER_CURL = new Exercise("EZ Bar Preacher Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS)),
            Equipment.PREACHER_BENCH,
            40, 2, 6, 10, 1, 2);

    public static Exercise REVERSE_BARBELL_CURL = new Exercise("Reverse Barbell Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BRACHIORADIALIS, MuscleGroup.FOREARMS, MuscleGroup.BICEPS)),
            Equipment.BARBELL,
            35, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise DUMBBELL_CURL = new Exercise("Dumbbell Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS, MuscleGroup.BRACHIALIS)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise HAMMER_CURL = new Exercise("Hammer Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BRACHIALIS, MuscleGroup.BRACHIORADIALIS, MuscleGroup.BICEPS)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_PREACHER_CURL = new Exercise("Dumbbell Preacher Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS)),
            Equipment.PREACHER_BENCH,
            15, 2, 6, 10, 1, 2);

    public static Exercise REVERSE_DUMBBELL_CURL = new Exercise("Reverse Dumbbell Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BRACHIORADIALIS, MuscleGroup.FOREARMS)),
            Equipment.DUMBBELL,
            12, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise CABLE_CURL = new Exercise("Cable Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS, MuscleGroup.BRACHIALIS)),
            Equipment.CABLE,
            30, 2, 6, 10, 1, 2);

    public static Exercise CABLE_HAMMER_CURL = new Exercise("Cable Hammer Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BRACHIALIS, MuscleGroup.BRACHIORADIALIS)),
            Equipment.CABLE,
            25, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise MACHINE_PREACHER_CURL = new Exercise("Machine Preacher Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS)),
            Equipment.MACHINE_PREACHER_CURL,
            30, 2, 6, 10, 1, 1);

    public static Exercise MACHINE_BICEP_CURL = new Exercise("Machine Bicep Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BICEPS, MuscleGroup.BRACHIALIS)),
            Equipment.MACHINE_BICEP_CURL,
            30, 2, 6, 10, 1, 1);


    
    // TRICEPS
    

    // Barbell
    public static Exercise SKULL_CRUSHER = new Exercise("Skull Crusher",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.EZ_BAR,
            45, 2, 6, 10, 1, 2);

    public static Exercise BARBELL_OVERHEAD_TRICEP_EXTENSION = new Exercise("Barbell Overhead Tricep Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.BARBELL,
            45, 2, 6, 10, 1, 2);

    // Dumbbell
    public static Exercise DUMBBELL_OVERHEAD_TRICEP_EXTENSION = new Exercise("Dumbbell Overhead Tricep Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.DUMBBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_KICKBACK = new Exercise("Dumbbell Kickback",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.DUMBBELL,
            12, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_SKULL_CRUSHER = new Exercise("Dumbbell Skull Crusher",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.DUMBBELL,
            15, 2, 6, 10, 1, 2);

    // Cable
    public static Exercise TRICEP_PUSHDOWN = new Exercise("Cable Tricep Pushdown",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.CABLE,
            35, 2, 6, 10, 1, 2);

    public static Exercise CABLE_OVERHEAD_TRICEP_EXTENSION = new Exercise("Cable Overhead Tricep Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.CABLE,
            30, 2, 6, 10, 1, 2);

    // Machine
    public static Exercise MACHINE_TRICEP_EXTENSION = new Exercise("Machine Tricep Extension",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.MACHINE_TRICEP_EXTENSION,
            40, 2, 6, 10, 1, 1);

    // Bodyweight
    public static Exercise TRICEP_DIP = new Exercise("Tricep Dip",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS, MuscleGroup.FRONT_DELTS, MuscleGroup.CHEST)),
            Equipment.DIP_STATION,
            0, 2, 6, 10, 1, 2);

    public static Exercise DIAMOND_PUSH_UP = new Exercise("Diamond Push-Up",
            new ArrayList<>(Arrays.asList(MuscleGroup.TRICEPS, MuscleGroup.CHEST)),
            Equipment.BODYWEIGHT,
            0, 2, 6, 10, 1, 3);


    
    // FOREARMS
    

    public static Exercise BARBELL_WRIST_CURL = new Exercise("Barbell Wrist Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.FOREARMS)),
            Equipment.BARBELL,
            25, 2, 6, 10, 1, 2);

    public static Exercise BARBELL_REVERSE_WRIST_CURL = new Exercise("Barbell Reverse Wrist Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.FOREARMS, MuscleGroup.BRACHIORADIALIS)),
            Equipment.BARBELL,
            20, 2, 6, 10, 1, 2);

    public static Exercise DUMBBELL_WRIST_CURL = new Exercise("Dumbbell Wrist Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.FOREARMS)),
            Equipment.DUMBBELL,
            10, 2, 6, 10, 1, 2);

    public static Exercise REVERSE_CABLE_CURL = new Exercise("Reverse Cable Curl",
            new ArrayList<>(Arrays.asList(MuscleGroup.BRACHIORADIALIS)),
            Equipment.DUMBBELL,
            10, 2, 6, 10, 1, 2);




    
    // CORE
    

    public static Exercise CABLE_CRUNCH = new Exercise("Cable Crunch",
            new ArrayList<>(Arrays.asList(MuscleGroup.ABS)),
            Equipment.CABLE,
            40, 2, 6, 10, 1, 2);

    public static Exercise AB_CRUNCH_MACHINE = new Exercise("Ab Crunch Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.ABS)),
            Equipment.AB_CRUNCH_MACHINE,
            40, 2, 6, 10, 1, 1);

    public static Exercise ROTARY_TORSO_MACHINE = new Exercise("Rotary Torso Machine",
            new ArrayList<>(Arrays.asList(MuscleGroup.OBLIQUES)),
            Equipment.ROTARY_TORSO_MACHINE,
            30, 2, 6, 10, 1, 1);

    public static Exercise PLANK = new Exercise("Plank",
            new ArrayList<>(Arrays.asList(MuscleGroup.CORE, MuscleGroup.ABS)),
            Equipment.BODYWEIGHT,
            0, 2, 6, 10, 1, 3);

    public static Exercise HANGING_LEG_RAISE = new Exercise("Hanging Leg Raise",
            new ArrayList<>(Arrays.asList(MuscleGroup.ABS, MuscleGroup.HIP_FLEXORS)),
            Equipment.BODYWEIGHT,
            0, 2, 6, 10, 1, 2);


    
    // ALL EXERCISES
    

    public static ArrayList<Exercise> ALL = new ArrayList<>(List.of(
            // CHEST
            BARBELL_BENCH_PRESS,
            INCLINE_BARBELL_BENCH_PRESS,
            DECLINE_BARBELL_BENCH_PRESS,
            DUMBBELL_BENCH_PRESS,
            INCLINE_DUMBBELL_PRESS,
            DUMBBELL_FLYE,
            INCLINE_DUMBBELL_FLYE,
            CABLE_CROSSOVER,
            PEC_DECK,
            CHEST_PRESS_MACHINE,
            INCLINE_CHEST_PRESS_MACHINE,
            PUSH_UP,
            CHEST_DIP,
            SMITH_MACHINE_BENCH_PRESS,
            SMITH_MACHINE_INCLINE_PRESS,

            // BACK
            BARBELL_ROW,
            DEADLIFT,
            RACK_PULL,
            ROMANIAN_DEADLIFT,
            PENDLAY_ROW,
            SINGLE_ARM_DUMBBELL_ROW,
            DUMBBELL_ROMANIAN_DEADLIFT,
            DUMBBELL_PULLOVER,
            LAT_PULLDOWN,
            CLOSE_GRIP_LAT_PULLDOWN,
            SEATED_CABLE_ROW,
            WIDE_GRIP_SEATED_CABLE_ROW,
            CABLE_PULLOVER,
            UPPER_BACK_ROW,
            CHEST_SUPPORTED_ROW,
            T_BAR_ROW,
            PULL_UP,
            CHIN_UP,
            BACK_EXTENSION,
            WEIGHTED_BACK_EXTENSION,

            // LEGS
            BARBELL_BACK_SQUAT,
            BARBELL_FRONT_SQUAT,
            BARBELL_HIP_THRUST,
            BARBELL_LUNGE,
            DUMBBELL_LUNGE,
            DUMBBELL_HIP_THRUST,
            DUMBBELL_STEP_UP,
            DUMBBELL_STANDING_CALF_RAISE,
            LEG_PRESS,
            LEG_EXTENSION,
            SEATED_LEG_CURL,
            LYING_LEG_CURL,
            STANDING_CALF_RAISE,
            SEATED_CALF_RAISE,
            HACK_SQUAT,
            MACHINE_HIP_THRUST,
            HIP_ABDUCTION_MACHINE,
            HIP_ADDUCTION_MACHINE,
            GLUTE_KICKBACK_MACHINE,
            SMITH_MACHINE_SQUAT,
            SMITH_MACHINE_BULGARIAN_SPLIT_SQUAT,
            SMITH_MACHINE_HIP_THRUST,
            CABLE_PULL_THROUGH,
            CABLE_KICKBACK,
            CABLE_LEG_CURL,
            NORDIC_CURL,

            // SHOULDERS
            BARBELL_OVERHEAD_PRESS,
            BARBELL_SHRUG,
            DUMBBELL_SHOULDER_PRESS,
            LATERAL_RAISE,
            DUMBBELL_FRONT_RAISE,
            DUMBBELL_REAR_DELT_FLY,
            DUMBBELL_SHRUG,
            REAR_DELT_FLY,
            CABLE_LATERAL_RAISE,
            CABLE_FRONT_RAISE,
            FACE_PULL,
            MACHINE_SHOULDER_PRESS,
            MACHINE_LATERAL_RAISE,
            MACHINE_REAR_DELT_FLY,
            SMITH_MACHINE_OVERHEAD_PRESS,

            // BICEPS
            BARBELL_CURL,
            EZ_BAR_CURL,
            EZ_BAR_PREACHER_CURL,
            REVERSE_BARBELL_CURL,
            DUMBBELL_CURL,
            HAMMER_CURL,
            DUMBBELL_PREACHER_CURL,
            REVERSE_DUMBBELL_CURL,
            CABLE_CURL,
            CABLE_HAMMER_CURL,
            MACHINE_PREACHER_CURL,
            MACHINE_BICEP_CURL,

            // TRICEPS
            SKULL_CRUSHER,
            BARBELL_OVERHEAD_TRICEP_EXTENSION,
            DUMBBELL_OVERHEAD_TRICEP_EXTENSION,
            DUMBBELL_KICKBACK,
            DUMBBELL_SKULL_CRUSHER,
            TRICEP_PUSHDOWN,
            CABLE_OVERHEAD_TRICEP_EXTENSION,
            MACHINE_TRICEP_EXTENSION,
            TRICEP_DIP,
            DIAMOND_PUSH_UP,

            // FOREARMS
            BARBELL_WRIST_CURL,
            BARBELL_REVERSE_WRIST_CURL,
            DUMBBELL_WRIST_CURL,
	        REVERSE_CABLE_CURL,

            // CORE
            CABLE_CRUNCH,
            AB_CRUNCH_MACHINE,
            ROTARY_TORSO_MACHINE,
            PLANK,
            HANGING_LEG_RAISE
    ));
}
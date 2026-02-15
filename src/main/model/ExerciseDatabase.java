package model;

import enums.Equipment;
import enums.MuscleGroup;
import enums.SplitType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public final class ExerciseDatabase {
    private ExerciseDatabase() {
    }

    // CHEST
    public static final Exercise BARBELL_BENCH_PRESS = new Exercise("Barbell Bench Press",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.ARMS)),
            Equipment.BARBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 2);

    public static final Exercise INCLINE_DUMBBELL_PRESS = new Exercise("Incline Dumbbell Press",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.SHOULDERS)),
            Equipment.DUMBBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise PEC_DECK = new Exercise("Pec Deck",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    // BACK

    public static final Exercise UPPER_BACK_ROW = new Exercise("Upper Back Row",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BACK, MuscleGroup.ARMS)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PULL, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise LAT_PULLDOWN = new Exercise("Lat Pulldown",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BACK, MuscleGroup.ARMS)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PULL, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    // LEGS

    public static final Exercise DEADLIFT = new Exercise("Deadlift",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BACK, MuscleGroup.LEGS)),
            Equipment.BARBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.LOWER, SplitType.PULL, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 2);

    public static final Exercise CALF_RAISE = new Exercise("Calf Raise",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.LEGS)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.LOWER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise LEG_PRESS = new Exercise("Leg Press",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.LEGS)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.LOWER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise LEG_CURL = new Exercise("Leg Curl",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.LEGS)),
            Equipment.MACHINE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.LOWER, SplitType.PULL, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    // SHOULDERS

    public static final Exercise DUMBBELL_SHOULDER_PRESS = new Exercise("Dumbell Shoulder press",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.FRONT_DELTS)),
            Equipment.DUMBBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise LATERAL_RAISE = new Exercise("Dumbbell Lateral Raise",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.SIDE_DELTS)),
            Equipment.DUMBBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    // ARMS

    public static final Exercise DUMBBELL_CURL = new Exercise("Dumbell Curl",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.BICEPS)),
            Equipment.DUMBBELL,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PULL, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final Exercise TRICEP_PUSHDOWN = new Exercise("Cable Tricep Pushdown",
            new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.TRICEPS)),
            Equipment.CABLE,
            new ArrayList<SplitType>(Arrays.asList(SplitType.UPPER, SplitType.PUSH, SplitType.FULL_BODY)),
            0, 2, 6, 10, 1, 1);

    public static final ArrayList<Exercise> ALL = new ArrayList<>(List.of(
            BARBELL_BENCH_PRESS,
            INCLINE_DUMBBELL_PRESS,
            PEC_DECK,

            LAT_PULLDOWN,
            UPPER_BACK_ROW,

            DEADLIFT,
            LEG_PRESS,
            LEG_CURL,
            CALF_RAISE,

            DUMBBELL_SHOULDER_PRESS,
            LATERAL_RAISE,

            DUMBBELL_CURL,
            TRICEP_PUSHDOWN));
}

package model.generator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.Random;

import model.Exercise;
import model.GeneratorArguments;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.MuscleGroup;
import model.enums.SplitType;

/**
 * Generates a complete WorkoutPlan from a filtered exercise pool and a set of
 * generator arguments. Based on the user's requested training frequency,
 * SplitGenerator selects an appropriate split structure (Full Body,
 * Upper/Lower,
 * Push/Pull/Legs, or PPL+UL) and populates each training day by randomly
 * selecting exercises from the filtered pool, using priority ratings to bias
 * selection toward higher-quality movements while still introducing variety.
 * Muscle group coverage is tracked per day to avoid redundant exercise
 * selection.
 */
public class SplitGenerator {
    private ExerciseFilter filteredExercises;

    public SplitGenerator(ExerciseFilter filteredExercises) {
        this.filteredExercises = filteredExercises;
    }

    public ExerciseFilter getExerciseFilter() {
        return this.filteredExercises;
    }

    // EFFECTS: returns a generated WorkoutPlan according to generator arguments
    @SuppressWarnings("methodlength")
    public WorkoutPlan suggestSplit(GeneratorArguments args) {
        WorkoutPlan plan = new WorkoutPlan("");
        SplitType type = pickSplitType(args.getTrainingDays());

        if (type == SplitType.UPPER_LOWER) {
            WorkoutDay day1 = new WorkoutDay("Upper");
            WorkoutDay day2 = new WorkoutDay("Lower");

            populateDay(day1, "upper", this.filteredExercises.getExercises());
            plan.addDay(day1);
            populateDay(day2, "lower", this.filteredExercises.getExercises());
            plan.addDay(day2);
            plan.setName("Upper Lower 4x a week");
        } else if (type == SplitType.FULL_BODY) {
            WorkoutDay day1 = new WorkoutDay("Full Body");

            populateDay(day1, "full body", this.filteredExercises.getExercises());
            plan.addDay(day1);
            plan.setName("Full Body");
        } else if (type == SplitType.PPL_UL) {
            WorkoutDay day1 = new WorkoutDay("Push");
            WorkoutDay day2 = new WorkoutDay("Pull");
            WorkoutDay day3 = new WorkoutDay("Legs");
            WorkoutDay day4 = new WorkoutDay("Upper");
            WorkoutDay day5 = new WorkoutDay("Lower");

            populateDay(day1, "push", this.filteredExercises.getExercises());
            plan.addDay(day1);
            populateDay(day2, "pull", this.filteredExercises.getExercises());
            plan.addDay(day2);
            populateDay(day3, "legs", this.filteredExercises.getExercises());
            plan.addDay(day3);
            populateDay(day4, "upper", this.filteredExercises.getExercises());
            plan.addDay(day4);
            populateDay(day5, "lower", this.filteredExercises.getExercises());
            plan.addDay(day5);
            plan.setName("Push Pull Legs x Upper Lower");
        } else if (type == SplitType.PUSH_PULL_LEGS) {
            WorkoutDay day1 = new WorkoutDay("Push");
            WorkoutDay day2 = new WorkoutDay("Pull");
            WorkoutDay day3 = new WorkoutDay("Legs");

            populateDay(day1, "push", this.filteredExercises.getExercises());
            plan.addDay(day1);
            populateDay(day2, "pull", this.filteredExercises.getExercises());
            plan.addDay(day2);
            populateDay(day3, "legs", this.filteredExercises.getExercises());
            plan.addDay(day3);
            plan.setName("Push Pull Legs");
        }
        return plan;
    }

    // EFFECTS: picks a split type based on availability
    public SplitType pickSplitType(int numberOfDays) {
        if (numberOfDays <= 3) {
            return SplitType.FULL_BODY;
        } else if (numberOfDays == 4) {
            return SplitType.UPPER_LOWER;
        } else if (numberOfDays == 5) {
            return SplitType.PPL_UL;
        } else {
            return SplitType.PUSH_PULL_LEGS;
        }
    }

    // EFFECTS: returns arraylist of target muscles for given day
    public ArrayList<MuscleGroup> getTargetMusclesForDay(String dayName) {
        ArrayList<MuscleGroup> targets = new ArrayList<MuscleGroup>();

        if (dayName.equalsIgnoreCase("push")) {
            targets = new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.UPPER_CHEST,
                    MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS));

        } else if (dayName.equalsIgnoreCase("pull")) {
            targets = new ArrayList<MuscleGroup>(
                    Arrays.asList(MuscleGroup.LATS, MuscleGroup.TRAPS, MuscleGroup.REAR_DELTS, MuscleGroup.BICEPS,
                            MuscleGroup.FOREARMS, MuscleGroup.BRACHIORADIALIS));
        } else if (dayName.equalsIgnoreCase("legs") || dayName.equalsIgnoreCase("lower")) {
            targets = new ArrayList<MuscleGroup>(
                    Arrays.asList(MuscleGroup.QUADS, MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES, MuscleGroup.CALVES,
                            MuscleGroup.ABS));
        } else if (dayName.equalsIgnoreCase("upper")) {
            targets = new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.UPPER_CHEST,
                    MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS,
                    MuscleGroup.LATS, MuscleGroup.TRAPS, MuscleGroup.REAR_DELTS, MuscleGroup.BICEPS,
                    MuscleGroup.FOREARMS, MuscleGroup.BRACHIORADIALIS, MuscleGroup.ABS));
        } else if (dayName.equalsIgnoreCase("full_body") || dayName.equalsIgnoreCase("full body")) {
            targets = new ArrayList<MuscleGroup>(Arrays.asList(MuscleGroup.CHEST, MuscleGroup.UPPER_CHEST,
                    MuscleGroup.FRONT_DELTS, MuscleGroup.SIDE_DELTS, MuscleGroup.TRICEPS,
                    MuscleGroup.LATS, MuscleGroup.TRAPS, MuscleGroup.REAR_DELTS, MuscleGroup.BICEPS,
                    MuscleGroup.QUADS, MuscleGroup.HAMSTRINGS, MuscleGroup.GLUTES, MuscleGroup.CALVES,
                    MuscleGroup.FOREARMS, MuscleGroup.BRACHIORADIALIS, MuscleGroup.ABS));
        }
        return targets;
    }

    // EFFECTS: return random exercise for given muscle based on priority and gym
    // availability
    public Exercise pickRandomExerciseForMuscle(MuscleGroup targetMuscle, ArrayList<Exercise> available,
            WorkoutDay currentDay) {
        ArrayList<Exercise> validExercises = new ArrayList<>();

        // add exercises that target the given muscle to an arraylist
        for (Exercise i : available) {
            if (i.getTargetMuscles().contains(targetMuscle) && !currentDay.getExercises().contains(i)) {
                validExercises.add(i);
            }
        }

        int bestPriority = 3;
        for (Exercise i : validExercises) {
            if (i.getPriority() < bestPriority) {
                bestPriority = i.getPriority();
            }
        }

        // Add exercises of desired priority to a new list
        ArrayList<Exercise> finalPool = new ArrayList<>();
        for (Exercise i : validExercises) {
            if (i.getPriority() <= bestPriority + 1) {
                finalPool.add(i);
            }
        }

        Random random = new Random();
        int randomIndex = random.nextInt(finalPool.size());
        // pick a random exercise from this list
        return finalPool.get(randomIndex);
    }

    // EFFECTS: adds all necessary exercises to a given day
    public void populateDay(WorkoutDay day, String dayType, ArrayList<Exercise> gymPool) {
        ArrayList<MuscleGroup> dayTargets = getTargetMusclesForDay(dayType);
        Set<MuscleGroup> coveredMuscles = new HashSet<>();

        // for every necessary muscle, select one exercise if not already covered
        for (MuscleGroup i : dayTargets) {
            if (coveredMuscles.contains(i)) {
                continue;
            }

            Exercise selected = pickRandomExerciseForMuscle(i, gymPool, day);

            if (selected != null) {
                day.addExercise(selected);
                coveredMuscles.addAll(selected.getTargetMuscles());
            }
        }
    }
}

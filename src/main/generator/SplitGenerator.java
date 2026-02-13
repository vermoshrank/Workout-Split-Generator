package generator;

import java.time.DayOfWeek;
import java.util.Set;

import model.GeneratorArguments;
import model.WorkoutPlan;

public class SplitGenerator {
    private ExerciseFilter filteredExercises;

    public SplitGenerator(ExerciseFilter filteredExercises) {
        this.filteredExercises = filteredExercises;
    }

    // EFFECTS: returns a generated WorkoutPlan according to generator arguments
    public WorkoutPlan suggestSplit(GeneratorArguments args) {
        return null;
    }

    // EFFECTS: picks a split type based on availability
    public String pickFocusForDay(DayOfWeek day, Set<DayOfWeek> chosenDays) {
        return null;
    }
}

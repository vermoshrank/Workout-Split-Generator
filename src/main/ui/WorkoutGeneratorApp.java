package ui;

import java.util.ArrayList;
import java.util.Scanner;

import enums.GymType;
import generator.ExerciseFilter;
import generator.SplitGenerator;
import model.Exercise;
import model.ExerciseDatabase;
import model.GeneratorArguments;
import model.WorkoutDay;
import model.WorkoutPlan;

public class WorkoutGeneratorApp {
    private ExerciseFilter filter;
    private SplitGenerator generator;
    private WorkoutPlan currentPlan;
    private Scanner input;

    // based off of tellerapp
    public WorkoutGeneratorApp() {
        runGenerator();
    }

    // based off of tellerapp
    private void runGenerator() {
        boolean keepGoing = true;
        String command = null;

        init();

        System.out.println("WORKOUT SPLIT GENERATOR/EDITOR");

        while (keepGoing) {
            displayMenu();
            command = input.next();
            command = command.toLowerCase();

            if (command.equals("q")) {
                keepGoing = false;
            } else {
                processCommand(command);
            }
        }
        System.out.println("Quit Successful");
    }
    
    // based off of tellerapp
    // MODIFIES: this
    // EFFECTS: processes user command
    private void processCommand(String command) {
        if (command.equals("g")) {
            doGenerateSplit();
        } else if (command.equals("v")) {
            doViewPlan();
        } else if (command.equals("e")) {
            doViewExercises();
        } else if (command.equals("a")) {
            doAddExerciseToDay();
        } else if (command.equals("r")) {
            doRemoveExerciseFromDay();
        } else {
            System.out.println("Selection not valid...");
        }
    }

    // based off of tellerapp
    // EFFECTS: initializes filter
    private void init() {
        filter = new ExerciseFilter();

        currentPlan = null;
        input = new Scanner(System.in);

    }

    // based off of tellerapp
    // EFFECTS: displays menu of options to user
    private void displayMenu() {
        System.out.println("\n--- Main Menu ---");
        System.out.println("g -> generate workout split");
        System.out.println("v -> view current plan");
        System.out.println("e -> view all exercises");
        System.out.println("a -> add exercise to day");
        System.out.println("r -> remove exercise from day");
        System.out.println("q -> quit");
        System.out.print("Enter choice: ");
    }

    // MODIFIES: this
    // EFFECTS: generates a new workout split based on user input
    private void doGenerateSplit() {
        System.out.println("\n--- Generate Workout Split ---");

        System.out.print("How many days per week do you train? (1-7): ");
        int trainingDays = input.nextInt();

        if (trainingDays < 1 || trainingDays > 7) {
            System.out.println("Invalid number of days. Using 4 days...");
            trainingDays = 4;
        }

        System.out.println("\nSelect your gym type:");
        System.out.println("\t1 -> Everything (All Equipment Available)");
        System.out.println("\t2 -> Commercial gym (Dumbells, Barbells, Most Machines)");
        System.out.println("\t3 -> Local gym (Dumbells, Barbells, Small Selection of Machines)");
        System.out.println("\t4 -> Home gym (Dumbells and Barbells Only)");
        System.out.print("Enter choice (1-4): ");
        int gymChoice = input.nextInt();

        GymType gymType = selectGymType(gymChoice);

        filter.getAllAvailableExercises(gymType.getAvailableEquipment());

        GeneratorArguments args = new GeneratorArguments(trainingDays, gymType);
        generator = new SplitGenerator(filter);
        currentPlan = generator.suggestSplit(args);

        System.out.println("\nWorkout split generated successfully!");
        System.out.println("Split name: " + currentPlan.getName());
    }

    // EFFECTS: returns GymType based on user choice
    private GymType selectGymType(int choice) {
        if (choice == 1) {
            return GymType.EVERYTHING;
        } else if (choice == 2) {
            return GymType.COMMERCIAL;
        } else if (choice == 3) {
            return GymType.LOCAL;
        } else if (choice == 4) {
            return GymType.HOME;
        } else {
            System.out.println("Invalid choice: Using EVERYTHING");
            return GymType.EVERYTHING;
        }
    }

    // EFFECTS: displays the current workout plan
    private void doViewPlan() {

        System.out.println("\n---" + currentPlan.getName() + " ---");

        // Display day
        for (WorkoutDay day : currentPlan.getWorkoutDays()) {
            System.out.println("\n--- " + day.getName() + " ---");

            if (day.getTotalExercises() == 0) {
                System.out.println("No exercises");
            } else {
                int exerciseNum = 1;
                // Display exercises
                for (Exercise exercise : day.getExercises()) {
                    System.out.printf("\n", exerciseNum, exercise.getName());
                    System.out.printf("sets: ", exercise.getSets(), "%n",
                            "reps: ", exercise.getMinReps(), "- ", exercise.getMaxReps(), "%n",
                            "rir: ", exercise.getRir(), "%n");
                    System.out.printf("Equipment:", exercise.getEquipmentType());
                    exerciseNum++;
                }
            }
        }

        System.out.println("\nTotal exercises: " + currentPlan.getTotalExercises(currentPlan));
    }

    // EFFECTS: displays all available exercises
    private void doViewExercises() {
        System.out.println("\n--- All Available Exercises ---");

        int count = 1;
        for (Exercise exercise : filter.getExercises()) {
            System.out.printf("\n",
                    count,
                    exercise.getName(),
                    exercise.getEquipmentType());
            count++;
        }

        System.out.println("\nTotal: " + filter.getExercises().size() + " exercises");
    }

    // MODIFIES: this
    // EFFECTS: adds an exercise to a specific workout day
    private void doAddExerciseToDay() {
        System.out.println("\n--- Add Exercise to Day ---");

        // Display days
        System.out.println("Select day:");
        for (int i = 0; i < currentPlan.getWorkoutDays().size(); i++) {
            System.out.printf("\n",
                    i + 1,
                    currentPlan.getWorkoutDays().get(i).getName());
        }
        System.out.print("Enter choice: ");
        int dayChoice = input.nextInt();

        WorkoutDay selectedDay = currentPlan.getWorkoutDays().get(dayChoice - 1);

        // Display available exercises
        System.out.println("\nAvailable exercises:");
        for (int i = 0; i < filter.getExercises().size(); i++) {
            System.out.printf("\n",
                    i + 1,
                    filter.getExercises().get(i).getName());
        }
        System.out.println("Enter exercise number: ");
        int exerciseChoice = input.nextInt();

        Exercise selectedExercise = filter.getExercises().get(exerciseChoice - 1);
        currentPlan.addExerciseToDay(selectedDay.getName(), selectedExercise);

        System.out.println("Added " + selectedExercise.getName() + " to " + selectedDay.getName());
    }

    // MODIFIES: this
    // EFFECTS: removes an exercise from a specific workout day
    private void doRemoveExerciseFromDay() {
        System.out.println("\n--- Remove Exercise from Day ---");

        // Display days
        System.out.println("Select day:");
        for (int i = 0; i < currentPlan.getWorkoutDays().size(); i++) {
            System.out.printf("\n",
                    i + 1,
                    currentPlan.getWorkoutDays().get(i).getName());
        }
        System.out.println("Enter choice: ");
        int dayChoice = input.nextInt();

        WorkoutDay selectedDay = currentPlan.getWorkoutDays().get(dayChoice - 1);

        // Display available exercises
        System.out.println("\nExercises in " + selectedDay.getName() + ":");
        for (int i = 0; i < selectedDay.getExercises().size(); i++) {
            System.out.printf("\n",
                    i + 1,
                    selectedDay.getExercises().get(i).getName());
        }
        System.out.println("Enter exercise number to remove: ");
        int exerciseChoice = input.nextInt();

        String exerciseName = selectedDay.getExercises().get(exerciseChoice - 1).getName();
        currentPlan.removeExerciseFromDay(selectedDay.getName(), exerciseName);
        System.out.println("Removed " + exerciseName + " from " + selectedDay.getName());
    }
}

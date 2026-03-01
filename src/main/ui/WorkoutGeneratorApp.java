package ui;

import java.util.ArrayList;
import java.util.Scanner;

import model.Exercise;
import model.ExerciseDatabase;
import model.GeneratorArguments;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.GymType;
import model.generator.ExerciseFilter;
import model.generator.SplitGenerator;

/**
 * Console-based user interface for the Workout Split Generator application.
 * WorkoutGeneratorApp runs the main interaction loop, presenting a menu that
 * lets the user generate a personalised workout split, view the current plan,
 * browse available exercises, add or remove exercises from specific training
 * days and create fully custom exercises.
 * All user input is read from standard input via a Scanner,
 * and output is written to output.
 */
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
        } else if (command.equals("c")) {
            doCreateCustomExercise();
        } else {
            System.out.println("Selection Does Not Exist.");
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
        System.out.println("c -> create custom exercise");
        System.out.println("q -> quit");
        System.out.print("Enter choice: ");
    }

    // MODIFIES: this
    // EFFECTS: generates a new workout split based on user input
    @SuppressWarnings("methodlength")
    private void doGenerateSplit() {
        System.out.println("\n--- Generate Workout Split ---");

        System.out.print("How many days per week do you train? (1-7): ");
        int trainingDays = input.nextInt();

        if (trainingDays < 1 || trainingDays > 7) {
            System.out.println("Invalid number of days: Using 4 days.");
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
            System.out.println("Invalid choice: Using EVERYTHING.");
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
                    System.out.println("  " + exerciseNum + ". " + exercise.getName());
                    System.out.println("Sets: " + exercise.getSets() + " Reps: "
                            + exercise.getMinReps() + "-" + exercise.getMaxReps()
                            + " RIR: " + exercise.getRir());
                    System.out.println("     Equipment: " + exercise.getEquipmentType());
                    exerciseNum++;
                }
                System.out.println("\nEstimated Workout Duration: "
                        + day.calculateSessionLength()
                        + " mins");
                System.out.println("Estimated Calorie Expenditure: "
                        + day.calculateCaloriesBurnt());
            }
        }
        System.out.println("\nTotal exercises: " + currentPlan.getTotalExercises(currentPlan));
    }

    // EFFECTS: displays all available exercises
    private void doViewExercises() {
        System.out.println("\n--- All Available Exercises ---");

        int count = 1;
        for (Exercise exercise : filter.getExercises()) {
            System.out.println(count + ". " + exercise.getName() + " - " + exercise.getEquipmentType());
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
            System.out.println("\n" + (i + 1) + " for " + currentPlan.getWorkoutDays().get(i).getName());
        }
        System.out.print("Enter choice: ");
        int dayChoice = input.nextInt();

        WorkoutDay selectedDay = currentPlan.getWorkoutDays().get(dayChoice - 1);

        // Display available exercises
        System.out.println("\nAvailable exercises:");
        for (int i = 0; i < filter.getExercises().size(); i++) {
            System.out.println("\n" + (i + 1) + " for " + filter.getExercises().get(i).getName());
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
            System.out.println("\n" + (i + 1) + " for " + currentPlan.getWorkoutDays().get(i).getName());
        }
        System.out.println("Enter choice: ");
        int dayChoice = input.nextInt();

        WorkoutDay selectedDay = currentPlan.getWorkoutDays().get(dayChoice - 1);

        // Display available exercises
        System.out.println("\nExercises in " + selectedDay.getName() + ":");
        for (int i = 0; i < selectedDay.getExercises().size(); i++) {
            System.out.println("\n" + (i + 1) + " for " + selectedDay.getExercises().get(i).getName());
        }
        System.out.println("Enter exercise number to remove: ");
        int exerciseChoice = input.nextInt();

        String exerciseName = selectedDay.getExercises().get(exerciseChoice - 1).getName();
        currentPlan.removeExerciseFromDay(selectedDay.getName(), exerciseName);
        System.out.println("Removed " + exerciseName + " from " + selectedDay.getName());
    }

    // MODIFIES: this
    // EFFECTS: prompts user to create a custom exercise and adds it to the filter
    @SuppressWarnings("methodlength")
    private void doCreateCustomExercise() {
        System.out.println("\n--- Create Custom Exercise ---");

        input.nextLine();
        System.out.print("Enter exercise name: ");
        String name = input.nextLine();

        ArrayList<model.enums.MuscleGroup> targetMuscles = new ArrayList<>();

        System.out.println("\nSelect primary muscle group:");

        for (int i = 0; i < model.enums.MuscleGroup.values().length; i++) {
            System.out.println((i + 1) + ". " + model.enums.MuscleGroup.values()[i]);
        }

        System.out.println("Enter choice: ");
        int muscles = input.nextInt();
        targetMuscles.add(model.enums.MuscleGroup.values()[muscles - 1]);

        System.out.println("\nSelect equipment type:");

        for (int i = 0; i < model.enums.Equipment.values().length; i++) {
            System.out.println((i + 1) + ". " + model.enums.Equipment.values()[i]);
        }

        System.out.println("Enter choice: ");
        int equip = input.nextInt();
        model.enums.Equipment equipment = model.enums.Equipment.values()[equip - 1];

        System.out.println("Enter weight: ");
        int weight = input.nextInt();

        System.out.print("Enter target sets: ");
        int sets = input.nextInt();

        System.out.print("Enter minimum reps: ");
        int minReps = input.nextInt();

        System.out.print("Enter maximum reps: ");
        int maxReps = input.nextInt();

        System.out.print("Enter RIR (Reps in Reserve): ");
        int rir = input.nextInt();

        System.out.print("Enter priority (1 = High, 2 = Medium, 3 = Low): ");
        int priority = input.nextInt();

        Exercise custom = new Exercise(
                name, targetMuscles, equipment,
                weight, sets, minReps, maxReps, rir, priority);

        filter.addExercise(custom);
        System.out.println("Added " + name + " to available exercises.");
    }
}

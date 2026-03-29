package ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import model.WorkoutPlan;
import model.enums.GymType;
import persistence.JsonReader;
import ui.screens.ExercisesLibraryScreen;
import ui.screens.FrequencySelectionScreen;
import ui.screens.GymTypeScreen;
import ui.screens.MainPage;
import ui.screens.ViewSplitScreen;
import model.WorkoutDay;
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

/**
 * represents the main "hub" of the GUI.
 * It stores all pages in a card layout,
 * and other necessary field, and houses
 * the methods for navigation and starting the GUI
 */
@ExcludeFromJacocoGeneratedReport
public class WorkoutSplitGUI extends JFrame {
    public static final String MAIN_PAGE = "MAIN";
    public static final String GYM_TYPE = "GYM_TYPE";
    public static final String FREQUENCY = "FREQUENCY";
    public static final String SPLIT_VIEW = "SPLIT_VIEW";
    public static final String EXERCISE_LIB = "EXERCISE_LIB";

    private JPanel cards;
    private CardLayout cardLayout;
    private ArrayList<WorkoutPlan> savedPlans = new ArrayList<>();
    private WorkoutPlan activePlan;

    private MainPage mainPage;
    private ViewSplitScreen viewSplitScreen;
    private ExercisesLibraryScreen exercisesLibraryScreen;
    private GymType gymType;
    private int selectedDays;
    private WorkoutDay selectedDay;

    public WorkoutSplitGUI() {
        savedPlans = new ArrayList<>();

        int choice = JOptionPane.showConfirmDialog(null, "Would you like to load your saved workout splits?",
                "Load Saved Splits", JOptionPane.YES_NO_OPTION);

        if (choice == JOptionPane.YES_NO_OPTION) {
            loadSavedPlans();
        }

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        mainPage = new MainPage(this);
        viewSplitScreen = new ViewSplitScreen(this);
        exercisesLibraryScreen = new ExercisesLibraryScreen(this);
        cards.add(mainPage, MAIN_PAGE);
        cards.add(new GymTypeScreen(this), GYM_TYPE);
        cards.add(new FrequencySelectionScreen(this), FREQUENCY);
        cards.add(viewSplitScreen, SPLIT_VIEW);
        cards.add(exercisesLibraryScreen, EXERCISE_LIB);

        add(cards);

        setTitle("WORKOUT SPLIT EDITOR");
        setSize(1100, 750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    // MODIFIES: this
    // EFFECTS: retrieves saved workout splits and adds them to savedPlans
    private void loadSavedPlans() {
        File dataFolder = new File("./data/");
        dataFolder.mkdirs();

        File[] files = dataFolder.listFiles((dir, name) -> name.endsWith(".json"));
        if (files == null) {
            return;
        }

        for (File file : files) {
            JsonReader reader = new JsonReader(file.getPath());
            try {
                savedPlans.add(reader.read());
            } catch (IOException e) {
                System.out.println("Could not load: " + file.getName());
            }
        }
    }

    // MODIFIES: this
    // EFFECTS: handles navigation to other pages/panels
    public void navigate(String pageName) {
        if (pageName.equals(MAIN_PAGE)) {
            mainPage.refresh();
        }

        if (pageName.equals(SPLIT_VIEW)) {
            viewSplitScreen.refresh();
        }

        if (pageName.equals(EXERCISE_LIB)) {
            exercisesLibraryScreen.refresh();
        }

        cardLayout.show(cards, pageName);
    }

    public ArrayList<WorkoutPlan> getSavedPlans() {
        return savedPlans;
    }

    public WorkoutPlan getActivePlan() {
        return activePlan;
    }

    public void setActivePlan(WorkoutPlan plan) {
        this.activePlan = plan;
    }

    public int getSelectedDays() {
        return selectedDays;
    }

    public void setSelectedDays(int days) {
        selectedDays = days;
    }

    public GymType getSelectedGymType() {
        return gymType;
    }

    public void setSelectedGymType(GymType g) {
        gymType = g;
    }

    public WorkoutDay getSelectedDay() {
        return selectedDay;
    }

    public void setSelectedDay(WorkoutDay day) {
        this.selectedDay = day;
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WorkoutSplitGUI::new);
    }
}

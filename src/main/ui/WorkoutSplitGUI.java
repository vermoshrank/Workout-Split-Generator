package ui;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.*;

import model.WorkoutPlan;
import model.enums.GymType;
import persistence.JsonReader;
import ui.screens.MainPage;
import model.GeneratorArguments;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

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

    public WorkoutSplitGUI() {
        savedPlans = new ArrayList<>();
        loadSavedPlans();

        cardLayout = new CardLayout();
        cards = new JPanel(cardLayout);

        cards.add(new MainPage(this), MAIN_PAGE);

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

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WorkoutSplitGUI::new);
    }
}

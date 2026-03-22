package ui.screens;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;
import model.WorkoutDay;
import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;

@ExcludeFromJacocoGeneratedReport
public class ViewSplitScreen extends BaseScreen{
    private JPanel exerciseList;
    private JPanel stats;
    public ViewSplitScreen(WorkoutSplitGUI app) {
        super(app);
    }

    @Override
    protected JPanel buildContent() {
    }

    // MODIFIES: this
    // EFFECTS: adds all days and their exercises to the main panel
    private void populateExerciseList() {
    }

    // EFFECTS: draws and returns one day section with heading and list of exercise rows
    private JPanel buildDaySection(WorkoutDay day) {
    }

    // EFFECTS: draws and returns one exercise row with name, muscles, stats, delete label
    private JPanel buildExerciseRow(Exercise ex, WorkoutDay day) {
    }

    // EFFECTS: returns muscle group names as a string
    private String buildMuscleString(Exercise ex) {
    }

    // MODIFIES: this
    // EFFECTS: adds plain-text stat labels for every day in the plan
    private void populateStatsPanel() {
    }

    // MODIFIES: this
    // EFFECTS: clears and rebuilds both panels in case of alteration
    public void refresh() {
    }
}

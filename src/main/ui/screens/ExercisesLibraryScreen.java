package ui.screens;

import javax.swing.JButton;
import javax.swing.JPanel;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.Exercise;
import ui.WorkoutSplitGUI;

/**
 * Displays all exercises from ExerciseDatabase as a scrollable list.
 * Each exercise has an Add button that appends the exercise to the currently selected
 * WorkoutDay before navigating back to the split view.
 */
@ExcludeFromJacocoGeneratedReport
public class ExercisesLibraryScreen {
    private JPanel listPanel;

    public ExercisesLibraryScreen(WorkoutSplitGUI app) {
        super(app);
    }

    @Override
    protected JPanel buildContent() {
    }

    // EFFECTS: draws page title and subtitle
    private JPanel buildPageHeader() {
    }

    // EFFECTS: draws back button row
    private JPanel buildBack() {
    }

    // MODIFIES: this
    // EFFECTS: fills listPanel with one card per exercise in ExerciseDatabase
    private void populateList() {
    }

    // EFFECTS: draws one exercise card with name, muscle tags, and add button
    private JPanel buildExerciseCard(Exercise e) {
    }

    // EFFECTS: builds an add button that adds exercise to selected day
    private JButton buildAddButton(Exercise e) {
    }

    // MODIFIES: this
    // EFFECTS: refreshes the list
    public void refresh() {
    }
}

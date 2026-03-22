package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.Theme;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

/**
 * Second step of the split-generation. 
 * Lets the user pick their weekly training frequency.
 */
@ExcludeFromJacocoGeneratedReport
public class FrequencySelectionScreen extends BaseScreen {
    private int selectedDays;

    public FrequencySelectionScreen(WorkoutSplitGUI app) {
        super(app);
    }

    // EFFECTS: combines all drawn panels to form the content of page
    @Override
    protected JPanel buildContent() {

    }

    private JPanel buildTopSection() {
        
    }

    private JPanel buildGrid() {
    }

    // EFFECTS: builds and returns a single day tile for the given number of days
    private JPanel buildDayCard(int days) {
    }

    // EFFECTS: generates a workout plan for the selected frequency and gym type,
    //          writes it to ./data/ folder, adds it to the app's saved plans,
    //          then navigates to MainPage
    private void generateAndSave(int days) {
    }
}

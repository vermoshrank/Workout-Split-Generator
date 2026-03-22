package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedButton;
import ui.gui.RoundedPanel;
import ui.gui.Theme;
import model.enums.GymType;
import model.GeneratorArguments;

import java.awt.*;
import javax.swing.*;

/**
 * First step of the split-generation process. Lets the user choose their
 * gym type (Everything, Commercial, Local, or Home), then navigates to the
 * frequency-selection step.
 */
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class GymTypeScreen extends BaseScreen {
    private GymType selectedType = null;

    public GymTypeScreen(WorkoutSplitGUI app) {
        super(app);
    }

    // EFFECTS: combines all drawn panels to form the content of page
    @Override
    protected JPanel buildContent() {
    }

    // EFFECTS: draws and returns JLabel for headline
    private JLabel buildStepQuestion() {

    }

    // EFFECTS: draws and returns JPanel with gym type choices
    private JPanel buildGymGrid() {

    }

    // EFFECTS: draws and returns a single JPanel for a single gym type selection
    private JPanel buildCard() {

    }

    // EFFECTS: draws and returns an image icon for gym type
    private JPanel buildIcon() {

    }

    // EFFECTS: loads and returns image from fale based on name
    private ImageIcon loadIcon(String fileName) {

    }

    // EFFECTS: draws the bottom section with the next button
    private JPanel buildFooter() {

    }

    
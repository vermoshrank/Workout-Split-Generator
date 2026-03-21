package ui.gui;

import static org.junit.jupiter.api.Assertions.fail;

import java.awt.*;
import javax.swing.*;

import ui.WorkoutSplitGUI;

/*
represents the base screen that will be shared
across all panels
 */
public abstract class BaseScreen extends JPanel {
    protected WorkoutSplitGUI app;

    public BaseScreen(WorkoutSplitGUI app) {
        this.app = app;

    }

    // methods for building respective elements in a panel
    // EFFECTS: builds and returns universal header for panels
    private JPanel buildHeader() {

    }

    protected abstract JPanel buildContent();
}

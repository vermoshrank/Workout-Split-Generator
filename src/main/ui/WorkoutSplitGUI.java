package ui;

import java.awt.*;

import javax.swing.*;

public class WorkoutSplitGUI extends JFrame {
    public static final String MAIN_PAGE = "MAIN";
    public static final String GYM_TYPE = "GYM_TYPE";
    public static final String FREQUENCY = "FREQUENCY";
    public static final String SPLIT_VIEW = "SPLIT_VIEW";
    public static final String EXERCISE_LIB = "EXERCISE_LIB";

    private JPanel cards;
    private CardLayout cardLayout;

    public WorkoutSplitGUI() {

    }

    // MODIFIES: this
    // EFFECTS: handles navigation to other pages/panels
    public void navigate(String pageName) {
        cardLayout.show(cards, pageName);
    }

}

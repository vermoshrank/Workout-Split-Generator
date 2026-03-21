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
    // EFFECTS: handles navigation to other pages/panels
    public void navigate(String pageName) {
        cardLayout.show(cards, pageName);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(WorkoutSplitGUI::new);
    }
}

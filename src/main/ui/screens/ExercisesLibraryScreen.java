package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedButton;
import ui.gui.RoundedPanel;
import ui.gui.Theme;
import model.Exercise;
import model.ExerciseDatabase;
import model.WorkoutDay;
import model.enums.MuscleGroup;

import java.awt.*;
import java.util.List;
import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

/**
 * Displays all exercises from ExerciseDatabase as a scrollable list.
 * Each exercise has an Add button that appends the exercise to the currently
 * selected
 * WorkoutDay before navigating back to the split view.
 */
@ExcludeFromJacocoGeneratedReport
public class ExercisesLibraryScreen extends BaseScreen {
    private JPanel listPanel;

    public ExercisesLibraryScreen(WorkoutSplitGUI app) {
        super(app);
    }

    @Override
    protected JPanel buildContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Theme.PAGE_BG);
        content.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        content.add(buildPageHeader());
        content.add(Box.createVerticalStrut(32));
        content.add(buildBack());
        content.add(Box.createVerticalStrut(20));

        listPanel = new JPanel();
        listPanel.setLayout(new BoxLayout(listPanel, BoxLayout.Y_AXIS));
        listPanel.setBackground(Theme.PAGE_BG);
        listPanel.setAlignmentX(Component.LEFT_ALIGNMENT);
        populateList();

        content.add(listPanel);
        return content;
    }

    // EFFECTS: draws page title and subtitle
    private JPanel buildPageHeader() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Theme.PAGE_BG);
        panel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel title = new JLabel("Exercise Library");
        title.setFont(Theme.HEADLINE_LARGE);
        title.setForeground(Theme.TEXT_PRIMARY);
        title.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel sub = new JLabel("Select an exercise to add to your day.");
        sub.setFont(Theme.BODY);
        sub.setForeground(Theme.TEXT_THREE);
        sub.setAlignmentX(Component.LEFT_ALIGNMENT);
        sub.setBorder(BorderFactory.createEmptyBorder(6, 0, 0, 0));

        panel.add(title);
        panel.add(sub);
        return panel;
    }

    // EFFECTS: draws back button row
    private JPanel buildBack() {
        JPanel row = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        row.setBackground(Theme.PAGE_BG);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);

        RoundedButton back = new RoundedButton("Back");
        back.addActionListener(e -> app.navigate(WorkoutSplitGUI.SPLIT_VIEW));
        row.add(back);

        RoundedButton custom = new RoundedButton("+ Create Custom Exercise");
        custom.addActionListener(e -> app.navigate(WorkoutSplitGUI.SPLIT_VIEW));
        row.add(custom);
        return row;
    }

    // MODIFIES: this
    // EFFECTS: fills listPanel with one card per exercise in ExerciseDatabase
    private void populateList() {
        listPanel.removeAll();
        for (Exercise e : ExerciseDatabase.getAll()) {
            listPanel.add(buildExerciseCard(e));
            listPanel.add(Box.createVerticalStrut(12));
        }
        listPanel.revalidate();
        listPanel.repaint();
    }

    // EFFECTS: draws one exercise card with name, muscle tags, and add button
    private JPanel buildExerciseCard(Exercise e) {
        RoundedPanel card = new RoundedPanel(12);
        card.setBackground(Theme.CARD_WHITE);
        card.setLayout(new BorderLayout(16, 0));
        card.setBorder(BorderFactory.createEmptyBorder(18, 22, 18, 22));
        card.setAlignmentX(Component.LEFT_ALIGNMENT);
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, 88));

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(e.getName());
        nameLabel.setFont(Theme.BODY_LARGE);
        nameLabel.setForeground(Theme.TEXT_PRIMARY);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        left.add(nameLabel);

        card.add(left, BorderLayout.CENTER);
        card.add(buildAddButton(e), BorderLayout.EAST);

        return card;
    }

    // EFFECTS: builds an add button that adds exercise to selected day
    private JButton buildAddButton(Exercise e) {
        RoundedButton btn = new RoundedButton("+");

        btn.addActionListener(ev -> {
            WorkoutDay day = app.getSelectedDay();
            if (day != null) {
                day.addExercise(e);
            }
            app.navigate(WorkoutSplitGUI.SPLIT_VIEW);
        });

        return btn;
    }

    // MODIFIES: this
    // EFFECTS: refreshes the list
    public void refresh() {
        if (listPanel != null) {
            populateList();
        }
    }
}

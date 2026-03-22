package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedPanel;
import ui.gui.Theme;

import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.FileNotFoundException;

import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import model.GeneratorArguments;
import model.WorkoutPlan;
import model.enums.GymType;
import model.generator.ExerciseFilter;
import model.generator.SplitGenerator;
import persistence.JsonWriter;

/**
 * Second step of the split-generation.
 * Lets the user pick their weekly training frequency.
 */
@ExcludeFromJacocoGeneratedReport
public class FrequencySelectionScreen extends BaseScreen {

    public FrequencySelectionScreen(WorkoutSplitGUI app) {
        super(app);
    }

    // EFFECTS: combines all drawn panels to form the content of page
    @Override
    protected JPanel buildContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Theme.PAGE_BG);
        content.setBorder(BorderFactory.createEmptyBorder(48, 48, 48, 48));

        content.add(buildTopSection());
        content.add(Box.createVerticalStrut(48));
        content.add(buildGrid());

        return content;
    }

    private JPanel buildTopSection() {
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.setBackground(Theme.PAGE_BG);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel stepLabel = new JLabel("STEP 2 OF 2");
        stepLabel.setFont(Theme.LABEL);
        stepLabel.setForeground(Theme.TEAL);
        stepLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        stepLabel.setBorder(BorderFactory.createEmptyBorder(0, 0, 12, 0));

        JLabel headline = new JLabel("Training Frequency");
        headline.setFont(Theme.HEADLINE);
        headline.setForeground(Theme.TEXT_PRIMARY);
        headline.setAlignmentX(Component.CENTER_ALIGNMENT);

        JLabel sub = new JLabel("How many days per week would you like to train?");
        sub.setFont(Theme.BODY_LARGE);
        sub.setForeground(Theme.TEXT_TWO);
        sub.setAlignmentX(Component.CENTER_ALIGNMENT);
        sub.setBorder(BorderFactory.createEmptyBorder(8, 0, 0, 0));

        panel.add(stepLabel);
        panel.add(headline);
        panel.add(sub);
        return panel;
    }

    private JPanel buildGrid() {
        JPanel panel = new JPanel(new GridBagLayout());
        panel.setBackground(Theme.PAGE_BG);
        panel.setAlignmentX(Component.CENTER_ALIGNMENT);

        JPanel grid = new JPanel(new GridLayout(1, 7, 14, 0));
        grid.setBackground(Theme.PAGE_BG);

        for (int i = 1; i <= 7; i++) {
            grid.add(buildDayCard(i));
        }

        panel.add(grid);
        return panel;
    }

    // EFFECTS: builds and returns a single day tile for the given number of days
    private JPanel buildDayCard(int days) {
        RoundedPanel card = new RoundedPanel(18);
        card.setBackground(Color.WHITE);
        card.setLayout(new GridBagLayout());
        card.setPreferredSize(new Dimension(88, 88));
        card.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        JPanel stack = new JPanel();
        stack.setOpaque(false);
        stack.setLayout(new BoxLayout(stack, BoxLayout.Y_AXIS));

        JLabel numLabel = new JLabel(String.valueOf(days));
        numLabel.setFont(new Font("Dialog", Font.BOLD, 28));
        numLabel.setForeground(Theme.TEXT_TWO);
        numLabel.setAlignmentX(Component.CENTER_ALIGNMENT);

        stack.add(numLabel);
        stack.add(Box.createVerticalStrut(2));

        card.add(stack);

        card.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                generateAndSave(days);
            }
        });

        return card;
    }

    // EFFECTS: generates a workout plan for the selected frequency and gym type,
    // writes it to ./data/ folder, adds it to the app's saved plans,
    // then navigates to MainPage
    private void generateAndSave(int days) {
        GymType gymType = app.getSelectedGymType();

        ExerciseFilter filter = new ExerciseFilter();
        filter.getAllAvailableExercises(gymType.getAvailableEquipment());

        GeneratorArguments args = new GeneratorArguments(days, gymType);
        SplitGenerator generator = new SplitGenerator(filter);
        WorkoutPlan plan = generator.suggestSplit(args);

        String path = "./data/new_plan.json";

        try {
            JsonWriter writer = new JsonWriter(path);
            writer.open();
            writer.write(plan);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not save plan");
        }

        app.getSavedPlans().add(plan);
        app.navigate(WorkoutSplitGUI.MAIN_PAGE);
    }
}

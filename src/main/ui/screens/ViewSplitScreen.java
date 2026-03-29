package ui.screens;

import java.awt.*;
import java.io.FileNotFoundException;
import java.util.List;
import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;
import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedButton;
import ui.gui.Theme;
import model.Exercise;
import model.WorkoutDay;
import model.WorkoutPlan;
import model.enums.MuscleGroup;
import persistence.JsonWriter;

// represents the page that displays a workout plan and provides editting options
@ExcludeFromJacocoGeneratedReport
public class ViewSplitScreen extends BaseScreen {
    private JPanel exerciseList;
    private JPanel stats;

    public ViewSplitScreen(WorkoutSplitGUI app) {
        super(app);
    }

    @Override
    protected JPanel buildContent() {
        JPanel content = new JPanel(new BorderLayout(32, 0));
        content.setBackground(Theme.PAGE_BG);
        content.setBorder(BorderFactory.createEmptyBorder(32, 40, 32, 40));

        exerciseList = new JPanel();
        exerciseList.setLayout(new BoxLayout(exerciseList, BoxLayout.Y_AXIS));
        exerciseList.setOpaque(false);

        exerciseList.setFocusable(true);
        exerciseList.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                exerciseList.requestFocusInWindow();
            }
        });

        addPlanTitle();
        populateExerciseList();

        stats = new JPanel();
        stats.setLayout(new BoxLayout(stats, BoxLayout.Y_AXIS));
        stats.setOpaque(false);
        stats.setPreferredSize(new Dimension(180, 0));
        populateStatsPanel();

        content.add(exerciseList, BorderLayout.CENTER);
        content.add(stats, BorderLayout.EAST);

        return content;
    }

    // MODIFIES: this
    // EFFECTS: adds all days and their exercises to the main panel
    private void populateExerciseList() {
        WorkoutPlan plan = app.getActivePlan();
        if (plan == null || plan.getWorkoutDays().isEmpty()) {
            return;
        }

        for (WorkoutDay day : plan.getWorkoutDays()) {
            exerciseList.add(buildDaySection(day));
            exerciseList.add(Box.createVerticalStrut(32));
        }
    }

    // EFFECTS: draws and returns one day section with heading and list of exercise
    // rows
    @SuppressWarnings("methodlength")
    private JPanel buildDaySection(WorkoutDay day) {
        JPanel section = new JPanel();
        section.setLayout(new BoxLayout(section, BoxLayout.Y_AXIS));
        section.setOpaque(false);
        section.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel dayHeading = new JLabel(day.getName().toUpperCase());
        dayHeading.setFont(Theme.HEADLINE);
        dayHeading.setForeground(Theme.TEXT_PRIMARY);
        dayHeading.setAlignmentX(Component.LEFT_ALIGNMENT);

        section.add(dayHeading);
        section.add(Box.createVerticalStrut(14));

        for (Exercise ex : day.getExercises()) {
            section.add(buildExerciseRow(ex, day));
            section.add(Box.createVerticalStrut(16));
        }

        JLabel addBtn = new JLabel("+ Add Exercise");
        addBtn.setFont(Theme.BODY_SMALL);
        addBtn.setForeground(Theme.TEAL);
        addBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        addBtn.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                app.setSelectedDay(day);
                app.navigate(WorkoutSplitGUI.EXERCISE_LIB);
            }
        });
        section.add(addBtn);

        return section;
    }

    // EFFECTS: draws and returns one exercise row with name, muscles, stats, delete
    // label
    @SuppressWarnings("methodlength")
    private JPanel buildExerciseRow(Exercise ex, WorkoutDay day) {
        JPanel row = new JPanel(new BorderLayout(16, 0));
        row.setOpaque(false);
        row.setAlignmentX(Component.LEFT_ALIGNMENT);
        row.setMaximumSize(new Dimension(Integer.MAX_VALUE, 72));

        JPanel left = new JPanel();
        left.setOpaque(false);
        left.setLayout(new BoxLayout(left, BoxLayout.Y_AXIS));

        JLabel nameLabel = new JLabel(ex.getName());
        nameLabel.setFont(Theme.BODY_LARGE);
        nameLabel.setForeground(Theme.TEXT_PRIMARY);
        nameLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel musclesLabel = new JLabel(buildMuscleString(ex));
        musclesLabel.setFont(Theme.BODY_SMALL);
        musclesLabel.setForeground(Theme.TEXT_THREE);
        musclesLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        String weightStr = ex.getWeight() + " lbs";
        JLabel statsLabel = new JLabel(
                ex.getSets() + " sets  ·  "
                        + ex.getMinReps() + "–" + ex.getMaxReps() + " reps  ·  "
                        + weightStr + "  ·  "
                        + "RIR " + ex.getRir());
        statsLabel.setFont(new Font("Dialog", Font.PLAIN, 12));
        statsLabel.setForeground(Theme.TEXT_TWO);
        statsLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        left.add(nameLabel);
        left.add(Box.createVerticalStrut(2));
        left.add(musclesLabel);
        left.add(Box.createVerticalStrut(2));
        left.add(statsLabel);

        JLabel deleteLabel = new JLabel("Delete");
        deleteLabel.setFont(Theme.BODY_SMALL);
        deleteLabel.setForeground(Theme.TEXT_THREE);
        deleteLabel.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));

        deleteLabel.addMouseListener(new java.awt.event.MouseAdapter() {
            @Override
            public void mouseClicked(java.awt.event.MouseEvent e) {
                day.userRemoveExercise(ex.getName());
                refresh();
            }
        });

        row.add(left, BorderLayout.CENTER);
        row.add(deleteLabel, BorderLayout.EAST);

        return row;
    }

    // EFFECTS: returns muscle group names as a string
    private String buildMuscleString(Exercise ex) {
        StringBuilder sb = new StringBuilder();
        List<MuscleGroup> muscles = ex.getTargetMuscles();
        for (int i = 0; i < muscles.size(); i++) {
            sb.append(muscles.get(i).name().replace("_", " "));
            if (i < muscles.size() - 1) {
                sb.append(", ");
            }
        }
        return sb.toString();
    }

    // MODIFIES: this
    // EFFECTS: adds plain-text stat labels for every day in the plan
    @SuppressWarnings("methodlength")
    private void populateStatsPanel() {
        WorkoutPlan plan = app.getActivePlan();
        if (plan == null || plan.getWorkoutDays().isEmpty()) {
            return;
        }

        RoundedButton back = new RoundedButton("Back");
        back.addActionListener(e -> app.navigate(WorkoutSplitGUI.MAIN_PAGE));
        stats.add(back);
        stats.add(Box.createVerticalStrut(5));

        RoundedButton save = new RoundedButton("Save");
        save.addActionListener(e -> savePlan());
        stats.add(save);

        JLabel heading = new JLabel("Stats");
        heading.setFont(Theme.HEADLINE);
        heading.setForeground(Theme.TEXT_PRIMARY);
        heading.setAlignmentX(Component.LEFT_ALIGNMENT);
        stats.add(heading);
        stats.add(Box.createVerticalStrut(16));

        for (WorkoutDay day : plan.getWorkoutDays()) {
            JLabel text = new JLabel(day.getName());
            text.setFont(Theme.BODY_SMALL);
            text.setForeground(Theme.TEXT_TWO);
            text.setAlignmentX(Component.LEFT_ALIGNMENT);
            stats.add(text);
            stats.add(Box.createVerticalStrut(3));

            JLabel time = new JLabel("time: " + day.calculateSessionLength() + " min");
            time.setFont(Theme.BODY_SMALL);
            time.setForeground(Theme.TEXT_TWO);
            time.setAlignmentX(Component.LEFT_ALIGNMENT);
            stats.add(time);
            stats.add(Box.createVerticalStrut(3));

            JLabel cals = new JLabel("Calories: " + day.calculateCaloriesBurnt() + " kcal");
            cals.setFont(Theme.BODY_SMALL);
            cals.setForeground(Theme.TEXT_TWO);
            cals.setAlignmentX(Component.LEFT_ALIGNMENT);
            stats.add(cals);
            stats.add(Box.createVerticalStrut(19));
        }
    }

    private void savePlan() {
        WorkoutPlan plan = app.getActivePlan();
        if (plan == null) {
            return;
        }

        String filename = plan.getName() + ".json";
        String path = "./data/" + filename;

        try {
            JsonWriter writer = new JsonWriter(path);
            writer.open();
            writer.write(plan);
            writer.close();
        } catch (FileNotFoundException e) {
            System.out.println("Could not save plan.");
        }
    }

    private void addPlanTitle() {
        WorkoutPlan plan = app.getActivePlan();
        if (plan == null) {
            return;
        }

        JTextField planTitleField = new JTextField(plan.getName());
        planTitleField.setFont(Theme.HEADLINE_LARGE);
        planTitleField.setForeground(Theme.TEXT_PRIMARY);
        planTitleField.setBackground(Theme.PAGE_BG);
        planTitleField.setBorder(BorderFactory.createEmptyBorder());
        planTitleField.setOpaque(false);
        planTitleField.setAlignmentX(Component.LEFT_ALIGNMENT);

        planTitleField.addActionListener(e -> plan.setName(planTitleField.getText()));
        planTitleField.addFocusListener(new java.awt.event.FocusAdapter() {
            @Override
            public void focusLost(java.awt.event.FocusEvent e) {
                plan.setName(planTitleField.getText());
            }
        });

        exerciseList.add(planTitleField);
        exerciseList.add(Box.createVerticalStrut(24));
    }

    // MODIFIES: this
    // EFFECTS: clears and rebuilds both panels in case of alteration
    public void refresh() {
        exerciseList.removeAll();
        addPlanTitle();
        populateExerciseList();
        exerciseList.revalidate();
        exerciseList.repaint();

        stats.removeAll();
        populateStatsPanel();
        stats.revalidate();
        stats.repaint();
    }
}

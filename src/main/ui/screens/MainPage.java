package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedButton;
import ui.gui.RoundedPanel;
import ui.gui.Theme;

import java.awt.*;
import javax.swing.*;

import model.WorkoutPlan;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class MainPage extends BaseScreen {
    private JPanel grid;

    public MainPage(WorkoutSplitGUI app) {
        super(app);
    }

    // EFFECTS: draws the main content of the page
    @Override
    protected JPanel buildContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Theme.PAGE_BG);
        content.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        content.add(buildRow());
        content.add(Box.createVerticalStrut(24));
        grid = buildSplitsGrid();
        content.add(grid);

        return content;
    }

    // EFFECTS: draws the "Create New Split" button and "My Saved Splits" label
    private JPanel buildRow() {
        JPanel row = new JPanel(new BorderLayout());
        row.setBackground(Theme.PAGE_BG);
        JLabel label = new JLabel("MY SAVED SPLITS");
        label.setFont(Theme.HEADLINE);
        label.setForeground(Theme.TEXT_THREE);

        RoundedButton button = new RoundedButton("+ Create New Split");
        button.addActionListener(e -> app.navigate(WorkoutSplitGUI.GYM_TYPE));

        JPanel btn = new JPanel(new GridBagLayout());
        btn.setOpaque(false);
        btn.add(button);

        row.add(label, BorderLayout.WEST);
        row.add(btn, BorderLayout.EAST);

        return row;
    }

    // EFFECTS: draws the grid of saved workout splits
    private JPanel buildSplitsGrid() {
        JPanel grid = new JPanel(new GridLayout(0, 2, 20, 20));
        grid.setBackground(Theme.PAGE_BG);

        for (WorkoutPlan i : app.getSavedPlans()) {
            grid.add(buildSplitCard(i));
        }

        return grid;
    }

    // EFFECTS: draws an individual workout split card
    @SuppressWarnings("methodlength")
    private JPanel buildSplitCard(WorkoutPlan plan) {
        RoundedPanel card = new RoundedPanel(12);
        card.setBackground(Theme.CARD_WHITE);
        card.setLayout(new BorderLayout());
        card.setBorder(BorderFactory.createEmptyBorder(25, 10, 25, 10));

        JPanel top = new JPanel(new BorderLayout());
        top.setOpaque(false);

        JLabel title = new JLabel(plan.getName());
        title.setFont(Theme.HEADLINE);
        title.setForeground(Theme.TEXT_PRIMARY);
        title.setVerticalAlignment(SwingConstants.CENTER);

        JPanel actions = new JPanel(new FlowLayout(FlowLayout.RIGHT, 4, 0));
        actions.setOpaque(false);

        JButton deleteBtn = new JButton("Delete");
        deleteBtn.setFont(Theme.BODY);
        deleteBtn.setForeground(Theme.TEXT_TWO);
        deleteBtn.setBorderPainted(false);
        deleteBtn.setContentAreaFilled(false);
        deleteBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        deleteBtn.addActionListener(e -> {
            app.getSavedPlans().remove(plan);
            app.navigate(WorkoutSplitGUI.MAIN_PAGE);
        });

        actions.add(deleteBtn);
        top.add(title, BorderLayout.WEST);
        top.add(actions, BorderLayout.EAST);

        JPanel bottom = new JPanel(new BorderLayout());
        bottom.setOpaque(false);

        JPanel load = new JPanel(new FlowLayout(FlowLayout.LEFT, 4, 0));
        load.setOpaque(false);

        JButton loadBtn = new JButton("Load →");
        loadBtn.setFont(Theme.BODY);
        loadBtn.setForeground(Theme.TEAL);
        loadBtn.setBorderPainted(false);
        loadBtn.setContentAreaFilled(false);
        loadBtn.setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
        loadBtn.addActionListener(e -> {
            app.setActivePlan(plan);
            app.navigate(WorkoutSplitGUI.SPLIT_VIEW);
        });

        bottom.add(load, BorderLayout.WEST);
        bottom.add(loadBtn, BorderLayout.EAST);

        JPanel body = new JPanel();
        body.setOpaque(false);
        body.setLayout(new BoxLayout(body, BoxLayout.Y_AXIS));
        body.add(top);
        body.add(bottom);

        card.add(body, BorderLayout.CENTER);

        return card;
    }

    // MODIFIES: this
    // EFFECTS: reloads the saved workout plans in the grid
    public void refresh() {
        this.grid.removeAll();
        for (WorkoutPlan i : app.getSavedPlans()) {
            this.grid.add(buildSplitCard(i));
        }
        this.grid.revalidate();
    }
}

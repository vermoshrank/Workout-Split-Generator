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
        setLayout(new BorderLayout());
        setBackground(Theme.SURFACE);

        add(buildHeader(), BorderLayout.NORTH);

        JScrollPane scrollPane = new JScrollPane(buildContent());
        scrollPane.setBorder(null);
        scrollPane.getViewport().setBackground(Theme.SURFACE);
        scrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        add(scrollPane, BorderLayout.CENTER);
    }

    // methods for building respective elements in a panel
    // EFFECTS: builds and returns universal header for panels
    private JPanel buildHeader() {
        JPanel header = new JPanel(new FlowLayout(FlowLayout.LEFT, 24, 0));
        header.setBackground(Color.WHITE);
        header.setPreferredSize(new Dimension(0, 64));

        JLabel title = new JLabel("WORKOUT SPLIT GENERATOR");
        title.setFont(Theme.HEADLINE);
        title.setForeground(Theme.PRIMARY);
        header.add(title);

        return header;
    }

    protected abstract JPanel buildContent();
}

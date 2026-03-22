package ui.screens;

import ui.WorkoutSplitGUI;
import ui.gui.BaseScreen;
import ui.gui.RoundedButton;
import ui.gui.RoundedPanel;
import ui.gui.Theme;
import model.enums.GymType;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.*;

/**
 * First step of the split-generation process. Lets the user choose their
 * gym type (Everything, Commercial, Local, or Home), then navigates to the
 * frequency-selection step.
 */
import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

@ExcludeFromJacocoGeneratedReport
public class GymTypeScreen extends BaseScreen {
    private GymType selectedType;

    public GymTypeScreen(WorkoutSplitGUI app) {
        super(app);
    }

    // EFFECTS: combines all drawn panels to form the content of page
    @Override
    protected JPanel buildContent() {
        JPanel content = new JPanel();
        content.setLayout(new BoxLayout(content, BoxLayout.Y_AXIS));
        content.setBackground(Theme.PAGE_BG);
        content.setBorder(BorderFactory.createEmptyBorder(40, 40, 40, 40));

        content.add(buildStepQuestion());
        content.add(Box.createVerticalStrut(40));
        content.add(buildGymGrid());

        return content;
    }

    // EFFECTS: draws and returns JLabel for headline
    private JLabel buildStepQuestion() {
        JLabel label = new JLabel("What type of gym do you train at?");
        label.setFont(Theme.HEADLINE_LARGE);
        label.setForeground(Theme.TEXT_PRIMARY);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    // EFFECTS: draws and returns JPanel with gym type choices
    private JPanel buildGymGrid() {
        JPanel grid = new JPanel(new GridLayout(2, 2, 16, 16));
        grid.setBackground(Theme.PAGE_BG);
        grid.setAlignmentX(Component.LEFT_ALIGNMENT);

        grid.add(buildCard(
                GymType.EVERYTHING,
                "Everything",
                "everything.png"));

        grid.add(buildCard(
                GymType.COMMERCIAL,
                "Commercial",
                "commercial.png"));

        grid.add(buildCard(
                GymType.LOCAL,
                "Local",
                "local.png"));

        grid.add(buildCard(
                GymType.HOME,
                "Home",
                "home.png"));

        return grid;

    }

    // EFFECTS: draws and returns a single JPanel for a single gym type selection
    private RoundedButton buildCard(GymType gymType, String title, String iconFile) {
        RoundedButton card = new RoundedButton("");
        card.setMaximumSize(new Dimension(Integer.MAX_VALUE, Integer.MAX_VALUE));
        card.setPreferredSize(null);
        card.setMinimumSize(new Dimension(0, 0));
        card.setForeground(Theme.CARD_WHITE);

        card.setLayout(new BoxLayout(card, BoxLayout.Y_AXIS));
        card.setBorder(BorderFactory.createEmptyBorder(28, 28, 28, 28));
        card.setHorizontalAlignment(SwingConstants.LEFT);

        card.add(buildIcon(iconFile));
        card.add(Box.createVerticalStrut(20));
        card.add(buildCardTitle(title));

        card.addActionListener(e -> {
            this.setGymType(gymType);
            app.setSelectedGymType(gymType);
            app.navigate(WorkoutSplitGUI.FREQUENCY);
        });

        return card;
    }

    // EFFECTS: draws and returns an image icon for gym type
    private JPanel buildIcon(String iconFile) {
        RoundedPanel box = new RoundedPanel(10);
        box.setBackground(Theme.CARD_WHITE);
        box.setLayout(new GridBagLayout());
        Dimension size = new Dimension(48, 48);
        box.setPreferredSize(size);
        box.setMinimumSize(size);
        box.setMaximumSize(size);
        box.setAlignmentX(Component.LEFT_ALIGNMENT);

        ImageIcon icon = loadIcon(iconFile);
        box.add(new JLabel(icon));

        return box;
    }

    // EFFECTS: loads and returns image from fale based on name
    private ImageIcon loadIcon(String fileName) {
        try {
            BufferedImage img = ImageIO.read(new File("./data/" + fileName));
            Image scaled = img.getScaledInstance(26, 26, Image.SCALE_DEFAULT);
            return new ImageIcon(scaled);
        } catch (IOException | IllegalArgumentException e) {
            return null;
        }
    }

    private JLabel buildCardTitle(String text) {
        JLabel label = new JLabel(text);
        label.setFont(Theme.HEADLINE);
        label.setForeground(Theme.PAGE_BG);
        label.setAlignmentX(Component.LEFT_ALIGNMENT);
        return label;
    }

    public void setGymType(GymType g) {
        this.selectedType = g;
    }

    public GymType getGymType() {
        return this.selectedType;
    }
}

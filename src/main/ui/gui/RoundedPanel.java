package ui.gui;

import java.awt.*;
import javax.swing.*;

// based off code from this video: https://www.youtube.com/watch?v=4PRqBDDixWE
// represents a rounded panel due to Java Swing limitations
public class RoundedPanel extends JPanel {
    private int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
    }

    // EFFECTS: allows for rounded edges
    @Override
    protected void paintComponent(Graphics g) {

    }
}

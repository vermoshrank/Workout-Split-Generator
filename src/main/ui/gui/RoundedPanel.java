package ui.gui;

import java.awt.*;
import javax.swing.*;

import ca.ubc.cs.ExcludeFromJacocoGeneratedReport;

// based off code from this video: https://www.youtube.com/watch?v=4PRqBDDixWE
// represents a rounded panel due to Java Swing limitations
@ExcludeFromJacocoGeneratedReport
public class RoundedPanel extends JPanel {
    private int radius;

    public RoundedPanel(int radius) {
        this.radius = radius;
        setOpaque(false);
    }

    // EFFECTS: allows for rounded edges
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setColor(getBackground());
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), radius, radius);
        g2.dispose();
    }
}

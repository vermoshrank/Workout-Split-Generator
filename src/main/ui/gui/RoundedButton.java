package ui.gui;

import java.awt.*;
import javax.swing.*;

// represents a rounded button that will be used
public class RoundedButton extends JButton {
    public RoundedButton(String text) {
        super(text);
        setOpaque(false);
        setContentAreaFilled(false);
        setBorderPainted(false);
        setForeground(Theme.PAGE_BG);
        setFont(Theme.BODY);
        setPreferredSize(new Dimension(200, 50));
        setMinimumSize(new Dimension(200, 50));
        setMaximumSize(new Dimension(200, 50));
        setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
    }

    // EFFECTS: allows for rounded edges
    // based off code from this video: https://www.youtube.com/watch?v=4PRqBDDixWE
    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g.create();
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        g2.setPaint(Theme.OTHER_TEXT);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 12, 12);
        g2.dispose();

        super.paintComponent(g);
    }
}

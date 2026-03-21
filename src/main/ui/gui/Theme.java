package ui.gui;

import java.awt.Color;
import java.awt.Font;

// repository for colors and fonts
public class Theme {
    public static final Color SURFACE = hex("#f8fafb");
    public static final Color SURFACE_CONTAINER = hex("#e8eff1");
    public static final Color SURFACE_CONTAINER_LOW = hex("#f0f4f6");
    public static final Color SURFACE_CONTAINER_HIGH = hex("#e1eaec");
    public static final Color SURFACE_CONTAINER_HIGHEST = hex("#d9e4e8");
    public static final Color SURFACE_CONTAINER_LOWEST = hex("#ffffff");

    public static final Color PRIMARY = hex("#3e646e");
    public static final Color PRIMARY_DIM = hex("#325861");
    public static final Color PRIMARY_CONTAINER = hex("#c1e9f5");
    public static final Color ON_PRIMARY = hex("#ebfaff");
    public static final Color ON_PRIMARY_CONTAINER = hex("#315761");
    public static final Color SECONDARY = hex("#c9e7f7");
    public static final Color ON_SECONDARY = hex("#395663");

    // Text
    public static final Color ON_SURFACE = hex("#2a3437");
    public static final Color ON_SURFACE_TWO = hex("#566164");
    public static final Color OUTLINE = hex("#727d80");
    public static final Color OUTLINE_TWO = hex("#a9b4b7");

    // fonts
    public static final Font HEADLINE = new Font("Dialog", Font.BOLD, 36);
    public static final Font BODY = new Font("Dialog", Font.PLAIN, 14);

    // EFFECTS: hex converter
    private static Color hex(String hex) {
        return Color.decode(hex);
    }

}

package ui.gui;

import java.awt.Color;
import java.awt.Font;

// repository for colors and fonts
public class Theme {
    public static final Color PAGE_BG = hex("#f8fafb"); 
    public static final Color CARD_WHITE = hex("#ffffff"); 
    public static final Color WHITE_DIM = hex("#e8eff1");
    public static final Color WHITE_DIMMER = hex("#e1eaec");
    public static final Color WHITE_GREY = hex("#d9e4e8"); 
    public static final Color BG = hex("#f0f4f6"); 

    public static final Color TEAL = hex("#3e646e"); 
    public static final Color TEAL_DARK = hex("#325861"); 
    public static final Color TEAL_LIGHT = hex("#c1e9f5");
    public static final Color SLIGHT_TEAL = hex("#ebfaff"); 
    public static final Color TEAL_LIGHT_TWO = hex("#315761");

    public static final Color OTHER_BG = hex("#c9e7f7"); 
    public static final Color OTHER_TEXT = hex("#395663");

    public static final Color TEXT_PRIMARY = hex("#2a3437"); 
    public static final Color TEXT_TWO = hex("#566164"); 
    public static final Color TEXT_THREE = hex("#727d80");
    public static final Color TEXT_FOUR = hex("#a9b4b7"); 

    // fonts
    public static final Font HEADLINE_LARGE = new Font("Dialog", Font.BOLD, 36);
    public static final Font HEADLINE = new Font("Dialog", Font.BOLD, 24);
    public static final Font BODY_LARGE = new Font("Dialog", Font.BOLD, 14);
    public static final Font BODY = new Font("Dialog", Font.BOLD, 14);
    public static final Font LABEL = new Font("Dialog", Font.BOLD, 10);

    // EFFECTS: hex converter
    private static Color hex(String hex) {
        return Color.decode(hex);
    }

}

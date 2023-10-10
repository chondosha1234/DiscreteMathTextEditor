package gui;

import java.awt.Color;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.UIManager;

public class SaveOnCloseDialog extends JOptionPane {

    public SaveOnCloseDialog() {
        Color backgroundColor = ColorScheme.BACKGROUND_COLOR;
        Color textColor = ColorScheme.TEXTCOLOR;

        UIManager.put("JOptionPane.background", backgroundColor);
        UIManager.put("JOptionPane.messageForeground", textColor);
        UIManager.put("Panel.background", backgroundColor);
    
    }

    
}

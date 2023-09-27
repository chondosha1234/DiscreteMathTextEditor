import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.border.Border;

public class TextArea extends JTextArea {
    
    public TextArea() {

        Color backgroundColor = new Color(30, 30, 30); // Dark background
        Color textColor = new Color(220, 220, 220); // Light text
        Color borderColor = new Color(60, 60, 60); // Border color

        // setting colors for background, font, caret, and creating borders and margins
        this.setCaretColor(textColor);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);
        Border textAreaBorder = BorderFactory.createLineBorder(borderColor, 1);
        Border insetMargin = BorderFactory.createEmptyBorder(25,15,20,15);
        Border compoundBorder = BorderFactory.createCompoundBorder(textAreaBorder, insetMargin);
        this.setBorder(compoundBorder);

        // Dialog is a font that supports the correct unicode characters
        Font font = new Font("Dialog", Font.PLAIN, 24);
        this.setFont(font);
        
        // dimensions for 1 page of text
        int pageWidth = 350;
        int pageHeight = 650;

        // Calculate the number of characters that fit horizontally and vertically
        int charWidth = getFontMetrics(font).charWidth('A');
        int charHeight = getFontMetrics(font).getHeight();
 
        // Set the number of rows and columns for the JTextArea
        int columns = pageWidth / charWidth;    // Set your desired page width
        int rows = pageHeight / charHeight;      // Set your desired page height
        this.setRows(rows);
        this.setColumns(columns);

    }
}

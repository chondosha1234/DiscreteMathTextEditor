package gui;
import java.awt.Color;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.text.AttributeSet;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
import javax.swing.text.DocumentFilter;
import javax.swing.text.PlainDocument;

public class TextArea extends JTextArea {

    private int maxColumns = 50;
    
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
        Font font = new Font("Dialog", Font.PLAIN, 18);
        this.setFont(font);

        //this.setWrapStyleWord(true);
        //this.setLineWrap(true);

        /* 
        TextAreaDocumentFilter dmdf = new TextAreaDocumentFilter();
        PlainDocument p = (PlainDocument) this.getDocument();
        p.setDocumentFilter(dmdf);
        */
        
        /* 
        // dimensions for 1 page of text
        int pageWidth = 50;
        int pageHeight = 50;

        // Calculate the number of characters that fit horizontally and vertically
        int charWidth = getFontMetrics(font).charWidth('A');
        int charHeight = getFontMetrics(font).getHeight();
 
        // Set the number of rows and columns for the JTextArea
        int columns = pageWidth / charWidth;    // Set your desired page width
        int rows = pageHeight / charHeight;      // Set your desired page height
        this.setRows(rows);
        this.setColumns(columns);

        this.setWrapStyleWord(true);
        this.setLineWrap(true);
        */

    }

    private class TextAreaDocumentFilter extends DocumentFilter {

        public void insertString(DocumentFilter.FilterBypass fb, int offset, String text, AttributeSet attr) throws BadLocationException {
            Document doc = fb.getDocument();
            int currentRow = doc.getDefaultRootElement().getElementIndex(offset);
            int currentColumn = offset - doc.getDefaultRootElement().getElement(currentRow).getStartOffset();

            if (currentColumn + text.length() > maxColumns) {
                // Calculate how many characters can be added to the current line
                int remainingSpace = maxColumns - currentColumn;
                if (remainingSpace > 0) {
                    String insertText = text.substring(0, remainingSpace);
                    super.insertString(fb, offset, insertText, attr);
                    offset += insertText.length();
                    text = text.substring(remainingSpace);
                } else {
                    
                }

            } else {
                super.insertString(fb, offset, text, attr);
            }
        }
    }
}

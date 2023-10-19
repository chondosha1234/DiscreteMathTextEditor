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
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.StyleSheet;

public class TextArea extends JTextPane {

    private int maxColumns = 50;
    
    public TextArea() {

        Color backgroundColor = new Color(30, 30, 30); // Dark background
        Color textColor = new Color(220, 220, 220); // Light text
        Color borderColor = new Color(60, 60, 60); // Border color


        // Dialog is a font that supports the correct unicode characters
        Font font = new Font("Dialog", Font.PLAIN, 18);

        // set content type to text/html for styling purposes, like superscript / subscript
        this.setContentType("text/html");

        // need an html editor kit to make changes 
        HTMLEditorKit kit = new HTMLEditorKit();
        this.setEditorKit(kit);

        // document being stored in the jtextpane
        HTMLDocument doc = new HTMLDocument();
        this.setDocument(doc);

        // get stylesheet of the kit and add rules for text styling
        StyleSheet styleSheet = doc.getStyleSheet();

        String cssTextColor = String.format("#%02X%02X%02X", textColor.getRed(), textColor.getGreen(), textColor.getBlue());
        String cssFont = "font-family: " + Font.DIALOG + "; font-size: 18pt;";
        String cssSuperscript = "sup { vertical-align: super; font-size: smaller; }";

        styleSheet.addRule("body { color: " + cssTextColor + "; " + cssFont + "}");
        styleSheet.addRule(cssSuperscript);

        // setting colors for background, font, caret, and creating borders and margins
        this.setCaretColor(textColor);
        this.setBackground(backgroundColor);
        this.setForeground(textColor);
        Border textAreaBorder = BorderFactory.createLineBorder(borderColor, 1);
        Border insetMargin = BorderFactory.createEmptyBorder(25,15,20,15);
        Border compoundBorder = BorderFactory.createCompoundBorder(textAreaBorder, insetMargin);
        this.setBorder(compoundBorder);

        // Dialog is a font that supports the correct unicode characters
        //Font font = new Font("Dialog", Font.PLAIN, 18);
        //this.setFont(font);

        //this.setWrapStyleWord(true);
        //this.setLineWrap(true);

        /* 
        TextAreaDocumentFilter dmdf = new TextAreaDocumentFilter();
        PlainDocument p = (PlainDocument) this.getDocument();
        p.setDocumentFilter(dmdf);
        */
        

    }

    private class TextPaneDocumentFilter extends DocumentFilter {

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

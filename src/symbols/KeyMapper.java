package symbols;

import gui.TextArea;

import java.awt.event.*;

/* 
 * Class handles the key mapping implementation.  It maps the numpad keys to various discrete math symbols.  
 * Because it implements KeyListener, once an object is instantiated, the TextArea in the main DiscreteMathEditor class 
 * can add this object with addKeyListener
 */
public class KeyMapper implements KeyListener {

    private TextArea textArea;

    // Default symbols, can be changed later
    private static String[][] selectedSymbols = {
            {"\u222B", "\u2211"},  // integral and sigma sum
            {"\u2205", "\u2218"},  //  null set and compose function
            {"\u221E", ""},  // infinity
            {"\u2227", "\u2228"},  // logical AND and OR
            {"\u00AC", "\u2234"},  // logical NOT and THEREFORE 
            {"\u2192", "\u2194"},  // implication and biconditional arrows
            {"\u2261", "\u2262"},  // equivalent and not equivalent
            {"\u2203", "\u2200"},  // Existential and Universal symbols
            {"\u2282", "\u2286"},  // subset and subset equals 
            {"\u2208", "\u2209"},  // set member and not set member
            {"\u222A", "\u2229"},  // set Union and Intersection
            {"\u2265", "\u2264"},  // greater than / less than or equals
            {"\u2260", "\u220E"},  // not equal, end proof symbol
            {"\u00B2", "\u00B3"}   // squared superscript / cubed superscript
    };

    public KeyMapper(TextArea textArea) {
        this.textArea = textArea;
    }


    @Override
    public void keyPressed(KeyEvent e) {

        // whenever users enters any key, it should set the flag so if they try to exit without saving the application can warn user
        if (this.textArea.getChangeSinceSave() == false) {
            this.textArea.setChangeSinceSave(true);
        }

        int caretPosition = textArea.getCaretPosition();
                
                // each pair of if / else statements here accounts for a numpad button with and without the ctrl key pressed 
                // the check for ctrl not pressed prevents the logic from always just choosing the not pressed option first
                if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DIVIDE) {

                    textArea.insert(selectedSymbols[0][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DIVIDE) {

                    textArea.insert(selectedSymbols[0][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MULTIPLY) {

                    textArea.insert(selectedSymbols[1][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MULTIPLY) {

                    textArea.insert(selectedSymbols[1][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SUBTRACT) {

                    textArea.insert(selectedSymbols[2][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SUBTRACT) {

                    textArea.insert(selectedSymbols[2][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert(selectedSymbols[3][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert(selectedSymbols[3][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert(selectedSymbols[4][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert(selectedSymbols[4][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert(selectedSymbols[5][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert(selectedSymbols[5][1], caretPosition);
                    
                }else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert(selectedSymbols[6][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert(selectedSymbols[6][1], caretPosition);
                    
                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert(selectedSymbols[7][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert(selectedSymbols[7][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                    textArea.insert(selectedSymbols[8][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                    textArea.insert(selectedSymbols[8][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                    textArea.insert(selectedSymbols[9][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                    textArea.insert(selectedSymbols[9][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                    textArea.insert(selectedSymbols[10][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                    textArea.insert(selectedSymbols[10][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD3) {

                    textArea.insert(selectedSymbols[11][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD3) {

                    textArea.insert(selectedSymbols[11][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD0) {

                    textArea.insert(selectedSymbols[12][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD0) {

                    textArea.insert(selectedSymbols[12][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_DECIMAL) {

                    textArea.insert(selectedSymbols[13][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DECIMAL) {

                    textArea.insert(selectedSymbols[13][1], caretPosition);
                    
                }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int caretPosition = textArea.getCaretPosition();

        // This code is necessary to remove the number generated when the numpad key is pressed, but leaving the desired symbol
        // Common solutions like using e.consume() do not work on the numpad keys specifically 
        if (!e.isControlDown() && (
                    e.getKeyCode() == KeyEvent.VK_NUMPAD7 || 
                    e.getKeyCode() == KeyEvent.VK_NUMPAD8 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD9 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD4 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD5 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD6 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD1 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD2 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD3 ||
                    e.getKeyCode() == KeyEvent.VK_NUMPAD0 ||
                    e.getKeyCode() == KeyEvent.VK_DECIMAL ||
                    e.getKeyCode() == KeyEvent.VK_DIVIDE  ||
                    e.getKeyCode() == KeyEvent.VK_MULTIPLY ||
                    e.getKeyCode() == KeyEvent.VK_SUBTRACT
                )) {

                    String text = textArea.getText();
                    String newText;

                    if (caretPosition == text.length()) {
                        // caret or cursor is at end of the line
                        newText = text.substring(0, text.length()-1);
                    } else {
                        // caret or cursor is in middle of the text, need to remove the numpad number at that point 
                        // instead of just removing the end
                        String firstHalf = text.substring(0, caretPosition-1);
                        String secondHalf = text.substring(caretPosition, text.length());
                        newText = firstHalf + secondHalf;
                    }
                    textArea.setText(newText);
                    // setting textArea text puts caret at end, but if you type in middle of line, need to have caret placed there
                    textArea.setCaretPosition(caretPosition-1);
                }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    /* 
     * Meethod changes the array of selected symbols which affects the actual mapping of keys 
     */
    public static void setSelectedSymbols(String primarySymbol, String secondarySymbol, int index) {
        selectedSymbols[index][0] = primarySymbol;
        selectedSymbols[index][1] = secondarySymbol;
    }

}
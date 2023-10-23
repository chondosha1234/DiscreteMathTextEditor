package symbols;

import javax.swing.*;
import javax.swing.text.BadLocationException;
import javax.swing.text.StyledDocument;

import java.awt.event.*;

/* 
 * Class handles the key mapping implementation.  It maps the numpad keys to various discrete math symbols.  
 * Because it implements KeyListener, once an object is instantiated, the TextArea in the main DiscreteMathEditor class 
 * can add this object with addKeyListener
 */
public class KeyMapper implements KeyListener {

    private JTextPane textArea;
    private StyledDocument doc;

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

    public KeyMapper(JTextPane textArea) {
        this.textArea = textArea;
        doc = textArea.getStyledDocument();
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int caretPosition = textArea.getCaretPosition();
                
                // each pair of if / else statements here accounts for a numpad button with and without the ctrl key pressed 
                // the check for ctrl not pressed prevents the logic from always just choosing the not pressed option first
                if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DIVIDE) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[0][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                        //textArea.insert(selectedSymbols[0][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DIVIDE) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[0][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[0][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[1][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[1][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_MULTIPLY) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[1][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[1][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[2][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[2][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_SUBTRACT) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[2][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[2][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[3][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[3][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[3][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[3][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[4][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[4][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[4][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[4][1], caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[5][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[5][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[5][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[5][1], caretPosition);
                    
                }else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[6][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[6][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[6][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[6][1], caretPosition);
                    
                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[7][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[7][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[7][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[7][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[8][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[8][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD6) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[8][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[8][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[9][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[9][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD1) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[9][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[9][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[10][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[10][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD2) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[10][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[10][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[11][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[11][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD3) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[11][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[11][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[12][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[12][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD0) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[12][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[12][1], caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_DECIMAL) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[13][0], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[13][0], caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_DECIMAL) {
                    try {
                        doc.insertString(caretPosition, selectedSymbols[13][1], null);
                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }
                    //textArea.insert(selectedSymbols[13][1], caretPosition);
                    
                }
    }

    @Override
    public void keyReleased(KeyEvent e) {
        int caretPosition = textArea.getCaretPosition();

        // This code is necessary to remove the number generated when the numpad key is pressed 
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


                    try {
                        // get the text from doc to change 
                        String text = doc.getText(0, doc.getLength());
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

                        // remove the previous text and replace it with new desired text (without the unnecessary char)
                        doc.remove(0, doc.getLength());
                        doc.insertString(0, newText, null);

                        // adjust the caret position
                        textArea.setCaretPosition(caretPosition - 1);

                    } catch (BadLocationException e1) {
                        e1.printStackTrace();
                    }

                }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

    public static void setSelectedSymbols(String primarySymbol, String secondarySymbol, int index) {
        selectedSymbols[index][0] = primarySymbol;
        selectedSymbols[index][1] = secondarySymbol;
    }

}
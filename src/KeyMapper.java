import javax.swing.*;
import java.awt.event.*;

/* 
 * Class handles the key mapping implementation.  It maps the numpad keys to various discrete math symbols.  
 * Because it implements KeyListener, once an object is instantiated, the TextArea in the main DiscreteMathEditor class 
 * can add this object with addKeyListener
 */
public class KeyMapper implements KeyListener {

    private JTextArea textArea;

    public KeyMapper(JTextArea textArea) {
        this.textArea = textArea;
    }


    @Override
    public void keyPressed(KeyEvent e) {
        int caretPosition = textArea.getCaretPosition();
                
                // each pair of if / else statements here accounts for a numpad button with and without the ctrl key pressed 
                // the check for ctrl not pressed prevents the logic from always just choosing the not pressed option first

                if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert("\u2227", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert("\u2228", caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert("\u00AC", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert("\u2234", caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert("\u2192", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert("\u2194", caretPosition);
                    
                }else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert("\u2261", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert("\u2262", caretPosition);
                    
                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert("\u2203", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert("\u2200", caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                    textArea.insert("\u2282", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD6) {

                    textArea.insert("\u2286", caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                    textArea.insert("\u2208", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD1) {

                    textArea.insert("\u2209", caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                    textArea.insert("\u222A", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD2) {

                    textArea.insert("\u2229", caretPosition);
                    
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
                    e.getKeyCode() == KeyEvent.VK_NUMPAD0
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
                }
    }

    @Override
    public void keyTyped(KeyEvent e) {
        
    }

}
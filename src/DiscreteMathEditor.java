import javax.swing.*;

import java.awt.Font;
import java.awt.Insets;
import java.awt.event.*;


public class DiscreteMathEditor extends JFrame {

    private JTextArea textArea;

    public DiscreteMathEditor() {
        setTitle("Discrete Math");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        System.out.println(textArea.getFont());

        Font font = new Font("Dialog", Font.PLAIN, 24);
        textArea.setFont(font);

        Insets margin = new Insets(10,10,10,10);
        textArea.setMargin(margin);

        getContentPane().add(new JScrollPane(textArea));

        textArea.addKeyListener(new KeyListener(){

            @Override
            public void keyPressed(KeyEvent e) {

                int caretPosition = textArea.getCaretPosition();
                System.out.println(e.isControlDown());

                if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert("\u2227", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD7) {

                    textArea.insert("\u2228", caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert("\u2192", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD8) {

                    textArea.insert("\u2194", caretPosition);

                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert("\u2261", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD9) {

                    textArea.insert("\u00AC", caretPosition);
                    
                } else if (!e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert("\u2200", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD4) {

                    textArea.insert("\u2203", caretPosition);
                    
                } else if (!e.isControlDown() &&e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert("\u2228", caretPosition);

                } else if (e.isControlDown() && e.getKeyCode() == KeyEvent.VK_NUMPAD5) {

                    textArea.insert("\u2228", caretPosition);
                    
                }
                
            }

            @Override
            public void keyTyped(KeyEvent e) {
                
            }

            @Override
            public void keyReleased(KeyEvent e) {

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
                    String newText = text.substring(0, text.length()-1);
                    textArea.setText(newText);
                }
            }
        });
    }
}
import javax.swing.*;
import javax.swing.text.DefaultEditorKit;
import java.awt.event.*;


public class DiscreteMathEditor extends JFrame {

    private JTextArea textArea;

    public DiscreteMathEditor() {
        setTitle("Discrete Math");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textArea = new JTextArea();
        getContentPane().add(new JScrollPane(textArea));

        //KeyStroke customeKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_A, KeyEvent.CTRL_DOWN_MASK);
        KeyStroke andKeyStroke = KeyStroke.getKeyStroke(KeyEvent.VK_NUMPAD7, 0);


        //textArea.getInputMap().put(customeKeyStroke, "customAction");
        textArea.getInputMap().put(andKeyStroke, "andAction");
        textArea.getActionMap().put("andAction", new AbstractAction() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String currentText = textArea.getText();
                currentText += "\u2227";
                textArea.setText(currentText);
            }
        });
    }
}
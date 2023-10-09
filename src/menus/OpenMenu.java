package menus;
import java.awt.event.*;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

public class OpenMenu implements ActionListener {

    private JTextPane textArea;
    private TopBarMenu parent;
    
    public OpenMenu(JTextPane textArea, TopBarMenu parent){
        this.textArea = textArea;
        this.parent = parent;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        int choice = fileChooser.showOpenDialog(parent);
                
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            readFile(selectedFile);
        }
    }

    private void readFile(File file) {
        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            StringBuilder content = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
            textArea.setText(content.toString());
            parent.setFile(file);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error opening file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }    
}

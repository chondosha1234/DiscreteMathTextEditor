package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;

public class SaveMenu implements ActionListener {

    private JTextArea textArea;
    private TopBarMenu parent;
    private File currentFile;
    private boolean saveAsFlag; // true for the save button, false for saveAs button

    public SaveMenu(boolean saveAsFlag, JTextArea textArea, TopBarMenu parent) {
        this.textArea = textArea;
        this.parent = parent;
        this.currentFile = parent.getFile();
        this.saveAsFlag = saveAsFlag;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (this.saveAsFlag) {
            // This option is for the save button, it may trigger saveAs option if theres no currentFile
            if (this.currentFile != null) {
                    saveFile(this.currentFile);
                } else {
                    saveAs();
                }
        } else {
            // this option just for the saveAs button in menu
            saveAs();
        }
    }
    

    private void saveFile(File file) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String content = textArea.getText();
            writer.write(content);
            JOptionPane.showMessageDialog(null, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void saveAs() {
        JFileChooser fileChooser = new JFileChooser();

        int choice = fileChooser.showSaveDialog(textArea);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            saveFile(selectedFile);
            parent.setFile(selectedFile); // Update the current file
        }
    }
    
}
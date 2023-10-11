package menus;

import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

import gui.ColorScheme;
import gui.CustomScrollBarUI;
import gui.TextArea;

public class SaveMenu implements ActionListener {

    private TextArea textArea;
    private TopBarMenu parent;
    private File currentFile;
    private boolean saveAsFlag; // true for the save button, false for saveAs button

    private Color backgroundColor = ColorScheme.BACKGROUND_COLOR;
    private Color textColor = ColorScheme.TEXTCOLOR;

    public SaveMenu(boolean saveAsFlag, TextArea textArea, TopBarMenu parent) {
        this.textArea = textArea;
        this.parent = parent;
        this.currentFile = parent.getFile();
        this.saveAsFlag = saveAsFlag;

        UIManager.put("OptionPane.background", backgroundColor);
        UIManager.put("OptionPane.messageForeground", textColor);
        UIManager.put("Panel.background", backgroundColor);
        UIManager.put("List.background", backgroundColor);
        UIManager.put("List.foreground", textColor);
        UIManager.put("Label.foreground", textColor);
        UIManager.put("TextField.background", backgroundColor);
        UIManager.put("TextField.foreground", textColor);
        UIManager.put("ComboBox.background", backgroundColor);
        UIManager.put("ComboBox.foreground", textColor);
        UIManager.put("Button.background", backgroundColor);
        UIManager.put("Button.foreground", textColor);
        UIManager.put("Button.border", BorderFactory.createLineBorder(Color.GRAY, 2));
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
    

    /*
     * Writes content to file that already exists
     */
    public void saveFile(File file) {

        try (BufferedWriter writer = new BufferedWriter(new FileWriter(file))) {
            String content = textArea.getText();
            writer.write(content);
            JOptionPane.showMessageDialog(null, "File saved successfully.", "Success", JOptionPane.INFORMATION_MESSAGE);
        } catch (IOException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Error saving file.", "Error", JOptionPane.ERROR_MESSAGE);
        }
        this.textArea.setChangeSinceSave(false);
    }

    /*
     * opens up the built in file chooser, can create new file or overwrite existing
     * calls the saveFile method to do the actual writing of data
     */
    public void saveAs() {

        JFileChooser fileChooser = new JFileChooser();

        int choice = fileChooser.showSaveDialog(textArea);
        if (choice == JFileChooser.APPROVE_OPTION) {
            File selectedFile = fileChooser.getSelectedFile();
            saveFile(selectedFile);
            parent.setFile(selectedFile); // Update the current file
            setFile(selectedFile);
        }
    }

    protected void setFile(File file) {
        this.currentFile = file;
    }
    
}

package menus;

import java.io.File;
import javax.swing.*;

/*
 *  Class to build a top bar menu for the top of the Text Editor window.  Will have basic drop down menus, like File, Edit, Settings, Help
 *  
 */
public class TopBarMenu extends JMenuBar{

    private JTextArea textArea;
    private File file;
    
    public TopBarMenu(JTextArea textArea) {

        this.textArea = textArea;
        this.file = null;
        
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // Add menus to the object itself, because it is a JMenuBar
        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);

        // File menu items 
        JMenuItem newMenuItem = new JMenuItem("New");
        JMenuItem openMenuItem = new JMenuItem("Open");
        JMenuItem saveMenuItem = new JMenuItem("Save");
        JMenuItem saveAsMenuItem = new JMenuItem("Save As");
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        openMenuItem.addActionListener(new OpenMenu(textArea, this));
        saveMenuItem.addActionListener(new SaveMenu(true, textArea, this));
        saveAsMenuItem.addActionListener(new SaveMenu(false, textArea, this));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
        fileMenu.add(saveAsMenuItem);
        fileMenu.addSeparator();
        fileMenu.add(exitMenuItem);

        // Edit menu items 
        JMenuItem cutMenuItem = new JMenuItem("Cut");
        JMenuItem copyMenuItem = new JMenuItem("Copy");
        JMenuItem pasteMenuItem = new JMenuItem("Paste");

        editMenu.add(cutMenuItem);
        editMenu.add(copyMenuItem);
        editMenu.add(pasteMenuItem);

        // Help menu items
        JMenuItem aboutMenuItem = new JMenuItem("About");

        helpMenu.add(aboutMenuItem);

    }

    public File getFile() {
        return this.file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}

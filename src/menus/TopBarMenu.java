package menus;

import java.awt.Color;
import java.io.File;
import javax.swing.*;

import gui.TextArea;

/*
 *  Class to build a top bar menu for the top of the Text Editor window.  Will have basic drop down menus, like File, Edit, 
 *  Settings, Help
 *  
 */
public class TopBarMenu extends JMenuBar {

    private File file;
    private SaveMenu saveMenu;
    
    public TopBarMenu(TextArea textArea) {

        this.file = null;

        Color backgroundColor = new Color(30, 30, 30); // Dark background
        Color textColor = new Color(220, 220, 220); // Light text
        
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        fileMenu.setForeground(textColor);
        editMenu.setForeground(textColor);
        helpMenu.setForeground(textColor);

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

        newMenuItem.setBackground(backgroundColor);
        openMenuItem.setBackground(backgroundColor);
        saveMenuItem.setBackground(backgroundColor);
        saveAsMenuItem.setBackground(backgroundColor);
        exitMenuItem.setBackground(backgroundColor);

        newMenuItem.setForeground(textColor);
        openMenuItem.setForeground(textColor);
        saveMenuItem.setForeground(textColor);
        saveAsMenuItem.setForeground(textColor);
        exitMenuItem.setForeground(textColor);

        this.saveMenu = new SaveMenu(true, textArea, this);
        openMenuItem.addActionListener(new OpenMenu(textArea, this));
        saveMenuItem.addActionListener(this.saveMenu);
        saveAsMenuItem.addActionListener(new SaveMenu(false, textArea, this));
        exitMenuItem.addActionListener(new ExitMenu());

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
        this.saveMenu.setFile(file);
        // whenever the topbar stores the file as it's file, it should update the save menu so it knows the current file
        // is what it should be working with. For example, when you open a new file, this is called and the savemenu already exists
        // and it needs to have its file updated
    }

    public SaveMenu getSaveMenu() {
        return this.saveMenu;
    }
}

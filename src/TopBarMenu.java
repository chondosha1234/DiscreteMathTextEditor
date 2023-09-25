import java.awt.Desktop;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.*;
import menus.OpenMenu;

/*
 *  Class to build a top bar menu for the top of the Text Editor window.  Will have basic drop down menus, like File, Edit, Settings, Help
 *  
 */
public class TopBarMenu extends JMenuBar{

    private JTextArea textArea;
    
    public TopBarMenu(JTextArea textArea) {

        this.textArea = textArea;
        
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
        JMenuItem exitMenuItem = new JMenuItem("Exit");

        openMenuItem.addActionListener(new OpenMenu(textArea, fileMenu));

        fileMenu.add(newMenuItem);
        fileMenu.add(openMenuItem);
        fileMenu.add(saveMenuItem);
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
}

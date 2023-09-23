import javax.swing.*;
import java.awt.event.*;

/*
 *  Class to build a top bar menu for the top of the Text Editor window.  Will have basic drop down menus, like File, Edit, Settings, Help
 *  
 */
public class TopBarMenu extends JMenuBar{
    
    public TopBarMenu() {
        
        JMenu fileMenu = new JMenu("File");
        JMenu editMenu = new JMenu("Edit");
        JMenu helpMenu = new JMenu("Help");

        // Add menus to the object itself, because it is a JMenuBar
        this.add(fileMenu);
        this.add(editMenu);
        this.add(helpMenu);

        // File menu items 


        // Edit menu items 

        // Help menu items
    }
}

package gui;
import javax.swing.*;
import javax.swing.border.Border;

import menus.SaveMenu;
import menus.TopBarMenu;
import symbols.KeyMapper;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.File;


/* 
 *  Main class to instantiate the GUI 
 *  This class calls other classes like TopBarMenu and KeyMapper to create parts of the GUI and combines them 
 */
public class DiscreteMathEditor extends JFrame {

    private JPanel mainWindow;
    private TextArea textArea;
    private boolean isSideBarCollapsed;
    private TopBarMenu topBarMenu;

    Color backgroundColor = ColorScheme.BACKGROUND_COLOR;
    Color textColor = ColorScheme.TEXTCOLOR;

    public DiscreteMathEditor() {

        setTitle("Discrete Math");
        // set screen to fullscreen
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        // center window
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);

        this.isSideBarCollapsed = false;
        int verticalPadding = 10;
        int horizontalPadding = 10;

        mainWindow = new JPanel(new BorderLayout());
        getContentPane().add(mainWindow);
        
        this.setBackground(backgroundColor);
        mainWindow.setBackground(backgroundColor);
        mainWindow.setForeground(textColor);

        // background behind the text area
        JPanel backDrop = new JPanel(new BorderLayout());
        backDrop.setBackground(Color.BLACK);
        Border backDropInset = BorderFactory.createEmptyBorder(25, 100, 25, 100);
        backDrop.setBorder(backDropInset);
        mainWindow.add(backDrop, BorderLayout.CENTER);

        // main text writing area using a custom TextArea class I made which extends JTextArea
        textArea = new TextArea();

        // typical top bar menus like file, edit, settings
        topBarMenu = new TopBarMenu(textArea);
        topBarMenu.setBackground(backgroundColor);
        topBarMenu.setForeground(textColor);
        topBarMenu.setBorderPainted(false);
        mainWindow.add(topBarMenu, BorderLayout.NORTH);

        // sidebar will hold information about the application for users
        JPanel sideBar = new JPanel(new BorderLayout());
        sideBar.setBackground(backgroundColor);
        sideBar.setForeground(textColor);
        sideBar.setPreferredSize(new Dimension(150, 50));
        sideBar.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        mainWindow.add(sideBar, BorderLayout.EAST);

        // add button to collapse sidebar
        JButton toggleSideBarButton = new JButton(">");
        toggleSideBarButton.setBackground(backgroundColor);
        toggleSideBarButton.setForeground(textColor);
        toggleSideBarButton.setPreferredSize(new Dimension(25, 25));
        sideBar.add(toggleSideBarButton, BorderLayout.SOUTH);

        // text information to explain to user
        JLabel numPadInfo = new JLabel("<html>These are the mappings of your numpad. Hold ctrl to use the secondary mappings. Make sure your numlock is on.</html>");
        numPadInfo.setBackground(backgroundColor);
        numPadInfo.setForeground(textColor);
        numPadInfo.setHorizontalAlignment(SwingConstants.CENTER);
        numPadInfo.setVerticalAlignment(SwingConstants.TOP);
        numPadInfo.setOpaque(true);
        numPadInfo.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        sideBar.add(numPadInfo, BorderLayout.NORTH);

        // a display to remind user the key mappings of the numpad
        JPanel numPad = new NumPad(this);
        numPad.setBackground(backgroundColor);
        numPad.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        sideBar.add(numPad, BorderLayout.CENTER);

        // add toggle implementation which affects numpad and numpadinfo label
        toggleSideBarButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                isSideBarCollapsed = !isSideBarCollapsed;
                numPadInfo.setVisible(!isSideBarCollapsed);
                numPad.setVisible(!isSideBarCollapsed);
                if (isSideBarCollapsed) {
                    toggleSideBarButton.setText("<");
                    sideBar.setPreferredSize(new Dimension(75, 25));
                } else {
                    toggleSideBarButton.setText(">");
                    sideBar.setPreferredSize(new Dimension(150, 50));
                }
            }
        });

        // scroll pane holds the text area inside it
        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        scrollPane.setBorder(null);
        backDrop.add(scrollPane, BorderLayout.CENTER);
        
        // create keymapper object and set it as the keyListener for the text area
        KeyMapper keyMapper = new KeyMapper(textArea);
        textArea.addKeyListener(keyMapper);

        // add window listener to implement custom close operation
        this.addWindowListener(new WindowAdapter() {
            
            @Override
            public void windowClosing(WindowEvent e) {
                exitApplication();
            }

        });
    }


    public static void addNewPage() {
        
    }


    /*
     * Method called when user clicks exit window button
     */
    public void exitApplication() {

        // check if user has typed in textarea since last save
        if (this.textArea.getChangeSinceSave() == true) {

            UIManager.put("OptionPane.background", backgroundColor);
            UIManager.put("OptionPane.messageForeground", textColor);
            UIManager.put("Panel.background", backgroundColor);
            UIManager.put("Button.background", backgroundColor);
            UIManager.put("Button.foreground", textColor);
            UIManager.put("Button.border", BorderFactory.createLineBorder(Color.GRAY, 2));

            int choice = SaveOnCloseDialog.showConfirmDialog(
                this,
                "Do you want to save before exiting?",
                "Save changes",
                JOptionPane.YES_NO_CANCEL_OPTION
            );

            // if user wants to save, get the topbarmenu, get the savemenu from the topbarmenu, and use the savefile method
            if (choice == JOptionPane.YES_OPTION) {

                File currentFile = this.topBarMenu.getFile();
                SaveMenu saveMenu = this.topBarMenu.getSaveMenu();
                // check if there is already a current file
                if (currentFile == null) {
                    saveMenu.saveAs();
                } else {
                    saveMenu.saveFile(currentFile);
                }
                dispose();

            } else if (choice == JOptionPane.NO_OPTION) {
                // users doesn't want to save
                dispose();
    
            }
            // else user hits cancel

        } else {
            // user hasn't made other changes
                dispose();
        }
    }
}
import javax.swing.*;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

import menus.TopBarMenu;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


/* 
 *  Main class to instantiate the GUI 
 *  This class calls other classes like TopBarMenu and KeyMapper to create parts of the GUI and combines them 
 */
public class DiscreteMathEditor extends JFrame {

    private JPanel mainWindow;
    private JTextArea textArea;
    private boolean isSideBarCollapsed;

    public DiscreteMathEditor() {

        setTitle("Discrete Math");
        setSize(1000, 650);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.isSideBarCollapsed = false;
        int verticalPadding = 10;
        int horizontalPadding = 10;

        mainWindow = new JPanel(new BorderLayout());
        getContentPane().add(mainWindow);

        Color backgroundColor = new Color(30, 30, 30); // Dark background
        Color textColor = new Color(220, 220, 220); // Light text
        Color borderColor = new Color(60, 60, 60); // Border color
        
        this.setBackground(backgroundColor);
        mainWindow.setBackground(backgroundColor);
        mainWindow.setForeground(textColor);

        JPanel backDrop = new JPanel(new BorderLayout());
        backDrop.setBackground(Color.BLACK);
        Border backDropInset = BorderFactory.createEmptyBorder(25, 100, 25, 100);
        backDrop.setBorder(backDropInset);
        mainWindow.add(backDrop, BorderLayout.CENTER);

        // main text writing area using a custom TextArea class I made which extends JTextArea
        textArea = new TextArea();

        // typical top bar menus like file, edit, settings
        TopBarMenu topBarMenu = new TopBarMenu(textArea);
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

        JLabel numPadInfo = new JLabel("<html>These are the mappings of your numpad. Hold ctrl to use the secondary mappings. Make sure your numlock is on.</html>");
        numPadInfo.setBackground(backgroundColor);
        numPadInfo.setForeground(textColor);
        numPadInfo.setHorizontalAlignment(SwingConstants.CENTER);
        numPadInfo.setVerticalAlignment(SwingConstants.TOP);
        numPadInfo.setOpaque(true);
        numPadInfo.setBorder(BorderFactory.createEmptyBorder(verticalPadding, horizontalPadding, verticalPadding, horizontalPadding));
        sideBar.add(numPadInfo, BorderLayout.NORTH);

        // a display to remind user the key mappings of the numpad
        JPanel numPad = new NumPad();
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

        JScrollPane scrollPane = new JScrollPane(textArea);
        scrollPane.setBorder(null);
        backDrop.add(scrollPane, BorderLayout.CENTER);
        
        // create keymapper object and set it as the keyListener for the text area
        KeyMapper keyMapper = new KeyMapper(textArea);
        textArea.addKeyListener(keyMapper);
    }
}
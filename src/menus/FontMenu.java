package menus;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

import gui.ColorScheme;

public class FontMenu implements ActionListener {

    private JTextPane textArea;
    private JMenu fontSizeMenu;

    public FontMenu(JTextPane textArea) {

        this.textArea = textArea;
        fontSizeMenu = new JMenu();

        Color backgroundColor = ColorScheme.BACKGROUND_COLOR;

        fontSizeMenu.setForeground(ColorScheme.TEXTCOLOR);
        //fontSizeMenu.setBackground(backgroundColor);

        JMenuItem font8 = new JMenuItem("8");
        JMenuItem font10 = new JMenuItem("10");
        JMenuItem font12 = new JMenuItem("12");
        JMenuItem font14 = new JMenuItem("14");
        JMenuItem font16 = new JMenuItem("16");
        JMenuItem font18 = new JMenuItem("18");
        JMenuItem font24 = new JMenuItem("24");
        JMenuItem font32 = new JMenuItem("32");

        font8.setBackground(backgroundColor);
        font10.setBackground(backgroundColor);
        font12.setBackground(backgroundColor);
        font14.setBackground(backgroundColor);
        font16.setBackground(backgroundColor);
        font18.setBackground(backgroundColor);
        font24.setBackground(backgroundColor);
        font32.setBackground(backgroundColor);

        font8.addActionListener(new FontSizeListener(8, this));
        font10.addActionListener(new FontSizeListener(10, this));
        font12.addActionListener(new FontSizeListener(12, this));
        font14.addActionListener(new FontSizeListener(14, this));
        font16.addActionListener(new FontSizeListener(16, this));
        font18.addActionListener(new FontSizeListener(18, this));
        font24.addActionListener(new FontSizeListener(24, this));
        font32.addActionListener(new FontSizeListener(32, this));

        fontSizeMenu.add(font8);
        fontSizeMenu.add(font10);
        fontSizeMenu.add(font12);
        fontSizeMenu.add(font14);
        fontSizeMenu.add(font16);
        fontSizeMenu.add(font18);
        fontSizeMenu.add(font24);
        fontSizeMenu.add(font32);

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        this.fontSizeMenu.setVisible(true);
    }

    private class FontSizeListener implements ActionListener {

        private int size;
        private FontMenu parent;

        /*
         * constructor for this listener will take the font size and a reference to the 
         * FontMenu class itself, to get a reference to the textArea stored in the FontMenu class
         */
        public FontSizeListener(int size, FontMenu parent) {
            this.size = size;
            this.parent = parent;
        }

        @Override
        public void actionPerformed(ActionEvent e) {
            // the parent of this listener will be the FontMenu class, which has a reference to the text area 
            this.parent.textArea.setFont(new Font("Dialog", Font.PLAIN, this.size));
        }

    }
    
}

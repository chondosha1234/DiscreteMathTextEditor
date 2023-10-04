package gui;
import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.plaf.basic.BasicScrollBarUI;


/*
 * Custom scroll bar ui class to style the scroll bars for both the main text area 
 * and the symbol lists in the symbol selection class 
 * 
 */
public class CustomScrollBarUI extends BasicScrollBarUI {
    
    @Override
    protected void configureScrollBarColors() {
        thumbColor = new Color(90, 90, 90); // Set the thumb color to grey
        trackColor = new Color(40, 40, 40); // Set the track color to white (background)
    }

    @Override
    protected JButton createDecreaseButton(int orientation) {
        return createZeroButton(); // Remove the decrease button
    }

    @Override
    protected JButton createIncreaseButton(int orientation) {
        return createZeroButton(); // Remove the increase button
    }

    @Override
    protected Dimension getMaximumThumbSize() {
        return new Dimension(1, 50); // Set the minimum thumb size
    }

    private JButton createZeroButton() {
        JButton button = new JButton();
        button.setPreferredSize(new Dimension(0, 0)); // Make the button size zero
        return button;
    }

    @Override
    public Dimension getPreferredSize(JComponent c) {
        return new Dimension(10, super.getPreferredSize(c).height); // Set the preferred width of the entire scrollbar
    }
}

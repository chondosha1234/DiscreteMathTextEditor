import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * A class that extends JPanel, so it can be instantiated and easily added in DiscreteMathEditor.
 * It will create a panel that is a grid that shows the
 * key mapping representation of your numpad so the user can reference it while typing.
 */
public class NumPad extends JPanel {

    public NumPad(JFrame parent) {

        setLayout(new GridLayout(4, 3, 10, 5));

        String[][] buttons = {
            {"\u2227", "\u2228"},  // logical AND and OR
            {"\u00AC", "\u2234"},  // logical NOT and THEREFORE 
            {"\u2192", "\u2194"},  // implication and biconditional arrows
            {"\u2261", "\u2262"},  // equivalent and not equivalent
            {"\u2203", "\u2200"},  // Existential and Universal symbols
            {"\u2282", "\u2286"},  // subset and subset equals 
            {"\u2208", "\u2209"},  // set member and not set member
            {"\u222A", "\u2229"},  // set Union and Intersection
            {"\u2265", "\u2264"},  // greater than / less than or equals
            {"\u2260", "\u220E"},  // not equal, end proof symbol
            {"\u00B2", "\u2211"},  // squared superscript / sigma sum
            {"", ""},
        };

        // for each label pair create a button component and put the 2 symbols on it so it looks like numpad
        for (String[] labelPair : buttons) {

            JPanel buttonPanel = new JPanel(new BorderLayout());
            JLabel mainSymbol = new JLabel(labelPair[0]);
            JLabel secondarySymbol = new JLabel(labelPair[1]);

            mainSymbol.setFont(new Font("Dialog", Font.BOLD, 16)); 
            mainSymbol.setHorizontalAlignment(SwingConstants.CENTER); 
            secondarySymbol.setFont(new Font("Dialog", Font.PLAIN, 12)); 
            secondarySymbol.setHorizontalAlignment(SwingConstants.LEFT); 

            buttonPanel.setMaximumSize(new Dimension(50, 10));
            //buttonPanel.setPreferredSize(new Dimension(50, 50));
            buttonPanel.setBackground(Color.LIGHT_GRAY);
            buttonPanel.setBorder(new LineBorder(Color.BLACK));

            mainSymbol.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
            secondarySymbol.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));
            buttonPanel.add(mainSymbol, BorderLayout.CENTER);
            buttonPanel.add(secondarySymbol, BorderLayout.SOUTH);

            buttonPanel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        SymbolSelection symbolSelection = new SymbolSelection(parent);
                        symbolSelection.setVisible(true);
                    }
                }
                
            });

            this.add(buttonPanel);
        }
    }
}

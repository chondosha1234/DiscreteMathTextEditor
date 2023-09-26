import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * A class that extends JPanel, so it can be instantiated and easily added in DiscreteMathEditor.
 * It will create a panel that is a grid that shows the
 * key mapping representation of your numpad so the user can reference it while typing.
 */
public class NumPad extends JPanel {

    public NumPad() {

        setLayout(new GridLayout(4, 3, 10, 5));

        String[][] buttons = {
            {"\u2227", "\u2228"},
            {"\u00AC", "\u2234"},
            {"\u2192", "\u2194"},
            {"\u2261", "\u2262"},
            {"\u2203", "\u2200"},
            {"\u2282", "\u2286"},
            {"\u2208", "\u2209"},
            {"\u222A", "\u2229"},
            {"", ""},
            {"", ""},
            {"", ""},
            {"", ""},
        };

        for (String[] labelPair : buttons) {

            JPanel buttonPanel = new JPanel(new BorderLayout());
            JLabel mainSymbol = new JLabel(labelPair[0]);
            JLabel secondarySymbol = new JLabel(labelPair[1]);

            mainSymbol.setFont(new Font("Dialog", Font.BOLD, 20)); 
            mainSymbol.setHorizontalAlignment(SwingConstants.CENTER); 
            secondarySymbol.setFont(new Font("Dialog", Font.PLAIN, 14)); 
            secondarySymbol.setHorizontalAlignment(SwingConstants.LEFT); 

            buttonPanel.setPreferredSize(new Dimension(50, 50));
            buttonPanel.setBackground(Color.LIGHT_GRAY);
            buttonPanel.setBorder(new LineBorder(Color.BLACK));

            mainSymbol.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
            secondarySymbol.setBorder(BorderFactory.createEmptyBorder(0, 5, 10, 0));
            buttonPanel.add(mainSymbol, BorderLayout.CENTER);
            buttonPanel.add(secondarySymbol, BorderLayout.SOUTH);

            this.add(buttonPanel);
        }
    }
}

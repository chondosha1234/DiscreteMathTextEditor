import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;
import javax.swing.border.LineBorder;

/**
 * A class that extends JPanel, so it can be instantiated and easily added in DiscreteMathEditor.
 * It will create a panel that is a grid that shows the
 * key mapping representation of your numpad so the user can reference it while typing.
 */
public class NumPad extends JPanel {
    
    private JPanel numPadGrid;

    public NumPad() {

        setLayout(new GridLayout(4, 3, 10, 5));

        String[][] buttons = {
            {"\u2227", "\u2228"},
            {"\u00AC", "\u2234"},
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

            mainSymbol.setBorder(BorderFactory.createEmptyBorder(0, 15, 0, 0));
            secondarySymbol.setBorder(BorderFactory.createEmptyBorder(5, 5, 0, 0));
            buttonPanel.add(mainSymbol, BorderLayout.CENTER);
            buttonPanel.add(secondarySymbol, BorderLayout.NORTH);

            buttonPanel.setBorder(new LineBorder(Color.BLACK));

            this.add(buttonPanel);
        }
    }
}

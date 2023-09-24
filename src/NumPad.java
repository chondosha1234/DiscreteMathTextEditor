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
            {"7", "/"},
            {"8", "*"},
            {"9", "-"},
            {"4", "+"},
            {"5", "("},
            {"6", ")"},
            {"1", "="},
            {"2", "$"},
            {"3", "@"},
            {"0", "."},
            {"", "Enter"},
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

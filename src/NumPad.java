import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;


/**
 * A class that extends JPanel, so it can be instantiated and easily added in DiscreteMathEditor.
 * It will create a panel that is a grid that shows the
 * key mapping representation of your numpad so the user can reference it while typing.
 */
public class NumPad extends JPanel {

    private String[][] buttons = {
            {"\u222B", "\u221E"},  // integral and infinity
            {"", ""},
            {"", ""},
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
            {"", ""}
    };

    public NumPad(JFrame parent) {

        setLayout(new GridLayout(5, 3, 10, 5));

        // for each label pair create a button component and put the 2 symbols on it so it looks like numpad
        for (String[] labelPair : buttons) {

            ButtonPanel buttonPanel = new ButtonPanel(new BorderLayout());
            buttonPanel.setSymbols(labelPair[0], labelPair[1]);

            buttonPanel.addMouseListener(new MouseAdapter() {

                @Override
                public void mouseClicked(MouseEvent e) {
                    if (e.getButton() == MouseEvent.BUTTON1) {
                        SymbolSelection symbolSelection = new SymbolSelection(parent);
                        symbolSelection.setDialogListener(buttonPanel);
                        symbolSelection.setVisible(true);
                    }
                }
                
            });

            this.add(buttonPanel);
        }
    }

    public void updateNumpadSymbols(String primary, String secondary, int index) {
        buttons[index][0] = primary;
        buttons[index][1] = secondary;
    }
}

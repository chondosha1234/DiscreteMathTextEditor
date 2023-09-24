import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.*;

/**
 * A class that extends JPanel, so it can be instantiated and easily added in DiscreteMathEditor.
 * It will create a panel that is a grid that shows the
 * key mapping representation of your numpad so the user can reference it while typing.
 */
public class NumPad extends JPanel {
    
    private JPanel numPadGrid;

    public NumPad() {
        numPadGrid = new JPanel(new GridLayout(3, 3));

        JPanel numPad7 = new CellPanel(new BorderLayout());
        JLabel andSymbol = new JLabel("\u2227");
        numPad7.add(andSymbol);

        JPanel numPad8 = new CellPanel(new GridLayout(3,3));
        JLabel equivalentSymbol = new JLabel("\u2194");
        numPad8.add(equivalentSymbol);

        JPanel numPad9 = new CellPanel(new GridLayout(3,3));
        JLabel notSymbol = new JLabel("\u00AC");
        numPad9.add(notSymbol);

        JPanel numPad4 = new CellPanel(new GridLayout(3,3));
        JLabel existsSymbol = new JLabel("\u2227");
        numPad4.add(existsSymbol);

        JPanel numPad5 = new CellPanel(new GridLayout(3,3));
        JPanel numPad6 = new CellPanel(new GridLayout(3,3));
        JPanel numPad1 = new CellPanel(new GridLayout(3,3));
        JPanel numPad2 = new CellPanel(new GridLayout(3,3));
        JPanel numPad3 = new CellPanel(new GridLayout(3,3));

        numPadGrid.add(numPad7);
        numPadGrid.add(numPad8);
        numPadGrid.add(numPad9);
        numPadGrid.add(numPad4);
        numPadGrid.add(numPad5);
        numPadGrid.add(numPad6);
        numPadGrid.add(numPad1);
        numPadGrid.add(numPad2);
        numPadGrid.add(numPad3);
        this.add(numPadGrid);
    }
}

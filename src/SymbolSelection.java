import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.ListSelectionModel;

public class SymbolSelection extends JDialog {
    
    private DefaultListModel<String> symbolList;

    public SymbolSelection(JFrame parent) {

        super(parent, "Select Symbol", true);

        this.symbolList = new DefaultListModel<>();

        String[] symbols = {
            "\u2227", "\u2228", "\u00AC", "\u2234", "\u2192", "\u2194", "\u2261", "\u2262",
            "\u2203", "\u2200", "\u2282", "\u2286", "\u2208", "\u2209", "\u222A", "\u2229",
            "\u2265", "\u2264", "\u2260", "\u220E", "\u00B2", "\u2211"
        };

        for (String s : symbols) {
            symbolList.addElement(s);
        }

        JList<String> primarySymbolList = new JList<>(symbolList);
        JList<String> secondarySymbolList = new JList<>(symbolList);
        primarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        secondarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }



}

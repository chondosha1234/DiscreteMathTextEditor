import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;

public class SymbolSelection extends JDialog {
    
    private DialogListener dialogListener;
    private DefaultListModel<String> symbolList;
    private String primarySelected;
    private String secondarySelected;

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

        JLabel primaryLabel = new JLabel("Select primary symbol");
        JLabel secondaryLabel = new JLabel("Select secondary symbol");
        primaryLabel.setBorder(BorderFactory.createEmptyBorder(0,10,0,10));
        secondaryLabel.setBorder(BorderFactory.createEmptyBorder(0, 10, 0, 10));

        JList<String> primarySymbolList = new JList<>(symbolList);
        JList<String> secondarySymbolList = new JList<>(symbolList);
        primarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        secondarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        primarySymbolList.setSelectedIndex(0);
        secondarySymbolList.setSelectedIndex(0);

        JScrollPane primaryScrollPane = new JScrollPane(primarySymbolList);
        JScrollPane secondaryScrollPane = new JScrollPane(secondarySymbolList);
        primaryScrollPane.setPreferredSize(new Dimension(100, 200));
        secondaryScrollPane.setPreferredSize(new Dimension(100, 200));

        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("Cancel");
        confirm.setPreferredSize(new Dimension(100, 30));
        cancel.setPreferredSize(new Dimension(100, 30));
        
        confirm.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                // when confirm is pressed, set the return symbols to whatever is selected 
                // the lists have default indices, so they should never be null
                primarySelected = primarySymbolList.getSelectedValue();
                secondarySelected = secondarySymbolList.getSelectedValue();
                sendData(primarySelected, secondarySelected);
            }
            
        });

        cancel.addActionListener(new ActionListener(){
            // cancel just closes dialog
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }

        });

        this.setLayout(new GridLayout(3, 1));
        JPanel labels = new JPanel(new FlowLayout());
        JPanel lists = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout());

        this.add(labels);
        this.add(lists);
        this.add(buttons);

        labels.add(primaryLabel);
        labels.add(secondaryLabel);

        lists.add(primaryScrollPane);
        lists.add(secondaryScrollPane);
        
        buttons.add(confirm);
        buttons.add(cancel);

        this.setSize(400, 100);
        this.pack();
        this.setLocationRelativeTo(null);
    }

    public void setDialogListener(DialogListener listener) {
        this.dialogListener = listener;
    }

    private void sendData(String primary, String secondary) {
        if (dialogListener != null) {
            dialogListener.onDialogClose(primary, secondary);
        }
        dispose();
    }

}

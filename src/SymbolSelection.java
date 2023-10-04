import java.awt.BorderLayout;
import java.awt.Color;
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

        Color backgroundColor = new Color(30, 30, 30); // Dark background
        Color textColor = new Color(220, 220, 220); // Light text

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
        primaryLabel.setForeground(textColor);
        secondaryLabel.setForeground(textColor);

        JList<String> primarySymbolList = new JList<>(symbolList);
        JList<String> secondarySymbolList = new JList<>(symbolList);
        primarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        secondarySymbolList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        primarySymbolList.setSelectedIndex(0);
        secondarySymbolList.setSelectedIndex(0);
        primarySymbolList.setForeground(textColor);
        primarySymbolList.setBackground(backgroundColor);
        secondarySymbolList.setForeground(textColor);
        secondarySymbolList.setBackground(backgroundColor);

        JScrollPane primaryScrollPane = new JScrollPane(primarySymbolList);
        JScrollPane secondaryScrollPane = new JScrollPane(secondarySymbolList);
        primaryScrollPane.setPreferredSize(new Dimension(100, 200));
        secondaryScrollPane.setPreferredSize(new Dimension(100, 200));
        primaryScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        secondaryScrollPane.getVerticalScrollBar().setUI(new CustomScrollBarUI());
        primaryScrollPane.setBorder(null);
        secondaryScrollPane.setBorder(null);

        JButton confirm = new JButton("Confirm");
        JButton cancel = new JButton("Cancel");
        confirm.setPreferredSize(new Dimension(100, 30));
        cancel.setPreferredSize(new Dimension(100, 30));
        confirm.setForeground(textColor);
        confirm.setBackground(backgroundColor);
        cancel.setForeground(textColor);
        cancel.setBackground(backgroundColor);
        
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

        this.setLayout(new BorderLayout());
        JPanel labels = new JPanel(new FlowLayout());
        JPanel lists = new JPanel(new FlowLayout());
        JPanel buttons = new JPanel(new FlowLayout());

        this.add(labels, BorderLayout.NORTH);
        this.add(lists, BorderLayout.CENTER);
        this.add(buttons, BorderLayout.SOUTH);

        labels.add(primaryLabel);
        labels.add(secondaryLabel);
        //labels.setForeground(textColor);
        labels.setBackground(backgroundColor);

        lists.add(primaryScrollPane);
        lists.add(secondaryScrollPane);
        //lists.setForeground(textColor);
        lists.setBackground(backgroundColor);
        
        buttons.add(confirm);
        buttons.add(cancel);
        //buttons.setForeground(textColor);
        buttons.setBackground(backgroundColor);

        this.setForeground(textColor);
        this.setBackground(backgroundColor);
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

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.LayoutManager;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.LineBorder;

public class ButtonPanel extends JPanel implements DialogListener {

    private JLabel primarySymbol;
    private JLabel secondarySymbol;
    private int buttonIndex;

    public ButtonPanel(LayoutManager manager, int buttonIndex) {
        super(manager);
        this.setMaximumSize(new Dimension(50, 10));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new LineBorder(Color.BLACK));

        this.buttonIndex = buttonIndex;

        // initialize the labels, they will be set to defaults in numpad
        primarySymbol = new JLabel("");
        secondarySymbol = new JLabel("");

        primarySymbol.setFont(new Font("Dialog", Font.BOLD, 16)); 
        primarySymbol.setHorizontalAlignment(SwingConstants.CENTER); 
        secondarySymbol.setFont(new Font("Dialog", Font.PLAIN, 12)); 
        secondarySymbol.setHorizontalAlignment(SwingConstants.LEFT); 

        primarySymbol.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
        secondarySymbol.setBorder(BorderFactory.createEmptyBorder(0, 5, 5, 0));
        this.add(primarySymbol, BorderLayout.CENTER);
        this.add(secondarySymbol, BorderLayout.SOUTH);
    }

    @Override
    public void onDialogClose(String primary, String secondary) {
        setSymbols(primary, secondary);
        KeyMapper.setSelectedSymbols(primary, secondary, buttonIndex);
    }
    
    public void setSymbols(String primary, String secondary) {
        primarySymbol.setText(primary);
        secondarySymbol.setText(secondary);
    }

}

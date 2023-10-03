import java.awt.Color;
import java.awt.Dimension;
import java.awt.LayoutManager;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

public class ButtonPanel extends JPanel implements DialogListener {

    public ButtonPanel(LayoutManager manager) {
        super(manager);
        this.setMaximumSize(new Dimension(50, 10));
        this.setBackground(Color.LIGHT_GRAY);
        this.setBorder(new LineBorder(Color.BLACK));
    }

    @Override
    public void onDialogClose(String primary, String secondary) {
        
    }
    
}

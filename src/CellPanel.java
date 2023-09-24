import java.awt.*;
import javax.swing.*;

/**
 * This class represents one cell in the NumPad image.  It is used to paint the borders around the cells
 */
public class CellPanel extends JPanel {

    public CellPanel(LayoutManager manager) {
        super(manager);
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        ((Graphics2D) g).setStroke(new BasicStroke(2));
        g.drawRect(0, 0, getWidth() - 1, getHeight() - 1);
    }
}

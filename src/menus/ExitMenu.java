package menus;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ExitMenu implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        System.exit(0);
    }
    
}

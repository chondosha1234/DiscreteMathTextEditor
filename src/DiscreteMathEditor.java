import javax.swing.*;
import java.awt.*;


/* 
 *  Main class to instantiate the GUI 
 *  This class calls other classes like TopBarMenu and KeyMapper to create parts of the GUI and combines them 
 */
public class DiscreteMathEditor extends JFrame {

    private JPanel mainWindow;
    private JTextArea textArea;

    public DiscreteMathEditor() {

        setTitle("Discrete Math");
        setSize(1000, 650);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        mainWindow = new JPanel(new BorderLayout());
        getContentPane().add(mainWindow);

        // typical top bar menus like file, edit, settings
        TopBarMenu topBarMenu = new TopBarMenu();
        mainWindow.add(topBarMenu, BorderLayout.NORTH);

        // sidebar will hold information about the application for users
        JPanel sideBar = new JPanel(new BorderLayout());
        mainWindow.add(sideBar, BorderLayout.EAST);

        JLabel numPadInfo = new JLabel("These are the mappings of your numpad. Hold ctrl to use the secondary mappings. Make sure your numlock is on.");
        sideBar.add(numPadInfo, BorderLayout.NORTH);

        // a display to remind user the key mappings of the numpad
        JPanel numPad = new NumPad();
        sideBar.add(numPad, BorderLayout.CENTER);

        // main text writing area
        textArea = new JTextArea();

        // Dialog is a font that supports the correct unicode characters
        Font font = new Font("Dialog", Font.PLAIN, 24);
        textArea.setFont(font);

        Insets margin = new Insets(10,10,10,10);
        textArea.setMargin(margin);

        mainWindow.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        // create keymapper object and set it as the keyListener for the text area
        KeyMapper keyMapper = new KeyMapper(textArea);
        textArea.addKeyListener(keyMapper);
    }
}
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

        TopBarMenu topBarMenu = new TopBarMenu();
        mainWindow.add(topBarMenu, BorderLayout.NORTH);

        textArea = new JTextArea();

        Font font = new Font("Dialog", Font.PLAIN, 24);
        textArea.setFont(font);

        Insets margin = new Insets(10,10,10,10);
        textArea.setMargin(margin);

        mainWindow.add(new JScrollPane(textArea), BorderLayout.CENTER);
        
        KeyMapper keyMapper = new KeyMapper(textArea);
        textArea.addKeyListener(keyMapper);
    }
}
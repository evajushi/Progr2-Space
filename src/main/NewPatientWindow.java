import javax.swing.*;
import java.awt.*;

public class NewPatientWindow extends JFrame {
    private static final int WINDOW_WIDTH = 1200;
    private static final int WINDOW_HEIGHT = 800;
    private static final int LABEL_FONT_SIZE = 22;
    private static final int FIELD_WIDTH = 500;
    private static final int FIELD_HEIGHT = 30;
    
    public NewPatientWindow() {

        setTitle("Στοιχεία Ασθενή");
        setSize(WINDOW_WIDTH, WINDOW_HEIGHT);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }
  
}
